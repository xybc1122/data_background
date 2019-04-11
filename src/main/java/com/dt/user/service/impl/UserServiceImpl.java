package com.dt.user.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.dto.UserDto;
import com.dt.user.exception.LsException;
import com.dt.user.login.SsoWebLoginHelper;
import com.dt.user.mapper.UserMapper;
import com.dt.user.model.SystemLogStatus;
import com.dt.user.model.UserInfo;
import com.dt.user.model.UserRole;
import com.dt.user.netty.ChatType;
import com.dt.user.service.HrArchivesEmployeeService;
import com.dt.user.service.SystemLogStatusService;
import com.dt.user.service.UserRoleService;
import com.dt.user.service.UserService;
import com.dt.user.store.ChatStore;
import com.dt.user.toos.Constant;
import com.dt.user.toos.Constants;
import com.dt.user.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Date;

@Service
public class UserServiceImpl extends JsonData implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private HrArchivesEmployeeService hrService;


    @Autowired
    private ChatStore chatStore;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private SystemLogStatusService logStatusService;

    @Override
    public String serviceGetName(Long uId) {
        return userMapper.getName(uId);
    }

    @Override
    public UserInfo getUserStatus(Long uid) {
        return userMapper.getUserStatus(uid);
    }

    /**
     * 用户认证
     *
     * @param response
     * @param userDto
     * @return
     */
    @Override
    @Transactional
    public ResponseBase doGetAuthenticationInfo(HttpServletResponse response, UserDto userDto) {
        //查询用户信息 更新更新登陆时间
        UserInfo user = userMapper.findByUser(userDto.getUserName());
        try {
            // 账号不存在 异常
            if (user == null) {
                return JsonData.setResultError("未知账户/没找到帐号,登录失败");
            }
            if (user.getAccountStatus() == 1) {
                return JsonData.setResultError("账号已被锁定,请联系管理员");
            }
            if (user.getDelUser() == 1) {
                return JsonData.setResultError("账号凭着已过期/或删除 请联系管理员");
            }
            userMapper.upUserLandingTime(user.getUid(), new Date().getTime());

            chatStore.kickOut(userDto.getUserName() + "token", user.getUid(),
                    JsonUtils.getJsonTypeError("有人登陆,你被踢下线,若不是本人,请修改密码",
                            ChatType.KICK_OUT));

            String pwd = MD5Util.saltMd5(userDto.getUserName(), userDto.getPwd());
            // 登陆校验
            SsoWebLoginHelper.login(user, pwd);
            //设置token  Cookie
            JSONObject uJson = put(response, user, userDto.isRememberMe());

            //登陆成功后 删除Map指定元素
            if (Constant.errorPwdMap.get(user.getUserName()) != null) {
                Constant.errorPwdMap.entrySet().removeIf(entry -> entry.getKey().equals(user.getUserName()));
            }
            return JsonData.setResultSuccess(uJson);
        } catch (LsException ls) {
            return setLockingTime(userDto);
        }
    }

    private JSONObject put(HttpServletResponse response, UserInfo user, boolean ifRemember) {
        long time;
        if (ifRemember) {
            time = 60 * 60 * 24 * 7L;
        } else {
            time = 30 * 60L;
        }
        //设置 JwtToken
        String userToken = JwtUtils.genJsonWebToken(user);
        JSONObject uJson = new JSONObject();
        uJson.put("user", user);
        uJson.put("token", userToken);
        //设置token
        redisService.setString(user.getUserName() + Constants.TOKEN, userToken, time);
        //设置Cookie
        CookieUtil.set(response, Constants.TOKEN, userToken, ifRemember);
        return uJson;
    }

    private ResponseBase setLockingTime(UserDto userDto) {
        int errorNumber = 0;
        errorNumber++;
        Long lockingTime = null;
        //报错后 先进来看看 这个账号有没有在hashMap里 ---如果里面有 进去
        if (Constant.errorPwdMap.get(userDto.getUserName()) != null) {
            Constant.errorPwdMap.put(userDto.getUserName(), errorNumber + Constant.errorPwdMap.get(userDto.getUserName()));
        } else {
            Constant.errorPwdMap.put(userDto.getUserName(), errorNumber);
        }
        if (Constant.errorPwdMap.get(userDto.getUserName()) >= 4) {
            switch (Constant.errorPwdMap.get(userDto.getUserName())) {
                case 4:
                    lockingTime = 6L * 5;
                    break;
                case 5:
                    lockingTime = 60L * 5;
                    break;
                case 6:
                    lockingTime = 60L * 15;
                    break;
                case 7:
                    lockingTime = 60L * 60 * 24;
                    break;
            }
            redisService.setString(userDto.getUserName() + "error", "error", lockingTime);
            return JsonData.setResultError("账号被锁定!" + lockingTime + "秒");
        }
        return JsonData.setResultError("账号或密码错误/你还有" + (4 - Constant.errorPwdMap.get(userDto.getUserName()) + "次机会"));
    }

    @Override
    public List<UserInfo> findByUsers(UserDto pageDto) {
        return userMapper.findByUsers(pageDto);
    }


    @Override
    public UserInfo getSingleUser(Long id) {
        return userMapper.getSingleUser(id);
    }


    @Override
    public int delUserInfo(String uidIds) {
        return userMapper.delUserInfo(uidIds);
    }

    @Override
    public int reUserInfo(String uidIds) {
        return userMapper.reUserInfo(uidIds);
    }

    @Override
    public List<UserInfo> findByDelUserInfo() {
        return userMapper.findByDelUserInfo();
    }

    @Override
    public UserInfo getUserName(String userName) {
        return userMapper.getUserName(userName);
    }


    @Override
    public List<UserInfo> getByUsers() {

        return userMapper.getByUsers();
    }

    @Override
    public int upUserPwd(Long uid, String pwd) {
        return userMapper.upUserPwd(uid, pwd);
    }


    /**
     * 处理用户新增
     *
     * @param userMap
     * @return
     */
    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public ResponseBase saveUserInfo(Map<String, Object> userMap) {
        //获得登陆的时候 生成的token
        String userName = (String) userMap.get("userName");
        String pwd = (String) userMap.get("pwd");
        Boolean checkedUpPwd = (Boolean) userMap.get("pwdAlways");
        Boolean checkedUserAlways = (Boolean) userMap.get("uAlways");
        Boolean checkedPwdAlways = (Boolean) userMap.get("pwdAlways");
        Integer staffValue = (Integer) userMap.get("staffValue");
        List<Integer> rolesId = (List<Integer>) userMap.get("rolesId");
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(pwd) || checkedUpPwd == null
                || checkedUserAlways == null || checkedPwdAlways == null || staffValue == null || rolesId == null) {
            return JsonData.setResultError("新增失败");
        }
        //这里前端会传空字符串 或者 Long类型数据 要判断
        UserInfo userInfo = new UserInfo();
        //首次登陆是否修改密码
        if (checkedUpPwd) {
            userInfo.setFirstLogin(true);
        } else {
            userInfo.setFirstLogin(false);
        }
        userInfo.setUserName(userName);
        String md5Pwd = MD5Util.saltMd5(userName, pwd);
        userInfo.setPwd(md5Pwd);
        //如果点击了   用户始终有效
        if (checkedUserAlways) {
            userInfo.setUserExpirationDate(0L);
        } else {
            Long userExpirationDate = (Long) userMap.get("userExpirationDate");
            //设置 用户有效时间
            userInfo.setUserExpirationDate(userExpirationDate);
        }
        //如果点击了   密码始终有效
        if (checkedPwdAlways) {
            userInfo.setPwdValidityPeriod(0L);
        } else {
            //前台会传2个类型参数 根据判断转换 来设计 用户 密码有效时间
            Integer pwdValidityPeriod = (Integer) userMap.get("pwdValidityPeriod");
            userInfo.setPwdValidityPeriod(DateUtils.getRearDate(pwdValidityPeriod));
        }
        SystemLogStatus logStatus = logStatusService.serviceSaveSysStatusInfo();
        userInfo.setStatusId(logStatus.getStatusId());
        //新增用户
        userMapper.saveUserInfo(userInfo);
        Long uid = userInfo.getUid();
        Long sid = staffValue.longValue();
        //关联员工信息 更新
        hrService.bindHrInfo(uid, sid);
        //新增角色信息
        List<UserRole> urList = new ArrayList<>();
        UserRole userRole = new UserRole();
        userRole.setuId(uid);
        userRole.setrIds(rolesId);
        urList.add(userRole);
        userRoleService.addUserRole(urList);
        return JsonData.setResultSuccess("新增成功");
    }

    /**
     * 处理更新用户修改信息
     *
     * @param userMap
     * @return
     */
    @Override
    @Transactional
    public ResponseBase updateUserInfo(Map<String, Object> userMap) {
        //更新用户信息
        int updateResult = userMapper.upUser(userMap);
        if (updateResult != 1) {
            return JsonData.setResultError("更新失败,请重新操作");
        }
        String uMobilePhone = (String) userMap.get("mobilePhone");
        if (StringUtils.isNotBlank(uMobilePhone)) {
            //更新员工信息
            hrService.upHrInfo(userMap);
        }
        //先判断是否为空
        String pwd = (String) userMap.get("pwd");
        //如果不是空 说明已经修改了密码
        if (StringUtils.isNotBlank(pwd)) {
            Integer uid = (Integer) userMap.get("uid");
            String userName = (String) userMap.get("userName");
            //踢出用户 如果是null  说明没有这个用户在线
            chatStore.kickOut(userName + "token", uid.longValue(),
                    JsonUtils.getJsonTypeError("管理员修改密码,你被踢出",
                            ChatType.KICK_OUT));
        }
        return JsonData.setResultSuccess("更新成功");
    }

}

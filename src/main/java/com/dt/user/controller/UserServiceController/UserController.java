package com.dt.user.controller.UserServiceController;

import com.dt.user.customize.PermissionCheck;
import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.dto.UserDto;
import com.dt.user.model.UserInfo;
import com.dt.user.model.UserRole;
import com.dt.user.service.HrArchivesEmployeeService;
import com.dt.user.service.UserRoleService;
import com.dt.user.service.UserService;
import com.dt.user.utils.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RequestMapping("/api/v1/user")
@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private HrArchivesEmployeeService hrService;

    @Autowired
    private UserRoleService userRoleService;


    /**
     * 获取用户管理信息的一些信息
     *
     * @param pageDto
     * @return
     * @PermissionCheck 自定义权限 需要show 才能查看
     */
    @PostMapping("/show")
    @PermissionCheck("show")
    public ResponseBase showUsers(@RequestBody UserDto pageDto) {
        PageInfoUtils.setPage(pageDto.getPageSize(), pageDto.getCurrentPage());
        List<UserInfo> listUser = userService.findByUsers(pageDto);
        return PageInfoUtils.returnPage(listUser, pageDto.getCurrentPage());
    }


    /**
     * 获得所有用户信息
     *
     * @return
     */
    @GetMapping("/getUsers")
    public ResponseBase getUsers() {
        return JsonData.setResultSuccess(userService.getByUsers());
    }

    /**
     * 更新用户信息
     *
     * @return
     */
    @PostMapping("/upUserInfo")
    @Transactional
    public ResponseBase userInfoUp(@RequestBody Map<String, Object> userMap) {
        //更新用户信息
        try {
            int updateResult = userService.upUser(userMap);
            if (updateResult != 1) {
                throw new Exception("更新失败,请重新操作");
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
                //踢出用户 如果是null  说明没有这个用户在线

            }
            return JsonData.setResultSuccess("更新成功");
        } catch (Exception e) {
            return JsonData.setResultError(e.getMessage());
        }
    }


    /**
     * 删除用户信息
     *
     * @return
     */
    @PostMapping("/delUserInfo")
    public ResponseBase userInfoDel(@RequestBody Map<String, Object> delMap) {
        int count = userService.delUserInfo(delMap.get("ids").toString());
        if (count > 0) {
            return JsonData.setResultSuccess(count);
        }
        return JsonData.setResultError("删除失败~");
    }

    /**
     * 恢复用户信息
     *
     * @return
     */
    @PostMapping("/reUserInfo")
    public ResponseBase userInfoRe(@RequestBody Map<String, Object> reMap) {
        int count = userService.reUserInfo(reMap.get("ids").toString());
        if (count > 0) {
            return JsonData.setResultSuccess(count);
        }
        return JsonData.setResultError("恢复失败~");
    }

    /**
     * 获得一个用户的信息
     *
     * @return JSON 对象
     */
    @GetMapping("/getUser")
    public ResponseBase getUser() {
        Long userId = RequestUtils.getUid();
        if (userId == null) {
            return JsonData.setResultError("用户无效");
        }
        UserInfo userInfo = userService.getSingleUser(userId);
        return JsonData.setResultSuccess(userInfo);
    }


    /**
     * 获得历史删除的用户信息
     *
     * @param pageDto 用户对象
     * @return JSON 对象
     */
    @PostMapping("/getDelUser")
    public ResponseBase getDelUser(@RequestBody UserDto pageDto) {
        PageHelper.startPage(pageDto.getCurrentPage(), pageDto.getPageSize());
        List<UserInfo> userDel = userService.findByDelUserInfo();
        PageInfo<UserInfo> pageInfo = new PageInfo<>(userDel);
        Integer currentPage = pageDto.getCurrentPage();
        return JsonData.setResultSuccess(PageInfoUtils.getPage(pageInfo, currentPage));
    }

    /**
     * 查询用户名字是否存在
     *
     * @param userName 账号名
     * @return JSON 对象
     */
    @GetMapping("/getUserName")
    public ResponseBase getUserName(@RequestParam("userName") String userName) {
        UserInfo userInfoName = userService.getUserName(userName);
        return JsonData.setResultSuccess(userInfoName);
    }

    /**
     * 新增用户
     *
     * @param userMap 前端传的数据
     * @param request request 对象
     * @return JSON 对象
     */
    @Transactional //事物
    @PostMapping("/saveUserInfo")
    public ResponseBase saveUserInfo(@RequestBody Map<String, Object> userMap, HttpServletRequest request) {
        //获得登陆的时候 生成的token
        //获得用户信息
        UserInfo user = CookieUtil.getUser(request);
        if (user == null) {
            return JsonData.setResultError("用户token失效");
        }
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
        String md5Pwd = MD5Util.MD5(pwd);
        userInfo.setPwd(md5Pwd);
        userInfo.setCreateDate(new Date().getTime());
        userInfo.setCreateIdUser(user.getUid());
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
        //新增用户
        userService.saveUserInfo(userInfo);
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
     * 设置了 首次登陆修改密码的接口
     *
     * @param uInfo 前端传的对象
     * @return
     */
    @PostMapping("/upPwd")
    public ResponseBase upUserPwd(@RequestBody UserInfo uInfo, HttpServletRequest request) {
        UserInfo user = CookieUtil.getUser(request);
        if (user == null) {
            return JsonData.setResultError("用户token失效");
        }
        if (StringUtils.isNotBlank(uInfo.getPwd()) && StringUtils.isNotBlank(user.getUserName())) {
            //md5盐值密码加密
            String md5Pwd = MD5Util.MD5(uInfo.getPwd());
            //更新用户
            int uCount = userService.upUserPwd(user.getUid(), md5Pwd);
            if (uCount > 0) {
                return JsonData.setResultSuccess("密码修改成功");
            }
        }
        return JsonData.setResultError("密码修改失败");
    }

}

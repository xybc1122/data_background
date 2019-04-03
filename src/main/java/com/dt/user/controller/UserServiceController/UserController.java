package com.dt.user.controller.UserServiceController;

import com.dt.user.config.BaseRedisService;
import com.dt.user.customize.PermissionCheck;
import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.dto.UserDto;
import com.dt.user.model.SystemLogStatus;
import com.dt.user.model.UserInfo;
import com.dt.user.model.UserRole;
import com.dt.user.service.HrArchivesEmployeeService;
import com.dt.user.service.SystemLogStatusService;
import com.dt.user.service.UserRoleService;
import com.dt.user.service.UserService;
import com.dt.user.store.SsoLoginStore;
import com.dt.user.toos.Constants;
import com.dt.user.utils.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RequestMapping("/api/v1/user")
@RestController
public class UserController {


    @Autowired
    private UserService userService;


    @Autowired
    private BaseRedisService redisService;


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
    public ResponseBase userInfoUp(@RequestBody Map<String, Object> userMap) {
        return userService.updateUserInfo(userMap);
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
        Long userId = ReqUtils.getUid();
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
     * @return JSON 对象
     */
    @PostMapping("/saveUserInfo")
    public ResponseBase saveUserInfo(@RequestBody Map<String, Object> userMap) {
        return userService.saveUserInfo(userMap);
    }

    /**
     * 设置了 首次登陆修改密码的接口
     *
     * @param uInfo 前端传的对象
     * @return
     */
    @PostMapping("/upPwd")
    public ResponseBase upUserPwd(@RequestBody UserInfo uInfo, HttpServletResponse response, HttpServletRequest request) {
        if (StringUtils.isNotBlank(uInfo.getPwd()) && StringUtils.isNotBlank(ReqUtils.getUserName())) {
            //md5盐值密码加密
            String md5Pwd = MD5Util.saltMd5(ReqUtils.getUserName(), uInfo.getPwd());
            //更新用户
            int uCount = userService.upUserPwd(ReqUtils.getUid(), md5Pwd);
            if (uCount > 0) {
                //删除redis token
                redisService.delKey(ReqUtils.getUserName() + Constants.TOKEN);
                //删除 cookie里的  token
                SsoLoginStore.removeTokenByCookie(request, response);
                return JsonData.setResultSuccess("密码修改成功");
            }
        }
        return JsonData.setResultError("密码修改失败");
    }

}

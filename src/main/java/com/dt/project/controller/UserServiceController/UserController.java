package com.dt.project.controller.userServiceController;


import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.model.UserInfo;
import com.dt.project.service.RedisService;
import com.dt.project.service.systemService.SystemUserConfigService;
import com.dt.project.service.UserService;
import com.dt.project.store.SsoLoginStore;
import com.dt.project.toos.Constants;
import com.dt.project.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/api/v1/user")
@RestController
public class UserController {


    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private SystemUserConfigService configService;

    /**
     * 新增用户配置
     *
     * @return
     */
    @PostMapping("/saveUserConfig")
    public ResponseBase setUserConfig(@RequestBody Map<String, Object> confMap) {
        return configService.saveUserConfig(confMap);
    }

    /**
     * 获取用户配置
     *
     * @param mid
     * @return
     */
    @GetMapping("/getUserConfig")
    public ResponseBase getUserConfig(@RequestParam("mid") Integer mid) {
        return configService.getConfig(mid);
    }

    /**
     * 修改用户配置
     *
     * @param confMap
     * @return
     */
    @PostMapping("/upUserConfig")
    public ResponseBase upUserConfig(@RequestBody Map<String, Object> confMap) {
        return configService.upConfig(confMap);
    }

    /**
     * 删除用户配置
     *
     * @param confMap
     * @return
     */
    @PostMapping("/delUserConfig")
    public ResponseBase delUserConfig(@RequestBody Map<String, Object> confMap) {
        return configService.delConfig(confMap);
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

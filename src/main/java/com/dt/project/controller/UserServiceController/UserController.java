package com.dt.project.controller.UserServiceController;


import com.alibaba.fastjson.JSONObject;
import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.model.UserInfo;
import com.dt.project.service.RedisService;
import com.dt.project.service.UserService;
import com.dt.project.store.SsoLoginStore;
import com.dt.project.toos.Constants;
import com.dt.project.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/api/v1/user")
@RestController
public class UserController {


    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;

    /**
     * 用户配置
     *
     * @return
     */
    @PostMapping("/saveUserConfig")
    public ResponseBase setUserConfig(@RequestBody Map<String, Object> confMap) {
        Integer mid = (Integer) confMap.get("mid");
        String programName = (String) confMap.get("programName");
        if (mid == null || programName == null) {
            return JsonData.setResultError("error");
        }
        String configKey = Constants.USER_CONFIG + ReqUtils.getUid() + "/" + mid + "/" + programName;
        String redisValue = redisService.getStringKey(configKey);
        if (redisValue != null) {
            return JsonData.setResultError("保存方案名相同");
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hiddenFieldsList", confMap.get("hiddenFieldsList"));
        jsonObject.put("queryTwoList", confMap.get("queryTwoList"));
        jsonObject.put("inputQueryData", confMap.get("inputQueryData"));
        jsonObject.put("mid", mid);
        jsonObject.put("uid", ReqUtils.getUid());
        jsonObject.put("programName", programName);
        jsonObject.put("createDate", new Date().getTime());
        redisService.setString(Constants.USER_CONFIG + ReqUtils.getUid() + "/" + mid + "/" + programName, jsonObject.toJSONString());
        return JsonData.setResultSuccess("success");
    }

    /**
     * 拿取用户配置
     *
     * @param mid
     * @param programName
     * @return
     */
    @GetMapping("/getUserConfig")
    public ResponseBase getUserConfig(@RequestParam("mid") Integer mid, @RequestParam("programName") String programName) {
        String configKey = Constants.USER_CONFIG + ReqUtils.getUid() + "/" + mid + "/" + programName;
        return JsonData.setResultSuccess("success", JSONObject.parseObject(redisService.getStringKey(configKey)));
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

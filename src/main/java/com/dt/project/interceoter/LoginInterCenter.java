package com.dt.project.interceoter;

import com.dt.project.config.ApplicationContextRegister;
import com.dt.project.config.JsonData;
import com.dt.project.model.UserInfo;
import com.dt.project.service.impl.RedisService;
import com.dt.project.service.UserService;
import com.dt.project.toos.Constants;
import com.dt.project.utils.JwtUtils;
import com.dt.project.utils.MD5Util;
import com.dt.project.utils.ReqUtils;
import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 监听器
 */
public class LoginInterCenter implements HandlerInterceptor {
    private static Gson gson = new Gson();

    /**
     * 用户登录进入controller层之前 进行拦截
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        system.out.println("监听器过滤");
        System.out.println(request.getRequestURL());
        UserService userService = ApplicationContextRegister.getBean(UserService.class);
        RedisService redisService = ApplicationContextRegister.getBean(RedisService.class);
        String token = request.getHeader("token");
        if (token == null) {
            //尝试去参数里面获取看看
            token = request.getParameter("token");
        }
        if (StringUtils.isNotBlank(token)) {
            Claims claims = JwtUtils.checkJWT(token);
            if (claims != null) {
                Integer uId = (Integer) claims.get("id");
                String uName = (String) claims.get("name");
                String rId = (String) claims.get("rId");
                //查询redis中的token
                String vRedis = redisService.getStringKey(Constants.TOKEN + ":" + uId);
                //如果是null 说明 token 已经过期
                if (StringUtils.isEmpty(vRedis)) {
                    sendJsonMessage(response, JsonData.setResultError(Constants.HTTP_RESP_CODE, "令牌失效，请重新登陆"));
                    return false;
                }
                //说明前面已经有人在登陆
                if (!vRedis.equals(token)) {
                    sendJsonMessage(response, JsonData.setResultError(Constants.HTTP_RESP_CODE, "已有人登陆此账号"));
                    return false;
                }
                //通过ID 查询 账号状态
                UserInfo user = userService.getUserStatus(uId.longValue());
                // 账号不存在 异常
                if (user == null) {
                    sendJsonMessage(response, JsonData.setResultError(Constants.HTTP_RESP_CODE, "未知账户/没找到帐号,登录失败"));
                    return false;
                }
                if (user.getAccountStatus() == 1) {
                    sendJsonMessage(response, JsonData.setResultError(Constants.HTTP_RESP_CODE, "账号已被锁定,请联系管理员"));
                    return false;
                }
                if (user.getDelOrNot() == 1) {
                    sendJsonMessage(response, JsonData.setResultError(Constants.HTTP_RESP_CODE, "账号凭着已过期/或删除 请联系管理员"));
                    return false;
                }
                //首次登陆修改密码接口
                if (request.getRequestURI().equals("/api/v1/project/upPwd")) {
                    ReqUtils.set(request, uId, uName, rId);
                    return true;
                }
                //如果请求的是超级管理员配置接口
                if (request.getRequestURI().contains("/api/v1/admin")) {
                    String redisValue = redisService.getStringKey(Constants.ADMIN + uId);
                    if (StringUtils.isBlank(redisValue)) {
                        sendJsonMessage(response, JsonData.setResultError(Constants.HTTP_RES_CODE, "你不是超级管理员"));
                        return false;
                    }
                    String v = MD5Util.MD5(Constants.ADMIN + uId + uName);
                    if (!redisValue.equals(v)) {
                        sendJsonMessage(response, JsonData.setResultError(Constants.HTTP_RES_CODE, "管理员令牌不匹配"));
                        return false;
                    }
                }
                //首次登陆 需要修改密码
                if (user.getFirstLogin()) {
                    sendJsonMessage(response, JsonData.setResultError(Constants.FIRST_CODE, "首次登陆修改密码"));
                    return false;
                }
                ReqUtils.set(request, uId, uName, rId);
                return true;
            }
            sendJsonMessage(response, JsonData.setResultError(Constants.HTTP_RESP_CODE, "令牌错误 请重新登陆"));
            return false;
        }
        sendJsonMessage(response, JsonData.setResultError(Constants.HTTP_RESP_CODE, "请登录"));
        return false;
    }

    /**
     * 响应数据给前端
     *
     * @param response
     */
    public static void sendJsonMessage(HttpServletResponse response, Object obj) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(gson.toJson(obj));
        writer.close();
        response.flushBuffer();
    }
}

package com.dt.user.interceoter;

import com.dt.user.config.ApplicationContextRegister;
import com.dt.user.config.BaseRedisService;
import com.dt.user.config.JsonData;
import com.dt.user.model.UserInfo;
import com.dt.user.service.UserService;
import com.dt.user.toos.Constants;
import com.dt.user.utils.JwtUtils;
import com.dt.user.utils.ReqUtils;
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
public class LoginInterceoter implements HandlerInterceptor {
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
        System.out.println("监听器过滤");
        System.out.println(request.getRequestURI());
        UserService userService = ApplicationContextRegister.getBean(UserService.class);
        BaseRedisService redisService = ApplicationContextRegister.getBean(BaseRedisService.class);
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
                //查询redis中的token
                String vRedis = redisService.getStringKey(uName + "token");
                //如果是null 说明 token 已经过期
                if (StringUtils.isEmpty(vRedis)) {
                    sendJsonMessaget(response, JsonData.setResultError(Constants.HTTP_RESP_CODE, "令牌失效，请重新登陆"));
                    return false;
                }
                //说明前面已经有人在登陆
                if (!vRedis.equals(token)) {
                    sendJsonMessaget(response, JsonData.setResultError(Constants.HTTP_RESP_CODE, "已有人登陆此账号"));
                    return false;
                }
                //通过ID 查询 账号状态
                UserInfo user = userService.getUserStatus(uId.longValue());
                // 账号不存在 异常
                if (user == null) {
                    sendJsonMessaget(response, JsonData.setResultError(Constants.HTTP_RESP_CODE, "未知账户/没找到帐号,登录失败"));
                    return false;
                }
                if (user.getAccountStatus() == 1) {
                    sendJsonMessaget(response, JsonData.setResultError(Constants.HTTP_RESP_CODE, "账号已被锁定,请联系管理员"));
                    return false;
                }
                if (user.getDelUser() == 1) {
                    sendJsonMessaget(response, JsonData.setResultError(Constants.HTTP_RESP_CODE, "账号凭着已过期/或删除 请联系管理员"));
                    return false;
                }
                //首次登陆修改密码接口
                if (request.getRequestURI().equals("/api/v1/user/upPwd")) {
                    ReqUtils.set(request, uId, uName);
                    return true;
                }
                //首次登陆 需要修改密码
                if (user.getFirstLogin()) {
                    sendJsonMessaget(response, JsonData.setResultError(Constants.FIRST_CODE, "首次登陆修改密码"));
                    return false;
                }
                ReqUtils.set(request, uId, uName);
                return true;
            }
            sendJsonMessaget(response, JsonData.setResultError(Constants.HTTP_RESP_CODE, "令牌错误 请重新登陆"));
            return false;
        }
        sendJsonMessaget(response, JsonData.setResultError(Constants.HTTP_RESP_CODE, "请登录"));
        return false;
    }

    /**
     * 响应数据给前端
     *
     * @param response
     */
    public static void sendJsonMessaget(HttpServletResponse response, Object obj) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(gson.toJson(obj));
        writer.close();
        response.flushBuffer();
    }
}

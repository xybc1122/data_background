package com.dt.user.interceoter;

import com.dt.user.config.ApplicationContextRegister;
import com.dt.user.config.JsonData;
import com.dt.user.model.UserInfo;
import com.dt.user.service.UserService;
import com.dt.user.utils.JwtUtils;
import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
        UserService userService = ApplicationContextRegister.getBean(UserService.class);
        String token = request.getHeader("token");
        if (token == null) {
            //尝试去参数里面获取看看
            token = request.getParameter("token");
        }
        if (token != null) {
            Claims claims = JwtUtils.checkJWT(token);
            if (claims != null) {
                Integer uId = (Integer) claims.get("id");
                String uName = (String) claims.get("name");
                request.setAttribute("uId", uId);
                request.setAttribute("uName", uName);
                //通过ID 查询 账号状态
                UserInfo user = userService.getUserStatus(uId.longValue());
                // 账号不存在 异常
                if (user == null) {
                    sendJsonMessaget(response, JsonData.setResultError("未知账户/没找到帐号,登录失败"));
                    return false;
                }
                if (user.getAccountStatus() == 1) {
                    sendJsonMessaget(response, JsonData.setResultError("账号已被锁定,请联系管理员"));
                    return false;
                }
                if (user.getDelUser() == 1) {
                    sendJsonMessaget(response, JsonData.setResultError("账号凭着已过期/或删除 请联系管理员"));
                    return false;
                }
                return true;
            }
            sendJsonMessaget(response, JsonData.setResultError("token错误 请重新登陆"));
            return false;
        }
        //如果是登陆接口
        if (request.getRequestURI().equals("/login/ajaxLogin")) {
            return true;
        }
        sendJsonMessaget(response, JsonData.setResultError("请登录"));
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

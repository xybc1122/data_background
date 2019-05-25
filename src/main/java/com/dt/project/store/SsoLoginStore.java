package com.dt.project.store;

import com.dt.project.exception.LsException;
import com.dt.project.model.UserInfo;
import org.springframework.stereotype.Component;
import com.dt.project.toos.Constants;
import com.dt.project.utils.CookieUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * local ssologin store
 */
@Component
public class SsoLoginStore {
    /**
     * 删除 token,Cookie
     *
     * @param request
     * @param response
     */
    public static void removeTokenByCookie(HttpServletRequest request, HttpServletResponse response) {
        CookieUtil.remove(request, response, Constants.TOKEN);
    }

    /**
     * client ssologin
     */
    public static void login(UserInfo user, String pwd) {
        if (!user.getPwd().equals(pwd)) {
            throw new LsException("密码错误");
        }
        user.setPwd(null);
        user.setLandingTime(new Date().getTime());
    }

}

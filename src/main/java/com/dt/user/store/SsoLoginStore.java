package com.dt.user.store;

import org.springframework.stereotype.Component;
import com.dt.user.toos.Constants;
import com.dt.user.utils.CookieUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

}

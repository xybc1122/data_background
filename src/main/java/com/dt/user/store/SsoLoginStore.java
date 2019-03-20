package com.dt.user.store;

import com.dt.user.toos.Constants;
import com.dt.user.utils.CookieUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * local login store
 */
public class SsoLoginStore {

    /**
     * client logout, cookie only
     *
     * @param request
     * @param response
     */
    public static void removeTokenByCookie(HttpServletRequest request, HttpServletResponse response) {
        CookieUtil.remove(request, response, Constants.TOKEN);
    }

}

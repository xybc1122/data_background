package com.dt.user.store;

import org.springframework.stereotype.Component;
import com.dt.user.toos.Constants;
import com.dt.user.utils.CookieUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * local login store
 *
 * @author xuxueli 2018-04-02 20:03:11
 */
@Component
public class SsoLoginStore {
    /**
     * 删除 token
     *
     * @param request
     * @param response
     */
    public static void removeTokenByCookie(HttpServletRequest request, HttpServletResponse response) {
        CookieUtil.remove(request, response, Constants.TOKEN);
    }

}

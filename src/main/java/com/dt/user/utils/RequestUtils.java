package com.dt.user.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName RequestUtils
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/15 16:55
 **/
public class RequestUtils {


    /**
     * 获得用户ID
     * @return
     */
    public static Long getUid() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = requestAttributes.getRequest();
            Integer uId = (Integer) request.getAttribute("uId");
            if (uId != null) {
                return uId.longValue();
            }
        }
        return null;
    }


    /**
     * 获得用户ID
     *
     * @return
     */
    public static String getUserName() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = requestAttributes.getRequest();
            String uName = (String) request.getAttribute("uName");
            if (StringUtils.isNotBlank(uName)) {
                return uName;
            }
        }
        return null;
    }
}

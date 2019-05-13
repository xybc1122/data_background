package com.dt.user.utils;

import java.util.Map;

/**
 * @ClassName ObjUtils
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/13 15:50
 **/
public class ObjUtils {
    /**
     * obj转map
     *
     * @param obj
     * @return
     */
    public static Map<?, ?> objectToMap(Object obj) {
        if (obj == null) {
            return null;
        }
        return new org.apache.commons.beanutils.BeanMap(obj);
    }
}

package com.dt.project.utils;

import com.dt.project.exception.LsException;
import org.apache.commons.lang3.ObjectUtils;

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

    public static void isObjNull(Object obj1, Object obj2) {
        boolean b = ObjectUtils.allNotNull(obj1, obj2);
        if (!b) {
            throw new LsException("error");
        }
    }
}

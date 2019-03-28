package com.dt.user.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @ClassName JsonUtils
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/28 13:40
 **/
public class JsonUtils {

    public static String json(List<String> sqlHead) {
        JSONObject object = new JSONObject();
        object.put("设置的信息", sqlHead);
        return object.toJSONString();
    }

}

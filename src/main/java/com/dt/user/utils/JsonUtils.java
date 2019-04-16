package com.dt.user.utils;

import com.alibaba.fastjson.JSONObject;
import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.netty.ChatType;

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

    /**
     * Object 转换string
     *
     * @return
     */
    public static String getJsonObj(Object obj) {

        return JSONObject.toJSONString(obj);
    }

    /**
     * 成功  转换string
     *
     * @param msg
     * @param type
     * @return
     */
    public static String getJsonTypeSuccess(String msg, ChatType type) {

        return JSONObject.toJSONString(JsonData.setResultTypeSuccess(msg, type.toString()));
    }


    /**
     * 失败  转换string
     *
     * @param msg
     * @param type
     * @return
     */
    public static String getJsonTypeError(String msg, ChatType type) {

        return JSONObject.toJSONString(JsonData.setResultTypeError(msg, type.toString()));
    }

    /**
     * 新增消息
     *
     * @param result
     * @return
     */
    public static ResponseBase saveMsg(int result) {
        if (result != 0) {
            return JsonData.setResultSuccess("新增成功");
        }
        return JsonData.setResultError("新增失败");
    }
}

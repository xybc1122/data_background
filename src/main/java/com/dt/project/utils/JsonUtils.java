package com.dt.project.utils;

import com.alibaba.fastjson.JSONObject;
import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.netty.websocket.ChatType;

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
            return JsonData.setResultSuccess("success");
        }
        return JsonData.setResultError("error");
    }
}

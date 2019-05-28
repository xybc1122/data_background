package com.dt.project.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.exception.LsException;
import com.dt.project.netty.websocket.ChatType;

import java.util.List;

/**
 * @ClassName JsonUtils
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/28 13:40
 **/
public class JsonUtils {
    /**
     * 上传文件 文件跟数据库对比失败 前端设置返回
     *
     * @param sqlHead
     * @param fileHead
     * @return
     */
    public static String json(List<String> sqlHead, List<String> fileHead) {
        JSONObject object = new JSONObject();
        object.put("sqlHead", sqlHead);
        object.put("fileHead", fileHead);
        return object.toJSONString();
    }

    /**
     * obj转换对象
     *
     * @param obj
     * @param tClass
     * @return
     */
    public static Object objConversion(Object obj, Class<?> tClass) {
        return JSON.parseObject(getJsonObj(obj), tClass);
    }

    /**
     * Object 转换Array;
     *
     * @return
     */
    public static JSONArray getJsonArr(Object obj) {

        return JSONArray.parseArray(getJsonObj(obj));
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
     * 新增返回消息
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


    /**
     * 如果新增失败直接报错
     *
     * @param result
     * @return
     */
    public static void saveResult(int result) {
        if (result == 0) {
            throw new LsException("新增失败");
        }
    }
}

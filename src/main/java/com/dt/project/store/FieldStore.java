package com.dt.project.store;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;;
import com.dt.project.toos.Constants;
import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.Field;

/**
 * @ClassName FieldStore
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/19 15:09
 **/
public class FieldStore {

    /**
     * 反射封装前端动态参数查询
     *
     * @param json
     * @param v
     * @param sql
     * @throws IllegalAccessException
     */
    public static void query(Class tClass, JSONArray json, Object v, SQL sql,String alias) throws IllegalAccessException {
        if (v == null) {
            return;
        }
        Field[] fields = tClass.getDeclaredFields();
        for (Field rfModel : fields) {
            rfModel.setAccessible(true);
            Object obj = rfModel.get(v);
            if (obj != null) {
                if (json.size() > 0) {
                    for (int i = 0; i < json.size(); i++) {
                        JSONObject job = json.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象// 得到 每个对象中的属性值
                        if (job.get("jName").equals(rfModel.getName())) {
                            //这里主要做查询  // rfModel.get(v) 要从对象中提取表示字段的值的对象。
                            AppendSqlStore.sqlWhere(obj, job.get("sName").toString(), sql, Constants.SELECT, alias);
                            break;
                        }
                    }
                }
            }
        }
    }
}

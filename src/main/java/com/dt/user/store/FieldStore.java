package com.dt.user.store;

import com.dt.user.model.JavaSqlName;
import com.dt.user.toos.Constants;
import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.Field;
import java.util.List;

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
     * @param fields
     * @param info
     * @param v
     * @param sql
     * @throws IllegalAccessException
     */
    public static void query(Field[] fields, List<JavaSqlName> info, Object v, SQL sql) throws IllegalAccessException {
        for (Field rfModel : fields) {
            rfModel.setAccessible(true);
            for (JavaSqlName javaSqlName : info) {
                if (javaSqlName.getjName().equals(rfModel.getName())) {
                    AppendSqlStore.sqlWhere(rfModel.get(v), javaSqlName.getSqlName(), sql, Constants.SELECT);
                    break;
                }
            }
        }
    }

}

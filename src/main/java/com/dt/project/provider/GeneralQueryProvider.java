package com.dt.project.provider;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @ClassName GeneralQueryProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/11 11:08
 **/
public class GeneralQueryProvider {

    public String findGeneralQueryPro(Map<String, Object> query) {
        SQL sql = new SQL();
        String table = (String) query.get("table");
        String sqlId = (String) query.get("sqlId");
        Long paramId = (Long) query.get("paramId");
        sql.SELECT("`status_id`");
        sql.FROM(table);
        sql.WHERE(sqlId + "=" + paramId);
        return sql.toString();

    }
}

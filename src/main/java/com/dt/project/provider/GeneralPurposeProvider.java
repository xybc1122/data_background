package com.dt.project.provider;

import com.dt.project.utils.StrUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class GeneralPurposeProvider {


    public String deleteByGeneral(Map<String, Object> objectMap) {
        SQL sql = new SQL();
        sql.UPDATE((String) objectMap.get("table"));
        sql.SET("del_or_not = 1");
        return sql.toString() + " WHERE " + StrUtils.in(objectMap.get("ids"), (String) objectMap.get("thisId"));
    }


    public String selIsNull(Map<String, Object> objectMap) {
        SQL sql = new SQL();
        sql.SELECT((String) objectMap.get("thisId"));
        sql.FROM((String) objectMap.get("table"));
        return sql.toString() + " WHERE " + StrUtils.in(objectMap.get("ids"), (String) objectMap.get("thisId"))
                + " AND del_or_not=0";
    }


}

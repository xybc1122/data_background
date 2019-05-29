package com.dt.project.provider;

import com.dt.project.utils.StrUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class GeneralPurposeProvider {


    public String deleteByShipNotices(Map<String, Object> objectMap) {
        SQL sql = new SQL();
        sql.UPDATE((String) objectMap.get("table"));
        sql.SET("del_or_not = 1");
        return sql.toString() + " WHERE " + StrUtils.in(objectMap.get("ids"), (String) objectMap.get("thisId"));
    }
}

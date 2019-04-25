package com.dt.user.provider;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;

import com.dt.user.model.System.SystemShopRole;
import java.util.Map;

public class SystemShopRoleSqlProvider {

    public String countByExample(SystemShopRole example) {
        BEGIN();
        SELECT("count(*)");
        FROM("system_shop_role");
        return SQL();
    }

    public String insertSelective(SystemShopRole record) {
        BEGIN();
        INSERT_INTO("system_shop_role");
        
        if (record.getSid() != null) {
            VALUES("s_id", "#{sId,jdbcType=TINYINT}");
        }
        
        if (record.getRid() != null) {
            VALUES("r_id", "#{rId,jdbcType=INTEGER}");
        }
        
        if (record.getRsId() != null) {
            VALUES("rs_id", "#{rsId,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String selectByExample(SystemShopRole example) {
        BEGIN();
        SELECT("r_id");
        SELECT("rs_id");
        FROM("system_shop_role");
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SystemShopRole record = (SystemShopRole) parameter.get("record");
        BEGIN();
        UPDATE("system_shop_role");
        
        if (record.getSid() != null) {
            SET("s_id = #{record.sId,jdbcType=TINYINT}");
        }
        
        if (record.getRid() != null) {
            SET("r_id = #{record.rId,jdbcType=INTEGER}");
        }
        
        if (record.getRsId() != null) {
            SET("rs_id = #{record.rsId,jdbcType=INTEGER}");
        }
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("system_shop_role");
        
        SET("s_id = #{record.sId,jdbcType=TINYINT}");
        SET("r_id = #{record.rId,jdbcType=INTEGER}");
        SET("rs_id = #{record.rsId,jdbcType=INTEGER}");

        return SQL();
    }

}
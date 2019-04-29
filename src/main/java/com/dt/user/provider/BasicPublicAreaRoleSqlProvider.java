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

import com.dt.user.dto.AreaRoleDto;
import com.dt.user.model.BasePublicModel.BasicPublicAreaRole;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class BasicPublicAreaRoleSqlProvider {




    public String insertSelective(BasicPublicAreaRole record) {
        BEGIN();
        INSERT_INTO("basic_public_area_role");

        if (record.getArId() != null) {
            VALUES("ar_id", "#{arId,jdbcType=INTEGER}");
        }

        if (record.getCreateUser() != null) {
            VALUES("create_user", "#{createUser,jdbcType=VARCHAR}");
        }

        if (record.getCreateDate() != null) {
            VALUES("create_date", "#{createDate,jdbcType=BINARY}");
        }

        return SQL();
    }

    public String selectByExampleWithBLOBs(BasicPublicAreaRole example) {
        BEGIN();

        SELECT("a_id");
        SELECT("r_id");
        SELECT("create_user");
        SELECT("create_date");
        FROM("basic_public_area_role");

        return SQL();
    }

    public String selectByExample(BasicPublicAreaRole example) {
        BEGIN();

        SELECT("a_id");
        SELECT("r_id");
        SELECT("create_user");
        FROM("basic_public_area_role");


        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        BasicPublicAreaRole record = (BasicPublicAreaRole) parameter.get("record");

        BEGIN();
        UPDATE("basic_public_area_role");

        if (record.getArId() != null) {
            SET("ar_id = #{record.arId,jdbcType=INTEGER}");
        }

        if (record.getCreateUser() != null) {
            SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        }

        if (record.getCreateDate() != null) {
            SET("create_date = #{record.createDate,jdbcType=BINARY}");
        }

        return SQL();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("basic_public_area_role");

        SET("ar_id = #{record.arId,jdbcType=INTEGER}");
        SET("a_id = #{record.aId,jdbcType=INTEGER}");
        SET("r_id = #{record.rId,jdbcType=INTEGER}");
        SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        SET("create_date = #{record.createDate,jdbcType=BINARY}");

        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("basic_public_area_role");

        SET("ar_id = #{record.arId,jdbcType=INTEGER}");
        SET("a_id = #{record.aId,jdbcType=INTEGER}");
        SET("r_id = #{record.rId,jdbcType=INTEGER}");
        SET("create_user = #{record.createUser,jdbcType=VARCHAR}");


        return SQL();
    }
}
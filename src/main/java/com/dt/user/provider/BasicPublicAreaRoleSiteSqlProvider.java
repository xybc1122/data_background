package com.dt.user.provider;

import com.dt.user.model.BasePublicModel.BasicPublicAreaRoleSite;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class BasicPublicAreaRoleSiteSqlProvider {

    public String countByExample(BasicPublicAreaRoleSite example) {
        BEGIN();
        SELECT("count(*)");
        FROM("basic_public_area_role_site");

        return SQL();
    }

    public String deleteByExample(BasicPublicAreaRoleSite example) {
        BEGIN();
        DELETE_FROM("basic_public_area_role_site");

        return SQL();
    }

    public String insertSelective(BasicPublicAreaRoleSite record) {
        BEGIN();
        INSERT_INTO("basic_public_area_role_site");
        
        if (record.getArsId() != null) {
            VALUES("ars_id", "#{arsId,jdbcType=INTEGER}");
        }
        
        if (record.getArId() != null) {
            VALUES("ar_id", "#{arId,jdbcType=INTEGER}");
        }
        
        if (record.getSeId() != null) {
            VALUES("se_id", "#{seId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateDate() != null) {
            VALUES("create_date", "#{createDate,jdbcType=BIGINT}");
        }
        
        if (record.getCreateUser() != null) {
            VALUES("create_user", "#{createUser,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(BasicPublicAreaRoleSite example) {
        BEGIN();

        SELECT("ar_id");
        SELECT("se_id");
        SELECT("create_date");
        SELECT("create_user");
        FROM("basic_public_area_role_site");


        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        BasicPublicAreaRoleSite record = (BasicPublicAreaRoleSite) parameter.get("record");

        
        BEGIN();
        UPDATE("basic_public_area_role_site");
        
        if (record.getArsId() != null) {
            SET("ars_id = #{record.arsId,jdbcType=INTEGER}");
        }
        
        if (record.getArId() != null) {
            SET("ar_id = #{record.arId,jdbcType=INTEGER}");
        }
        
        if (record.getSeId() != null) {
            SET("se_id = #{record.seId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateDate() != null) {
            SET("create_date = #{record.createDate,jdbcType=BIGINT}");
        }
        
        if (record.getCreateUser() != null) {
            SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        }
        

        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("basic_public_area_role_site");
        
        SET("ars_id = #{record.arsId,jdbcType=INTEGER}");
        SET("ar_id = #{record.arId,jdbcType=INTEGER}");
        SET("se_id = #{record.seId,jdbcType=INTEGER}");
        SET("create_date = #{record.createDate,jdbcType=BIGINT}");
        SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        

        return SQL();
    }

}
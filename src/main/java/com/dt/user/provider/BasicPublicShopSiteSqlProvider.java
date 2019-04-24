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

import com.dt.user.model.BasePublicModel.BasicPublicShopSite;
import java.util.Map;

public class BasicPublicShopSiteSqlProvider {

    public String countByExample(BasicPublicShopSite example) {
        BEGIN();
        SELECT("count(*)");
        FROM("basic_public_shop_site");
        return SQL();
    }

    public String deleteByExample(BasicPublicShopSite example) {
        BEGIN();
        DELETE_FROM("basic_public_shop_site");
        return SQL();
    }

    public String insertSelective(BasicPublicShopSite record) {
        BEGIN();
        INSERT_INTO("basic_public_shop_site");
        
        if (record.getShopId() != null) {
            VALUES("shop_id", "#{shopId,jdbcType=BIGINT}");
        }
        
        if (record.getSiteId() != null) {
            VALUES("site_id", "#{siteId,jdbcType=BIGINT}");
        }
        

        if (record.getrId() != null) {
            VALUES("r_id", "#{rId,jdbcType=INTEGER}");
        }
        
        if (record.getStatusId() != null) {
            VALUES("status_id", "#{statusId,jdbcType=BIGINT}");
        }
        
        return SQL();
    }

    public String selectByExample(BasicPublicShopSite example) {
        BEGIN();
        SELECT("site_id");
        SELECT("id");
        SELECT("status");
        SELECT("version");
        SELECT("del_or_not");
        SELECT("r_id");
        SELECT("status_id");
        FROM("basic_public_shop_site");

        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        BasicPublicShopSite record = (BasicPublicShopSite) parameter.get("record");
        
        BEGIN();
        UPDATE("basic_public_shop_site");
        
        if (record.getShopId() != null) {
            SET("shop_id = #{record.shopId,jdbcType=BIGINT}");
        }
        
        if (record.getSiteId() != null) {
            SET("site_id = #{record.siteId,jdbcType=BIGINT}");
        }
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }

        if (record.getrId() != null) {
            SET("r_id = #{record.rId,jdbcType=INTEGER}");
        }
        
        if (record.getStatusId() != null) {
            SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        }

        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("basic_public_shop_site");
        
        SET("shop_id = #{record.shopId,jdbcType=BIGINT}");
        SET("site_id = #{record.siteId,jdbcType=BIGINT}");
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("del_or_not = #{record.delOrNot,jdbcType=BIT}");
        SET("r_id = #{record.rId,jdbcType=INTEGER}");
        SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        return SQL();
    }

}
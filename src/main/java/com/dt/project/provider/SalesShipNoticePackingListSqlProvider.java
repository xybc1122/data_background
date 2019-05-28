package com.dt.project.provider;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;

import com.dt.project.model.salesAmazon.SalesShipNoticePackingList;
import java.util.Map;

public class SalesShipNoticePackingListSqlProvider {

    public String countByExample(SalesShipNoticePackingList example) {
        BEGIN();
        SELECT("count(*)");
        FROM("sales_ship_notice_packing_list");
        return SQL();
    }

    public String deleteByExample(SalesShipNoticePackingList example) {
        BEGIN();
        DELETE_FROM("sales_ship_notice_packing_list");
        return SQL();
    }

    public String insertSelective(SalesShipNoticePackingList record) {
        BEGIN();
        INSERT_INTO("sales_ship_notice_packing_list");
        
        if (record.getPackinglistId() != null) {
            VALUES("packinglist_id", "#{packinglistId,jdbcType=BIGINT}");
        }
        
        if (record.getShipNoticeId() != null) {
            VALUES("ship_notice_id", "#{shipNoticeId,jdbcType=BIGINT}");
        }
        
        if (record.getNo() != null) {
            VALUES("no", "#{no,jdbcType=VARCHAR}");
        }
        
        if (record.getDate() != null) {
            VALUES("date", "#{date,jdbcType=BIGINT}");
        }
        
        if (record.getTtlQty() != null) {
            VALUES("ttl_qty", "#{ttlQty,jdbcType=INTEGER}");
        }
        
        if (record.getTtlPackages() != null) {
            VALUES("ttl_packages", "#{ttlPackages,jdbcType=INTEGER}");
        }
        
        if (record.getTtlVolume() != null) {
            VALUES("ttl_volume", "#{ttlVolume,jdbcType=DECIMAL}");
        }
        
        if (record.getTtlGwKg() != null) {
            VALUES("ttl_gw_kg", "#{ttlGwKg,jdbcType=DECIMAL}");
        }
        
        if (record.getSourceTypeId() != null) {
            VALUES("source_type_id", "#{sourceTypeId,jdbcType=BIGINT}");
        }
        
        if (record.getSourceId() != null) {
            VALUES("source_id", "#{sourceId,jdbcType=BIGINT}");
        }
        
        if (record.getRemark() != null) {
            VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateDate() != null) {
            VALUES("create_date", "#{createDate,jdbcType=BIGINT}");
        }
        
        if (record.getCreateUser() != null) {
            VALUES("create_user", "#{createUser,jdbcType=BIGINT}");
        }
        
        if (record.getModifyDate() != null) {
            VALUES("modify_date", "#{modifyDate,jdbcType=BIGINT}");
        }
        
        if (record.getModifyUser() != null) {
            VALUES("modify_user", "#{modifyUser,jdbcType=BIGINT}");
        }
        
        if (record.getAuditDate() != null) {
            VALUES("audit_date", "#{auditDate,jdbcType=BIGINT}");
        }
        
        if (record.getAuditUser() != null) {
            VALUES("audit_user", "#{auditUser,jdbcType=BIGINT}");
        }

        return SQL();
    }

    public String selectByExample(SalesShipNoticePackingList example) {
        SELECT("ship_notice_id");
        SELECT("no");
        SELECT("date");
        SELECT("ttl_qty");
        SELECT("ttl_packages");
        SELECT("ttl_volume");
        SELECT("ttl_gw_kg");
        SELECT("source_type_id");
        SELECT("source_id");
        SELECT("remark");
        SELECT("status");
        SELECT("create_date");
        SELECT("create_user");
        SELECT("modify_date");
        SELECT("modify_user");
        SELECT("audit_date");
        SELECT("audit_user");
        SELECT("close_date");
        SELECT("close_user");
        SELECT("version");
        SELECT("del_or_not");
        FROM("sales_ship_notice_packing_list");
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SalesShipNoticePackingList record = (SalesShipNoticePackingList) parameter.get("record");
        
        BEGIN();
        UPDATE("sales_ship_notice_packing_list");
        
        if (record.getPackinglistId() != null) {
            SET("packinglist_id = #{record.packinglistId,jdbcType=BIGINT}");
        }
        
        if (record.getShipNoticeId() != null) {
            SET("ship_notice_id = #{record.shipNoticeId,jdbcType=BIGINT}");
        }
        
        if (record.getNo() != null) {
            SET("no = #{record.no,jdbcType=VARCHAR}");
        }
        
        if (record.getDate() != null) {
            SET("date = #{record.date,jdbcType=BIGINT}");
        }
        
        if (record.getTtlQty() != null) {
            SET("ttl_qty = #{record.ttlQty,jdbcType=INTEGER}");
        }
        
        if (record.getTtlPackages() != null) {
            SET("ttl_packages = #{record.ttlPackages,jdbcType=INTEGER}");
        }
        
        if (record.getTtlVolume() != null) {
            SET("ttl_volume = #{record.ttlVolume,jdbcType=DECIMAL}");
        }
        
        if (record.getTtlGwKg() != null) {
            SET("ttl_gw_kg = #{record.ttlGwKg,jdbcType=DECIMAL}");
        }
        
        if (record.getSourceTypeId() != null) {
            SET("source_type_id = #{record.sourceTypeId,jdbcType=BIGINT}");
        }
        
        if (record.getSourceId() != null) {
            SET("source_id = #{record.sourceId,jdbcType=BIGINT}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateDate() != null) {
            SET("create_date = #{record.createDate,jdbcType=BIGINT}");
        }
        
        if (record.getCreateUser() != null) {
            SET("create_user = #{record.createUser,jdbcType=BIGINT}");
        }
        
        if (record.getModifyDate() != null) {
            SET("modify_date = #{record.modifyDate,jdbcType=BIGINT}");
        }
        
        if (record.getModifyUser() != null) {
            SET("modify_user = #{record.modifyUser,jdbcType=BIGINT}");
        }
        
        if (record.getAuditDate() != null) {
            SET("audit_date = #{record.auditDate,jdbcType=BIGINT}");
        }
        
        if (record.getAuditUser() != null) {
            SET("audit_user = #{record.auditUser,jdbcType=BIGINT}");
        }

        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("sales_ship_notice_packing_list");
        
        SET("packinglist_id = #{record.packinglistId,jdbcType=BIGINT}");
        SET("ship_notice_id = #{record.shipNoticeId,jdbcType=BIGINT}");
        SET("no = #{record.no,jdbcType=VARCHAR}");
        SET("date = #{record.date,jdbcType=BIGINT}");
        SET("ttl_qty = #{record.ttlQty,jdbcType=INTEGER}");
        SET("ttl_packages = #{record.ttlPackages,jdbcType=INTEGER}");
        SET("ttl_volume = #{record.ttlVolume,jdbcType=DECIMAL}");
        SET("ttl_gw_kg = #{record.ttlGwKg,jdbcType=DECIMAL}");
        SET("source_type_id = #{record.sourceTypeId,jdbcType=BIGINT}");
        SET("source_id = #{record.sourceId,jdbcType=BIGINT}");
        SET("remark = #{record.remark,jdbcType=VARCHAR}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("create_date = #{record.createDate,jdbcType=BIGINT}");
        SET("create_user = #{record.createUser,jdbcType=BIGINT}");
        SET("modify_date = #{record.modifyDate,jdbcType=BIGINT}");
        SET("modify_user = #{record.modifyUser,jdbcType=BIGINT}");
        SET("audit_date = #{record.auditDate,jdbcType=BIGINT}");
        SET("audit_user = #{record.auditUser,jdbcType=BIGINT}");
        SET("close_date = #{record.closeDate,jdbcType=BIGINT}");
        SET("close_user = #{record.closeUser,jdbcType=BIGINT}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("del_or_not = #{record.delOrNot,jdbcType=BIT}");
        return SQL();
    }
}
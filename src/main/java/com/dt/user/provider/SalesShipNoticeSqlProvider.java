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

import com.dt.user.model.SalesAmazon.SalesShipNotice;
import com.dt.user.store.FieldStore;
import com.dt.user.store.ProviderSqlStore;
import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.Field;
import java.util.Map;

public class SalesShipNoticeSqlProvider {

    public String countByExample(SalesShipNotice example) {
        BEGIN();
        SELECT("count(*)");
        FROM("sales_ship_notice");
        return SQL();
    }

    public String deleteByExample(SalesShipNotice example) {
        BEGIN();
        DELETE_FROM("sales_ship_notice");

        return SQL();
    }

    public String insertSelective(SalesShipNotice record) {
        BEGIN();
        INSERT_INTO("sales_ship_notice");

        if (record.getShipNoticeId() != null) {
            VALUES("ship_notice_id", "#{shipNoticeId,jdbcType=BIGINT}");
        }

        if (record.getNo() != null) {
            VALUES("no", "#{no,jdbcType=VARCHAR}");
        }

        if (record.getDate() != null) {
            VALUES("date", "#{date,jdbcType=BIGINT}");
        }

        if (record.getPlatformTypeId() != null) {
            VALUES("platform_type_id", "#{platformTypeId,jdbcType=INTEGER}");
        }

        if (record.getDeliveryDate() != null) {
            VALUES("delivery_date", "#{deliveryDate,jdbcType=BIGINT}");
        }

        if (record.getArriveDate() != null) {
            VALUES("arrive_date", "#{arriveDate,jdbcType=BIGINT}");
        }

        if (record.getTransportTypeId() != null) {
            VALUES("transport_type_id", "#{transportTypeId,jdbcType=INTEGER}");
        }

        if (record.getShopId() != null) {
            VALUES("shop_id", "#{shopId,jdbcType=INTEGER}");
        }

        if (record.getSiteId() != null) {
            VALUES("site_id", "#{siteId,jdbcType=INTEGER}");
        }

        if (record.getFbaShipmentId() != null) {
            VALUES("fba_shipment_id", "#{fbaShipmentId,jdbcType=VARCHAR}");
        }

        if (record.getAwId() != null) {
            VALUES("aw_id", "#{awId,jdbcType=INTEGER}");
        }

        if (record.getWarehouseId() != null) {
            VALUES("warehouse_id", "#{warehouseId,jdbcType=BIGINT}");
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
            VALUES("create_user", "#{createUser,jdbcType=VARCHAR}");
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

        if (record.getCloseDate() != null) {
            VALUES("close_date", "#{closeDate,jdbcType=BIGINT}");
        }

        if (record.getCloseUser() != null) {
            VALUES("close_user", "#{closeUser,jdbcType=BIGINT}");
        }

        if (record.getVersion() != null) {
            VALUES("version", "#{version,jdbcType=INTEGER}");
        }


        return SQL();
    }

    public String selectByNotice(SalesShipNotice notice) throws IllegalAccessException {
        SQL sql = new SQL();
        String alias = "pn";
        //如果不多查一个字段来存放ship_notice_id，而是在column里直接填ship_notice_id，
        // 查询出来的结果里，就没有ship_notice_id这个字段了
        sql.SELECT("`ship_notice_id` AS nid,s.`shop_name`, cs.`site_name`,`ship_notice_id`,`no`,`date`," + alias + ".`platform_type_id`,\n" +
                "`delivery_date`,`arrive_date`," + alias + ".`transport_type_id`,\n" +
                "" + alias + ".`shop_id`," + alias + ".`site_id`," + alias + ".`fba_shipment_id`,\n" +
                "" + alias + ".`aw_id`," + alias + ".`warehouse_id`,`ttl_qty`,`ttl_packages`,`ttl_volume`,\n" +
                "`ttl_gw_kg`,`source_type_id`,`source_no`," + ProviderSqlStore.statusV(alias) + "");
        sql.FROM("sales_ship_notice AS " + alias);
        ProviderSqlStore.joinTable(sql, alias);
        Field[] fields = notice.getClass().getDeclaredFields();
        FieldStore.query(fields, notice.getNameList(), notice, sql);
        ProviderSqlStore.selectUploadStatus(sql, notice, alias);
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SalesShipNotice record = (SalesShipNotice) parameter.get("record");


        BEGIN();
        UPDATE("sales_ship_notice");

        if (record.getShipNoticeId() != null) {
            SET("ship_notice_id = #{record.shipNoticeId,jdbcType=BIGINT}");
        }

        if (record.getNo() != null) {
            SET("no = #{record.no,jdbcType=VARCHAR}");
        }

        if (record.getDate() != null) {
            SET("date = #{record.date,jdbcType=BIGINT}");
        }

        if (record.getPlatformTypeId() != null) {
            SET("platform_type_id = #{record.platformTypeId,jdbcType=INTEGER}");
        }

        if (record.getDeliveryDate() != null) {
            SET("delivery_date = #{record.deliveryDate,jdbcType=BIGINT}");
        }

        if (record.getArriveDate() != null) {
            SET("arrive_date = #{record.arriveDate,jdbcType=BIGINT}");
        }

        if (record.getTransportTypeId() != null) {
            SET("transport_type_id = #{record.transportTypeId,jdbcType=INTEGER}");
        }

        if (record.getShopId() != null) {
            SET("shop_id = #{record.shopId,jdbcType=INTEGER}");
        }

        if (record.getSiteId() != null) {
            SET("site_id = #{record.siteId,jdbcType=INTEGER}");
        }

        if (record.getFbaShipmentId() != null) {
            SET("fba_shipment_id = #{record.fbaShipmentId,jdbcType=VARCHAR}");
        }

        if (record.getAwId() != null) {
            SET("aw_id = #{record.awId,jdbcType=INTEGER}");
        }

        if (record.getWarehouseId() != null) {
            SET("warehouse_id = #{record.warehouseId,jdbcType=BIGINT}");
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
            SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
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

        if (record.getCloseDate() != null) {
            SET("close_date = #{record.closeDate,jdbcType=BIGINT}");
        }

        if (record.getCloseUser() != null) {
            SET("close_user = #{record.closeUser,jdbcType=BIGINT}");
        }

        if (record.getVersion() != null) {
            SET("version = #{record.version,jdbcType=INTEGER}");
        }

        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("sales_ship_notice");

        SET("ship_notice_id = #{record.shipNoticeId,jdbcType=BIGINT}");
        SET("no = #{record.no,jdbcType=VARCHAR}");
        SET("date = #{record.date,jdbcType=BIGINT}");
        SET("platform_type_id = #{record.platformTypeId,jdbcType=INTEGER}");
        SET("delivery_date = #{record.deliveryDate,jdbcType=BIGINT}");
        SET("arrive_date = #{record.arriveDate,jdbcType=BIGINT}");
        SET("transport_type_id = #{record.transportTypeId,jdbcType=INTEGER}");
        SET("shop_id = #{record.shopId,jdbcType=INTEGER}");
        SET("site_id = #{record.siteId,jdbcType=INTEGER}");
        SET("fba_shipment_id = #{record.fbaShipmentId,jdbcType=VARCHAR}");
        SET("aw_id = #{record.awId,jdbcType=INTEGER}");
        SET("warehouse_id = #{record.warehouseId,jdbcType=BIGINT}");
        SET("ttl_qty = #{record.ttlQty,jdbcType=INTEGER}");
        SET("ttl_packages = #{record.ttlPackages,jdbcType=INTEGER}");
        SET("ttl_volume = #{record.ttlVolume,jdbcType=DECIMAL}");
        SET("ttl_gw_kg = #{record.ttlGwKg,jdbcType=DECIMAL}");
        SET("source_type_id = #{record.sourceTypeId,jdbcType=BIGINT}");
        SET("source_id = #{record.sourceId,jdbcType=BIGINT}");
        SET("remark = #{record.remark,jdbcType=VARCHAR}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("create_date = #{record.createDate,jdbcType=BIGINT}");
        SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
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
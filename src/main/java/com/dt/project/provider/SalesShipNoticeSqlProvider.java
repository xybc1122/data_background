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

import com.dt.project.model.salesAmazon.SalesShipNotice;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.store.FieldStore;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.toos.Constants;
import com.dt.project.utils.StrUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class SalesShipNoticeSqlProvider {

    public String countByExample(SalesShipNotice example) {
        BEGIN();
        SELECT("count(*)");
        FROM("sales_ship_notice");
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
//
//        if (record.getSourceTypeId() != null) {
//            VALUES("source_type_id", "#{sourceTypeId,jdbcType=BIGINT}");
//        }

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


        return SQL();
    }

    public String selectByNotice(SalesShipNotice notice) throws IllegalAccessException {
        SQL sql = new SQL();
        String alias = "pn";
        //如果不多查一个字段来存放ship_notice_id，而是在column里直接填ship_notice_id，
        // 查询出来的结果里，就没有ship_notice_id这个字段了
        sql.SELECT("pw.`warehouse_name`,saw.`warehouse_code`,ltt.`transport_type_name`,pt.`platform_type_name`,`ship_notice_id`,s.`shop_name`, cs.`site_name`,`ship_notice_id`,`no`,`date`," + alias + ".`platform_type_id`,\n" +
                "`delivery_date`,`arrive_date`," + alias + ".`transport_type_id`,\n" +
                "" + alias + ".`shop_id`," + alias + ".`site_id`," + alias + ".`fba_shipment_id`,\n" +
                "" + alias + ".`aw_id`," + alias + ".`warehouse_id`,`ttl_qty`,`ttl_packages`,`ttl_volume`,\n" +
                "`ttl_gw_kg`," + ProviderSqlStore.statusV(alias) + "");
        sql.FROM("sales_ship_notice AS " + alias);
        sql.LEFT_OUTER_JOIN("basic_public_platform_type AS pt on pt.platform_type_id=" + alias + ".platform_type_id");
        sql.LEFT_OUTER_JOIN("basic_logisticsmgt_transport_type AS ltt on ltt.transport_type_id=" + alias + ".transport_type_id");
        sql.LEFT_OUTER_JOIN("basic_sales_amazon_warehouse AS saw on saw.amazon_warehouse_id=" + alias + ".aw_id");
        sql.LEFT_OUTER_JOIN("basic_public_warehouse AS pw on pw.warehouse_id=" + alias + ".warehouse_id");
        ProviderSqlStore.joinTable(sql, alias);
        //查询平台类型
        AppendSqlStore.sqlWhere(notice.getPlatformTypeName(), "pt.`platform_type_name`", sql, Constants.SELECT);
        //查询运输类型
        AppendSqlStore.sqlWhere(notice.getTransportTypeName(), "ltt.`transport_type_name`", sql, Constants.SELECT);

        //查询亚马逊仓库
        AppendSqlStore.sqlWhere(notice.getWarehouseCode(), "saw.`warehouse_code`", sql, Constants.SELECT);
        //查询仓库
        AppendSqlStore.sqlWhere(notice.getWarehouseName(), "pw.`warehouse_name`", sql, Constants.SELECT);

        FieldStore.query(notice.getClass(), notice.getNameList(), notice, sql);
        ProviderSqlStore.selectDocumentStatus(sql, notice, alias);
        return sql.toString();
    }


    public String updateBySalesShipNotice(SalesShipNotice record) {
        SQL sql = new SQL();
        sql.UPDATE("sales_ship_notice");
        if (StringUtils.isNotBlank(record.getNo())) {
            sql.SET("no = #{no,jdbcType=VARCHAR}");
        }

        if (record.getDate() != null) {
            sql.SET("date = #{date,jdbcType=BIGINT}");
        }

        if (record.getPlatformTypeId() != null) {
            sql.SET("platform_type_id = #{platformTypeId,jdbcType=INTEGER}");
        }

        if (record.getDeliveryDate() != null) {
            sql.SET("delivery_date = #{deliveryDate,jdbcType=BIGINT}");
        }

        if (record.getArriveDate() != null) {
            sql.SET("arrive_date = #{arriveDate,jdbcType=BIGINT}");
        }

        if (record.getTransportTypeId() != null) {
            sql.SET("transport_type_id = #{transportTypeId,jdbcType=INTEGER}");
        }

        if (record.getShopId() != null) {
            sql.SET("shop_id = #{shopId}");
        }
        if (record.getSiteId() != null) {
            sql.SET("site_id = #{siteId}");
        }

        if (record.getFbaShipmentId() != null) {
            sql.SET("fba_shipment_id = #{fbaShipmentId}");
        }

        if (record.getAwId() != null) {
            sql.SET("aw_id = #{awId,jdbcType=INTEGER}");
        }

        if (record.getWarehouseId() != null) {
            sql.SET("warehouse_id = #{warehouseId,jdbcType=BIGINT}");
        }

        if (record.getTtlQty() != null) {
            sql.SET("ttl_qty = #{ttlQty,jdbcType=INTEGER}");
        }

        if (record.getTtlPackages() != null) {
            sql.SET("ttl_packages = #{ttlPackages,jdbcType=INTEGER}");
        }

        if (record.getTtlVolume() != null) {
            sql.SET("ttl_volume = #{ttlVolume,jdbcType=DECIMAL}");
        }

        if (record.getTtlNwKg() != null) {
            sql.SET("ttl_gw_kg = #{ttlGwKg,jdbcType=DECIMAL}");
        }

        if (record.getTtlGwKg() != null) {
            sql.SET("ttl_gw_kg = #{ttlGwKg,jdbcType=DECIMAL}");
        }
//
//        if (record.getSourceTypeId() != null) {
//            sql.SET("source_type_id = #{sourceTypeId,jdbcType=BIGINT}");
//        }
//
//        if (record.getSourceId() != null) {
//            sql.SET("source_id = #{sourceId}");
//        }

        if (record.getCloseDate() != null) {
            sql.SET("close_date = #{closeDate,jdbcType=BIGINT}");
        }
        if (record.getCloseUser() != null) {
            sql.SET("close_user = #{closeUser,jdbcType=BIGINT}");
        }
        ProviderSqlStore.setStatus(sql, record);
        sql.WHERE("ship_notice_id = #{shipNoticeId,jdbcType=BIGINT}");
        return sql.toString();
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
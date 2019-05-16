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

import com.dt.project.model.SalesAmazon.SalesShipNoticeEntry;
import com.dt.project.store.FieldStore;
import com.dt.project.utils.StrUtils;
import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.Field;
import java.util.Map;

public class SalesShipNoticeEntrySqlProvider {

    public String countByExample(SalesShipNoticeEntry example) {
        BEGIN();
        SELECT("count(*)");
        FROM("sales_ship_notice_entry");
        return SQL();
    }

    public String deleteByExample(SalesShipNoticeEntry example) {
        BEGIN();
        DELETE_FROM("sales_ship_notice_entry");
        return SQL();
    }

    public String insertSelective(SalesShipNoticeEntry record) {
        BEGIN();
        INSERT_INTO("sales_ship_notice_entry");

        if (record.getEntryId() != null) {
            VALUES("entry_id", "#{entryId,jdbcType=INTEGER}");
        }

        if (record.getShipNoticeId() != null) {
            VALUES("ship_notice_id", "#{shipNoticeId,jdbcType=BIGINT}");
        }

        if (record.getSkuId() != null) {
            VALUES("sku_id", "#{skuId,jdbcType=BIGINT}");
        }

        if (record.getQuantity() != null) {
            VALUES("quantity", "#{quantity,jdbcType=INTEGER}");
        }

        if (record.getPackages() != null) {
            VALUES("packages", "#{packages,jdbcType=VARCHAR}");
        }

        if (record.getPackingStatus() != null) {
            VALUES("packing_status", "#{packingStatus,jdbcType=BIT}");
        }

        if (record.getSeQuantity() != null) {
            VALUES("se_quantity", "#{seQuantity,jdbcType=INTEGER}");
        }

        if (record.getReQuantity() != null) {
            VALUES("re_quantity", "#{reQuantity,jdbcType=INTEGER}");
        }

        if (record.getReDate() != null) {
            VALUES("re_date", "#{reDate,jdbcType=BIGINT}");
        }

        if (record.getRemark() != null) {
            VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=INTEGER}");
        }

        if (record.getCloseDate() != null) {
            VALUES("close_date", "#{closeDate,jdbcType=BIGINT}");
        }

        if (record.getCloseUser() != null) {
            VALUES("close_user", "#{closeUser,jdbcType=VARCHAR}");
        }

        if (record.getVersion() != null) {
            VALUES("version", "#{version,jdbcType=INTEGER}");
        }


        return SQL();
    }

    public String selectByNoticeEntry(SalesShipNoticeEntry nEntry) throws IllegalAccessException {
        SQL sql = new SQL();
        sql.SELECT("`e_id`,`entry_id`,\n" +
                "`ship_notice_id`,`sku_id`,`quantity`,`packages`,`ne_length_cm`,`ne_width_cm`,`ne_height_cm`,`ne_gw_kg`,\n" +
                "`ne_nw_kg`,`ne_volume_m3`,`packing_status`,`se_quantity`,`re_quantity`,`re_date`,`remark`,`status`,\n" +
                "`close_date`,`close_user`,`version`\n" +
                "FROM `sales_ship_notice_entry`");
        Field[] fields = nEntry.getClass().getDeclaredFields();
        FieldStore.query(fields, nEntry.getNameList(), nEntry, sql);
        sql.WHERE("del_or_not=0");
        if (nEntry.getInShipNoticeList() != null && nEntry.getInShipNoticeList().size() > 0) {
            return sql.toString() + " AND " + StrUtils.in(nEntry.getInShipNoticeList(), "ship_notice_id");
        }
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SalesShipNoticeEntry record = (SalesShipNoticeEntry) parameter.get("record");
        BEGIN();
        UPDATE("sales_ship_notice_entry");


        if (record.getEntryId() != null) {
            SET("entry_id = #{record.entryId,jdbcType=INTEGER}");
        }

        if (record.getShipNoticeId() != null) {
            SET("ship_notice_id = #{record.shipNoticeId,jdbcType=BIGINT}");
        }

        if (record.getSkuId() != null) {
            SET("sku_id = #{record.skuId,jdbcType=BIGINT}");
        }

        if (record.getQuantity() != null) {
            SET("quantity = #{record.quantity,jdbcType=INTEGER}");
        }

        if (record.getPackages() != null) {
            SET("packages = #{record.packages,jdbcType=VARCHAR}");
        }
        if (record.getPackingStatus() != null) {
            SET("packing_status = #{record.packingStatus,jdbcType=BIT}");
        }

        if (record.getSeQuantity() != null) {
            SET("se_quantity = #{record.seQuantity,jdbcType=INTEGER}");
        }

        if (record.getReQuantity() != null) {
            SET("re_quantity = #{record.reQuantity,jdbcType=INTEGER}");
        }

        if (record.getReDate() != null) {
            SET("re_date = #{record.reDate,jdbcType=BIGINT}");
        }

        if (record.getRemark() != null) {
            SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            SET("status = #{record.status,jdbcType=INTEGER}");
        }

        if (record.getCloseDate() != null) {
            SET("close_date = #{record.closeDate,jdbcType=BIGINT}");
        }

        if (record.getCloseUser() != null) {
            SET("close_user = #{record.closeUser,jdbcType=VARCHAR}");
        }

        if (record.getVersion() != null) {
            SET("version = #{record.version,jdbcType=INTEGER}");
        }


        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("sales_ship_notice_entry");

        SET("e_id = #{record.eId,jdbcType=BIGINT}");
        SET("entry_id = #{record.entryId,jdbcType=INTEGER}");
        SET("ship_notice_id = #{record.shipNoticeId,jdbcType=BIGINT}");
        SET("sku_id = #{record.skuId,jdbcType=BIGINT}");
        SET("quantity = #{record.quantity,jdbcType=INTEGER}");
        SET("packages = #{record.packages,jdbcType=VARCHAR}");
        SET("length_cm = #{record.lengthCm,jdbcType=DECIMAL}");
        SET("width_cm = #{record.widthCm,jdbcType=DOUBLE}");
        SET("height_cm = #{record.heightCm,jdbcType=DOUBLE}");
        SET("gw_kg = #{record.gwKg,jdbcType=DOUBLE}");
        SET("nw_kg = #{record.nwKg,jdbcType=DOUBLE}");
        SET("volume_m3 = #{record.volumeM3,jdbcType=DOUBLE}");
        SET("packing_status = #{record.packingStatus,jdbcType=BIT}");
        SET("se_quantity = #{record.seQuantity,jdbcType=INTEGER}");
        SET("re_quantity = #{record.reQuantity,jdbcType=INTEGER}");
        SET("re_date = #{record.reDate,jdbcType=BIGINT}");
        SET("remark = #{record.remark,jdbcType=VARCHAR}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("close_date = #{record.closeDate,jdbcType=BIGINT}");
        SET("close_user = #{record.closeUser,jdbcType=VARCHAR}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("del_or_not = #{record.delOrNot,jdbcType=BIT}");
        return SQL();
    }


}
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

import com.dt.project.model.salesAmazon.SalesShipNoticeEntry;
import com.dt.project.store.FieldStore;
import com.dt.project.utils.StrUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
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

    @SuppressWarnings("unchecked")
    public String insertShipNoticeEntry(Map<String, Object> neMap) {
        List<SalesShipNoticeEntry> noticeEntryList = (List<SalesShipNoticeEntry>) neMap.get("noticeEntryList");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `sales_ship_notice_entry`\n" +
                "(`entry_id`,`ship_notice_id`,`sku_id`,`quantity`,\n" +
                "`packages`,`length_cm`,`width_cm`,`height_cm`,\n" +
                "`gw_kg`,`nw_kg`,`volume_m3`,`packing_status`,\n" +
                "`se_quantity`,`re_quantity`,`re_date`,`remark`, `status`,\n" +
                "`close_date`, `close_user`)values");
        for (SalesShipNoticeEntry noticeEntry : noticeEntryList) {
            sb.append("(").append(noticeEntry.getEntryId()).append(",").append(noticeEntry.getShipNoticeId()).
                    append(",").append(noticeEntry.getSkuId()).append(",").append(noticeEntry.getQuantity()).append(",");
            StrUtils.appBuider(sb, noticeEntry.getPackages());
            sb.append(",").append(noticeEntry.getNeLengthCm()).append(",").append(noticeEntry.getNeWidthCm()).
                    append(",").append(noticeEntry.getNeHeightCm()).append(",").
                    append(noticeEntry.getNeGwKg()).append(",").append(noticeEntry.getNeNwKg()).append(",").
                    append(noticeEntry.getNeVolumeM3()).append(",").append(noticeEntry.getPackingStatus()).append(",").
                    append(noticeEntry.getSeQuantity()).append(",").append(noticeEntry.getReQuantity()).append(",").
                    append(noticeEntry.getReDate()).append(",");
            StrUtils.appBuider(sb, noticeEntry.getNeRemark());
            sb.append(",").append(noticeEntry.getStatus()).append(",").append(noticeEntry.getCloseDate()).append(",");
            StrUtils.appBuider(sb, noticeEntry.getCloseUser());
            sb.append("),");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    public String selectByNoticeEntry(SalesShipNoticeEntry nEntry) throws IllegalAccessException {
        SQL sql = new SQL();
        String alias = "sne";
        sql.SELECT("sku.sku,`e_id`,`entry_id`,\n" +
                "`ship_notice_id`," + alias + ".`sku_id`,`quantity`,`packages`," + alias + ".`length_cm`," +
                "" + alias + ".`width_cm`," + alias + ".`height_cm`," + alias + ".`gw_kg`,\n" +
                "" + alias + ".`nw_kg`," + alias + ".`volume_m3`,`packing_status`,`se_quantity`,`re_quantity`,`re_date`,`remark`,`status`,\n" +
                "`close_date`,`close_user`," + alias + ".`version`\n" +
                "FROM `sales_ship_notice_entry` AS  " + alias + "");
        sql.LEFT_OUTER_JOIN("`basic_public_sku` AS sku on sku.sku_id= " + alias + ".sku_id");
        FieldStore.query(nEntry.getClass(), nEntry.getNameList(), nEntry, sql);
        sql.WHERE(alias + ".del_or_not=0");
        if (nEntry.getInShipNoticeList() != null && nEntry.getInShipNoticeList().size() > 0) {
            return sql.toString() + " AND " + StrUtils.in(nEntry.getInShipNoticeList(), alias + ".ship_notice_id");
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
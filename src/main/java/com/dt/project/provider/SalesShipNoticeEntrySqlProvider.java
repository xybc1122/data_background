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
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.utils.StrUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class SalesShipNoticeEntrySqlProvider {


    @SuppressWarnings("unchecked")
    public String insertShipNoticeEntry(Map<String, Object> neMap) {
        List<SalesShipNoticeEntry> noticeEntryList = (List<SalesShipNoticeEntry>) neMap.get("noticeEntryList");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `sales_ship_notice_entry`\n" +
                "(`entry_id`,`ship_notice_id`,`sku_id`,`quantity`,\n" +
                "`packages`,`length_cm`,`width_cm`,`height_cm`,\n" +
                "`gw_kg`,`nw_kg`,`volume_m3`,`packing_status`,\n" +
                "`se_quantity`,`re_quantity`,`re_date`,`e_remark`, `status`,\n" +
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
                "" + alias + ".`nw_kg`," + alias + ".`volume_m3`,`packing_status`,`se_quantity`,`re_quantity`,`re_date`," +
                "" + alias + ".`e_remark`,`status`,\n" +
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

    public String updateByNoticeEntry(SalesShipNoticeEntry record) {
        SQL sql = new SQL();
        sql.UPDATE("sales_ship_notice_entry");
        if (record.getEntryId() != null) {
            sql.SET("entry_id = #{entryId}");
        }
        if (record.getSkuId() != null) {
            sql.SET("sku_id = #{skuId}");
        }

        if (record.getQuantity() != null) {
            sql.SET("quantity = #{quantity}");
        }

        if (StringUtils.isNotBlank(record.getPackages())) {
            sql.SET("packages = #{packages}");
        }
        if (record.getNeLengthCm() != null) {
            sql.SET("length_cm = #{neLengthCm}");
        }
        if (record.getNeWidthCm() != null) {
            sql.SET("width_cm = #{neWidthCm}");
        }

        if (record.getNeHeightCm() != null) {
            sql.SET("height_cm = #{neHeightCm}");
        }

        if (record.getNeGwKg() != null) {
            sql.SET("gw_kg = #{neGwKg}");
        }

        if (record.getNeNwKg() != null) {
            sql.SET("nw_kg = #{neNwKg}");
        }

        if (record.getNeVolumeM3() != null) {
            sql.SET("volume_m3 = #{neVolumeM3}");
        }

        if (record.getPackingStatus() != null) {
            sql.SET("packing_status = #{packingStatus}");
        }

        if (record.getSeQuantity() != null) {
            sql.SET("se_quantity = #{seQuantity}");
        }

        if (record.getReQuantity() != null) {
            sql.SET("re_quantity = #{reQuantity}");
        }

        if (record.getReDate() != null) {
            sql.SET("re_date = #{reDate}");
        }

        if (record.getNeRemark() != null) {
            sql.SET("e_remark = #{neRemark}");
        }

        if (record.getStatus() != null) {
            sql.SET("status = #{status}");
        }

        if (record.getCloseDate() != null) {
            sql.SET("close_date = #{closeDate}");
        }

        if (StringUtils.isNotBlank(record.getCloseUser())) {
            sql.SET("close_user = #{closeUser}");
        }
        ProviderSqlStore.setVersion(sql, record.getVersion());
        sql.WHERE("e_id = #{eid}");
        return sql.toString();
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
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

import com.dt.project.model.salesAmazon.SalesShipNoticePackingListEntry;
import com.dt.project.store.FieldStore;
import com.dt.project.utils.StrUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class SalesShipNoticePackingListEntrySqlProvider {

    public String countByExample(SalesShipNoticePackingListEntry example) {
        BEGIN();
        SELECT("count(*)");
        FROM("sales_ship_notice_packinglist_entry");

        return SQL();
    }

    public String deleteByExample(SalesShipNoticePackingListEntry example) {
        BEGIN();
        DELETE_FROM("sales_ship_notice_packinglist_entry");
        return SQL();
    }

    public String insertSelective(SalesShipNoticePackingListEntry record) {
        BEGIN();
        INSERT_INTO("sales_ship_notice_packinglist_entry");

        if (record.getPeId() != null) {
            VALUES("pe_id", "#{peId,jdbcType=BIGINT}");
        }


        if (record.getEntryId() != null) {
            VALUES("entry_id", "#{entryId,jdbcType=INTEGER}");
        }

        if (record.getQuantity() != null) {
            VALUES("quantity", "#{quantity,jdbcType=INTEGER}");
        }

        if (record.getPackagesBeg() != null) {
            VALUES("packages_beg", "#{packagesBeg,jdbcType=INTEGER}");
        }

        if (record.getPackagesEnd() != null) {
            VALUES("packages_end", "#{packagesEnd,jdbcType=INTEGER}");
        }

        return SQL();
    }


    public String selectPackingListEntry(SalesShipNoticePackingListEntry pLEntry) throws IllegalAccessException {
        SQL sql = new SQL();
        sql.SELECT("`pe_id`,`packing_list_id`,\n" +
                "`e_id`,`entry_id`,`quantity`,\n" +
                "`packages_beg`,`packages_end`,`length_cm`,`width_cm`,\n" +
                "`height_cm`,`gw_kg`,\n" +
                "`nw_kg`,`volume_m3`,`remark`,`version`" +
                " FROM `sales_ship_notice_packing_list_entry`");
        FieldStore.query(pLEntry.getClass(), pLEntry.getNameList(), pLEntry, sql);
        sql.WHERE("del_or_not=0");
        if (pLEntry.getInShipNoticeList() != null && pLEntry.getInShipNoticeList().size() > 0) {
            return sql.toString() + " AND " + StrUtils.in(pLEntry.getInShipNoticeList(), "packing_list_id");
        }
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SalesShipNoticePackingListEntry record = (SalesShipNoticePackingListEntry) parameter.get("record");


        BEGIN();
        UPDATE("sales_ship_notice_packinglist_entry");

        if (record.getPeId() != null) {
            SET("pe_id = #{record.peId,jdbcType=BIGINT}");
        }


        if (record.getEntryId() != null) {
            SET("entry_id = #{record.entryId,jdbcType=INTEGER}");
        }

        if (record.getQuantity() != null) {
            SET("quantity = #{record.quantity,jdbcType=INTEGER}");
        }

        if (record.getPackagesBeg() != null) {
            SET("packages_beg = #{record.packagesBeg,jdbcType=INTEGER}");
        }

        if (record.getPackagesEnd() != null) {
            SET("packages_end = #{record.packagesEnd,jdbcType=INTEGER}");
        }


        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("sales_ship_notice_packinglist_entry");

        SET("pe_id = #{record.peId,jdbcType=BIGINT}");
        SET("packinglist_id = #{record.packinglistId,jdbcType=BIGINT}");
        SET("e_id = #{record.eId,jdbcType=BIGINT}");
        SET("entry_id = #{record.entryId,jdbcType=INTEGER}");
        SET("quantity = #{record.quantity,jdbcType=INTEGER}");
        SET("packages_beg = #{record.packagesBeg,jdbcType=INTEGER}");
        SET("packages_end = #{record.packagesEnd,jdbcType=INTEGER}");
        SET("length_cm = #{record.lengthCm,jdbcType=DECIMAL}");
        SET("width_cm = #{record.widthCm,jdbcType=DECIMAL}");
        SET("height_cm = #{record.heightCm,jdbcType=DECIMAL}");
        SET("gw_kg = #{record.gwKg,jdbcType=DECIMAL}");
        SET("nw_kg = #{record.nwKg,jdbcType=DECIMAL}");
        SET("volume_m3 = #{record.volumeM3,jdbcType=DECIMAL}");
        SET("remark = #{record.remark,jdbcType=VARCHAR}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("del_or_not = #{record.delOrNot,jdbcType=BIT}");

        return SQL();
    }

}
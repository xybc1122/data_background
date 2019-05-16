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

import com.dt.project.model.SalesAmazon.SalesShipNoticePackingListEntry;
import com.dt.project.store.FieldStore;
import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.Field;
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

        if (record.getLengthCm() != null) {
            VALUES("length_cm", "#{lengthCm,jdbcType=DECIMAL}");
        }

        if (record.getWidthCm() != null) {
            VALUES("width_cm", "#{widthCm,jdbcType=DECIMAL}");
        }

        if (record.getHeightCm() != null) {
            VALUES("height_cm", "#{heightCm,jdbcType=DECIMAL}");
        }

        if (record.getGwKg() != null) {
            VALUES("gw_kg", "#{gwKg,jdbcType=DECIMAL}");
        }

        if (record.getNwKg() != null) {
            VALUES("nw_kg", "#{nwKg,jdbcType=DECIMAL}");
        }

        if (record.getVolumeM3() != null) {
            VALUES("volume_m3", "#{volumeM3,jdbcType=DECIMAL}");
        }

        if (record.getRemark() != null) {
            VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }

        if (record.getVersion() != null) {
            VALUES("version", "#{version,jdbcType=INTEGER}");
        }

        if (record.getDelOrNot() != null) {
            VALUES("del_or_not", "#{delOrNot,jdbcType=BIT}");
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
        Field[] fields = pLEntry.getClass().getDeclaredFields();
        FieldStore.query(fields, pLEntry.getNameList(), pLEntry, sql);
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

        if (record.getLengthCm() != null) {
            SET("length_cm = #{record.lengthCm,jdbcType=DECIMAL}");
        }

        if (record.getWidthCm() != null) {
            SET("width_cm = #{record.widthCm,jdbcType=DECIMAL}");
        }

        if (record.getHeightCm() != null) {
            SET("height_cm = #{record.heightCm,jdbcType=DECIMAL}");
        }

        if (record.getGwKg() != null) {
            SET("gw_kg = #{record.gwKg,jdbcType=DECIMAL}");
        }

        if (record.getNwKg() != null) {
            SET("nw_kg = #{record.nwKg,jdbcType=DECIMAL}");
        }

        if (record.getVolumeM3() != null) {
            SET("volume_m3 = #{record.volumeM3,jdbcType=DECIMAL}");
        }

        if (record.getRemark() != null) {
            SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }

        if (record.getVersion() != null) {
            SET("version = #{record.version,jdbcType=INTEGER}");
        }

        if (record.getDelOrNot() != null) {
            SET("del_or_not = #{record.delOrNot,jdbcType=BIT}");
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
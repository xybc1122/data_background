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

import com.dt.project.model.purchasePo.PurchaseIcBillStockEntry;
import com.dt.project.store.FieldStore;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.utils.StrUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class PurchaseIcBillStockEntrySqlProvider {

    public String countByExample(PurchaseIcBillStockEntry example) {
        BEGIN();
        SELECT("count(*)");
        FROM("purchase_ic_bill_stock_entry");
        return SQL();
    }

    public String deleteByExample(PurchaseIcBillStockEntry example) {
        BEGIN();
        DELETE_FROM("purchase_ic_bill_stock_entry");
        return SQL();
    }

    public String insertIcBillStockEntry(Map<String, List<PurchaseIcBillStockEntry>> objectMap) {
        List<PurchaseIcBillStockEntry> icBillStockEntryList = objectMap.get("IcBillStockEntryList");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `purchase_ic_bill_stock_entry`\n" +
                "(`entry_id`,`sb_id`,`product_id`,`source_type_id`,\n" +
                "`source_id`,`rne_id`,`recive_warehouse_id`,`recive_position_id`,\n" +
                "`quantity`,`e_remark`, `row_closed`)value");
        for (PurchaseIcBillStockEntry icBillStockEntry : icBillStockEntryList) {
            sb.append("(").append(icBillStockEntry.getEntryId()).append(",").append(icBillStockEntry.getSbId()).append(",")
                    .append(icBillStockEntry.getProductId()).append(",").append(icBillStockEntry.getSourceTypeId())
                    .append(",").append(icBillStockEntry.getIcBSourceId()).append(",").append(icBillStockEntry.getRneId()).append(",").append(icBillStockEntry.getReciveWarehouseId()).
                    append(",").append(icBillStockEntry.getRecivePositionId()).append(",").append(icBillStockEntry.getQuantity())
                    .append(",");
            StrUtils.appBuider(sb, icBillStockEntry.getIcBRemark());
            sb.append(",").append(icBillStockEntry.getRowClosed());
            sb.append("),");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    public String selectByIcBillStockEntry(PurchaseIcBillStockEntry record) throws IllegalAccessException {
        SQL sql = new SQL();
        String alias = "bse";
        sql.SELECT("`sbe_id`,`entry_id`,`sb_id`,`product_id`,\n" +
                "`source_type_id`,`source_id`,`rne_id`,\n" +
                "`recive_warehouse_id`,`recive_position_id`,\n" +
                "`quantity`," + alias + ".`e_remark`,`row_closed`," + alias + ".`version`\n" +
                "FROM `purchase_ic_bill_stock_entry` AS " + alias + "");
        //sql动态查询
        FieldStore.query(record.getClass(), record.getJavaSqlName(), record, sql);
        sql.WHERE(alias + ".`del_or_not`=0");
        if (record.getInList() != null && record.getInList().size() > 0) {
            return sql.toString() + " AND " + StrUtils.in(record.getInList(), "sb_id");
        }
        return sql.toString();
    }

    public String updateByIcBillStockEntry(PurchaseIcBillStockEntry record) {
        SQL sql = new SQL();
        sql.UPDATE("purchase_ic_bill_stock_entry");

        if (record.getSbeId() != null) {
            sql.SET("sbe_id = #{sbeId,jdbcType=BIGINT}");
        }

        if (record.getEntryId() != null) {
            sql.SET("entry_id = #{entryId,jdbcType=INTEGER}");
        }

        if (record.getSbId() != null) {
            sql.SET("sb_id = #{sbId,jdbcType=BIGINT}");
        }

        if (record.getProductId() != null) {
            sql.SET("product_id = #{productId,jdbcType=INTEGER}");
        }

        if (record.getSourceTypeId() != null) {
            sql.SET("source_type_id = #{sourceTypeId,jdbcType=BIGINT}");
        }

        if (record.getIcBSourceId() != null) {
            sql.SET("source_id = #{icBSourceId,jdbcType=BIGINT}");
        }

        if (record.getRneId() != null) {
            sql.SET("rne_id = #{rneId,jdbcType=BIGINT}");
        }

        if (record.getReciveWarehouseId() != null) {
            sql.SET("recive_warehouse_id = #{reciveWarehouseId,jdbcType=BIGINT}");
        }

        if (record.getRecivePositionId() != null) {
            sql.SET("recive_position_id = #{recivePositionId,jdbcType=BIGINT}");
        }

        if (record.getQuantity() != null) {
            sql.SET("quantity = #{quantity,jdbcType=DECIMAL}");
        }

        if (StringUtils.isNotBlank(record.getIcBRemark())) {
            sql.SET("e_remark = #{icBRemark,jdbcType=VARCHAR}");
        }

        if (record.getRowClosed() != null) {
            sql.SET("row_closed = #{rowClosed,jdbcType=INTEGER}");
        }
        sql.WHERE("sbe_id = #{record.sbeId,jdbcType=BIGINT}");
        ProviderSqlStore.setVersion(sql, record.getVersion());
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("purchase_ic_bill_stock_entry");

        SET("sbe_id = #{record.sbeId,jdbcType=BIGINT}");
        SET("entry_id = #{record.entryId,jdbcType=INTEGER}");
        SET("sb_id = #{record.sbId,jdbcType=BIGINT}");
        SET("product_id = #{record.productId,jdbcType=INTEGER}");
        SET("source_type_id = #{record.sourceTypeId,jdbcType=BIGINT}");
        SET("source_id = #{record.sourceId,jdbcType=VARCHAR}");
        SET("rne_id = #{record.rneId,jdbcType=BIGINT}");
        SET("recive_warehouse_id = #{record.reciveWarehouseId,jdbcType=BIGINT}");
        SET("recive_position_id = #{record.recivePositionId,jdbcType=BIGINT}");
        SET("quantity = #{record.quantity,jdbcType=DECIMAL}");
        SET("e_remark = #{record.eRemark,jdbcType=VARCHAR}");
        SET("row_closed = #{record.rowClosed,jdbcType=INTEGER}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("del_or_not = #{record.delOrNot,jdbcType=BIT}");


        return SQL();
    }
}
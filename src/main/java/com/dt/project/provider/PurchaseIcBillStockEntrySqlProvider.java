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
                "(`entry_id`,`sb_id`,`product_id`,`rne_id`,`warehouse_id`,`position_id`,\n" +
                "`quantity`,`e_remark`, `row_closed`)value");
        for (PurchaseIcBillStockEntry icBillStockEntry : icBillStockEntryList) {
            sb.append("(").append(icBillStockEntry.getEntryId()).append(",").append(icBillStockEntry.getSbId()).append(",")
                    .append(icBillStockEntry.getProductId()).append(",").append(icBillStockEntry.getRneId()).append(",").append(icBillStockEntry.getReciveWarehouseId()).
                    append(",").append(icBillStockEntry.getRecivePositionId()).append(",").append(icBillStockEntry.getQuantity())
                    .append(",");
            StrUtils.appBuider(sb, icBillStockEntry.geteRemark());
            sb.append(",").append(icBillStockEntry.getRowClosed());
            sb.append("),");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    public String selectByIcBillStockEntry(PurchaseIcBillStockEntry record) throws IllegalAccessException {
        SQL sql = new SQL();
        String alias = "bse";
        sql.SELECT("" + ProviderSqlStore.docChildV() + ",`sbe_id`,`entry_id`,`sb_id`," + alias + ".`product_id`,\n" +
                "`source_type_id`,`source_id`,`rne_id`,\n" +
                "" + alias + ".`warehouse_id`," + alias + ".`position_id`,\n" +
                "`quantity`," + alias + ".`e_remark`,`row_closed`," + alias + ".`version`\n" +
                "FROM `purchase_ic_bill_stock_entry` AS " + alias + "");
        //sql动态查询
        FieldStore.query(record.getClass(), record.getJsonArray(), record, sql,alias);
        //字表通用查询
        ProviderSqlStore.setDocumentChild(sql, alias, record);
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

        if (record.getRneId() != null) {
            sql.SET("rne_id = #{rneId,jdbcType=BIGINT}");
        }

        if (record.getReciveWarehouseId() != null) {
            sql.SET("warehouse_id = #{reciveWarehouseId,jdbcType=BIGINT}");
        }

        if (record.getRecivePositionId() != null) {
            sql.SET("position_id = #{recivePositionId,jdbcType=BIGINT}");
        }

        if (record.getQuantity() != null) {
            sql.SET("quantity = #{quantity,jdbcType=DECIMAL}");
        }

        if (StringUtils.isNotBlank(record.geteRemark())) {
            sql.SET("e_remark = #{eRemark,jdbcType=VARCHAR}");
        }

        if (record.getRowClosed() != null) {
            sql.SET("row_closed = #{rowClosed,jdbcType=INTEGER}");
        }
        sql.WHERE("sbe_id = #{sbeId,jdbcType=BIGINT}");
        ProviderSqlStore.setVersion(sql, record.getVersion());
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        return null;
    }
}
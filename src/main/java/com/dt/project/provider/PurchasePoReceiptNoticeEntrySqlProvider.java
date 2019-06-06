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

import com.dt.project.model.purchasePo.PurchasePoReceiptNoticeEntry;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.store.FieldStore;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.toos.Constants;
import com.dt.project.utils.StrUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class PurchasePoReceiptNoticeEntrySqlProvider {

    public String countByExample(PurchasePoReceiptNoticeEntry example) {
        BEGIN();
        SELECT("count(*)");
        FROM("purchase_po_receipt_notice_entry");
        return SQL();
    }

    public String deleteByExample(PurchasePoReceiptNoticeEntry example) {
        BEGIN();
        DELETE_FROM("purchase_po_receipt_notice_entry");
        return SQL();
    }

    public String insertReceiptNoticeEntry(Map<String, List<PurchasePoReceiptNoticeEntry>> objectMap) {
        List<PurchasePoReceiptNoticeEntry> receiptNoticeEntryList = objectMap.get("poReceiptNoticeEntryList");
        StringBuilder sb = new StringBuilder();
        sb.append("insert into purchase_po_receipt_notice_entry" +
                "(entry_id,rn_id, product_id, poe_id, delivery_date," +
                "warehouse_id, position_id,quantity, transport_company_id," +
                "tracking_number, e_remark, row_closed,source_type_id,source_id) value");
        for (PurchasePoReceiptNoticeEntry receiptNoticeEntry : receiptNoticeEntryList) {
            sb.append("(").append(receiptNoticeEntry.getEntryId()).append(",").append(receiptNoticeEntry.getRnId()).append(",")
                    .append(receiptNoticeEntry.getProductId())
                    .append(",").append(receiptNoticeEntry.getPoeId()).append(",").append(receiptNoticeEntry.getDeliveryDate()).append(",")
                    .append(receiptNoticeEntry.getReciveWarehouseId()).append(",").append(receiptNoticeEntry.getRecivePositionId()).append(",")
                    .append(receiptNoticeEntry.getQuantity()).append(",").append(receiptNoticeEntry.getTransportCompanyId()).append(",");
            StrUtils.appBuider(sb, receiptNoticeEntry.getTrackingNumber());
            sb.append(",");
            StrUtils.appBuider(sb, receiptNoticeEntry.geteRemark());
            sb.append(",").append(receiptNoticeEntry.getRowClosed()).append(",").
                    append(receiptNoticeEntry.getSourceTypeId()).append(",").append(receiptNoticeEntry.getSourceId());
            sb.append("),");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    public String selectByPRNoticeEntry(PurchasePoReceiptNoticeEntry record) throws IllegalAccessException {
        SQL sql = new SQL();
        String alias = "rne";
        sql.SELECT("" + ProviderSqlStore.docChildV() + ",bltC.`transport_company_name`,`rne_id`,`entry_id`,`rn_id`,\n" +
                "" + alias + ".`product_id`,`source_type_id`,\n" +
                "`source_id`,`poe_id`,`delivery_date`," + alias + ".`warehouse_id`,\n" +
                "" + alias + ".`position_id`,`quantity`,\n" +
                "" + alias + ".`transport_company_id`,`tracking_number`,\n" +
                "" + alias + ".`e_remark`,`row_closed`," + alias + ".`version`\n" +
                "FROM `purchase_po_receipt_notice_entry` AS " + alias + "");
        //sql动态查询
        FieldStore.query(record.getClass(), record.getJsonArray(), record, sql,alias);
        sql.LEFT_OUTER_JOIN("basic_logisticsmgt_transport_company AS bltC on bltC.transport_company_id = " + alias + ".`transport_company_id`");
        //字表通用查询
        ProviderSqlStore.setDocumentChild(sql, alias, record);
        //查询货运公司
        AppendSqlStore.sqlWhere(record.getTransportCompanyName(), "bltC.`transport_company_name`", sql, Constants.SELECT,alias);
        sql.WHERE(alias + ".`del_or_not`=0");
        if (record.getInList() != null && record.getInList().size() > 0) {
            return sql.toString() + " AND " + StrUtils.in(record.getInList(), "rn_id");
        }
        return sql.toString();
    }

    public String updateByReceiptNoticeEntry(PurchasePoReceiptNoticeEntry record) {
        SQL sql = new SQL();

        sql.UPDATE("purchase_po_receipt_notice_entry");

        if (record.getEntryId() != null) {
            sql.SET("entry_id = #{entryId,jdbcType=INTEGER}");
        }

        if (record.getRnId() != null) {
            sql.SET("rn_id = #{rnId,jdbcType=BIGINT}");
        }

        if (record.getProductId() != null) {
            sql.SET("product_id = #{productId,jdbcType=INTEGER}");
        }

        if (record.getSourceTypeId() != null) {
            sql.SET("source_type_id = #{sourceTypeId,jdbcType=BIGINT}");
        }

        if (record.getSourceId() != null) {
            sql.SET("source_id = #{sourceId,jdbcType=BIGINT}");
        }

        if (record.getPoeId() != null) {
            sql.SET("poe_id = #{poeId,jdbcType=BIGINT}");
        }

        if (record.getDeliveryDate() != null) {
            sql.SET("delivery_date = #{deliveryDate,jdbcType=BIGINT}");
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

        if (record.getTransportCompanyId() != null) {
            sql.SET("transport_company_id = #{transportCompanyId,jdbcType=BIGINT}");
        }

        if (StringUtils.isNotBlank(record.getTrackingNumber())) {
            sql.SET("tracking_number = #{trackingNumber,jdbcType=VARCHAR}");
        }

        if (StringUtils.isNotBlank(record.geteRemark())) {
            sql.SET("e_remark = #{eRemark,jdbcType=VARCHAR}");
        }

        if (record.getRowClosed() != null) {
            sql.SET("row_closed = #{rowClosed,jdbcType=INTEGER}");
        }
        ProviderSqlStore.setVersion(sql, record.getVersion());
        sql.WHERE("rne_id=#{rneId}");
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("purchase_po_receipt_notice_entry");
        SET("rne_id = #{record.rneId,jdbcType=BIGINT}");
        SET("entry_id = #{record.entryId,jdbcType=INTEGER}");
        SET("rn_id = #{record.rnId,jdbcType=BIGINT}");
        SET("product_id = #{record.productId,jdbcType=INTEGER}");
        SET("source_type_id = #{record.sourceTypeId,jdbcType=BIGINT}");
        SET("source_id = #{record.sourceId,jdbcType=VARCHAR}");
        SET("poe_id = #{record.poeId,jdbcType=BIGINT}");
        SET("delivery_date = #{record.deliveryDate,jdbcType=BIGINT}");
        SET("recive_warehouse_id = #{record.reciveWarehouseId,jdbcType=BIGINT}");
        SET("recive_position_id = #{record.recivePositionId,jdbcType=BIGINT}");
        SET("quantity = #{record.quantity,jdbcType=DECIMAL}");
        SET("transport_company_id = #{record.transportCompanyId,jdbcType=BIGINT}");
        SET("TrackingNumber = #{record.trackingnumber,jdbcType=VARCHAR}");
        SET("rne_remark = #{record.rneRemark,jdbcType=VARCHAR}");
        SET("row_closed = #{record.rowClosed,jdbcType=INTEGER}");
        SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("del_or_not = #{record.delOrNot,jdbcType=BIT}");
        return SQL();
    }
}
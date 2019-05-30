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
import com.dt.project.store.FieldStore;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.utils.StrUtils;
import org.apache.ibatis.jdbc.SQL;

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

    public String insertSelective(PurchasePoReceiptNoticeEntry record) {
        BEGIN();
        INSERT_INTO("purchase_po_receipt_notice_entry");

        if (record.getRneId() != null) {
            VALUES("rne_id", "#{rneId,jdbcType=BIGINT}");
        }

        if (record.getEntryId() != null) {
            VALUES("entry_id", "#{entryId,jdbcType=INTEGER}");
        }

        if (record.getRnId() != null) {
            VALUES("rn_id", "#{rnId,jdbcType=BIGINT}");
        }

        if (record.getProductId() != null) {
            VALUES("product_id", "#{productId,jdbcType=INTEGER}");
        }

        if (record.getSourceTypeId() != null) {
            VALUES("source_type_id", "#{sourceTypeId,jdbcType=BIGINT}");
        }

        if (record.getSourceId() != null) {
            VALUES("source_id", "#{sourceId,jdbcType=VARCHAR}");
        }

        if (record.getPoeId() != null) {
            VALUES("poe_id", "#{poeId,jdbcType=BIGINT}");
        }

        if (record.getDeliveryDate() != null) {
            VALUES("delivery_date", "#{deliveryDate,jdbcType=BIGINT}");
        }

        if (record.getReciveWarehouseId() != null) {
            VALUES("recive_warehouse_id", "#{reciveWarehouseId,jdbcType=BIGINT}");
        }

        if (record.getRecivePositionId() != null) {
            VALUES("recive_position_id", "#{recivePositionId,jdbcType=BIGINT}");
        }

        if (record.getQuantity() != null) {
            VALUES("quantity", "#{quantity,jdbcType=DECIMAL}");
        }

        if (record.getTransportCompanyId() != null) {
            VALUES("transport_company_id", "#{transportCompanyId,jdbcType=BIGINT}");
        }

        if (record.getRneRemark() != null) {
            VALUES("rne_remark", "#{rneRemark,jdbcType=VARCHAR}");
        }

        if (record.getRowClosed() != null) {
            VALUES("row_closed", "#{rowClosed,jdbcType=INTEGER}");
        }
//
//        if (record.getStatusId() != null) {
//            VALUES("status_id", "#{statusId,jdbcType=BIGINT}");
//        }

        if (record.getVersion() != null) {
            VALUES("version", "#{version,jdbcType=INTEGER}");
        }

        if (record.getDelOrNot() != null) {
            VALUES("del_or_not", "#{delOrNot,jdbcType=BIT}");
        }

        return SQL();
    }

    public String selectByPRNoticeEntry(PurchasePoReceiptNoticeEntry record) throws IllegalAccessException {
        SQL sql = new SQL();
        String alias = "rne";
        sql.SELECT("`rne_id`,`entry_id`,`rn_id`,\n" +
                "`product_id`,`source_type_id`,\n" +
                "`source_id`,`poe_id`,`delivery_date`,`recive_warehouse_id`,\n" +
                "`recive_position_id`,`quantity`,\n" +
                "`transport_company_id`,`tracking_number`,\n" +
                "" + alias + ".`e_remark`,`row_closed`," + alias + ".`version`\n" +
                "FROM `purchase_po_receipt_notice_entry` AS " + alias + "");
        //sql动态查询
        FieldStore.query(record.getClass(), record.getJavaSqlName(), record, sql);
        sql.WHERE(alias + ".`del_or_not`=0");
        if (record.getInList() != null && record.getInList().size() > 0) {
            return sql.toString() + " AND " + StrUtils.in(record.getInList(), "rn_id");
        }
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        PurchasePoReceiptNoticeEntry record = (PurchasePoReceiptNoticeEntry) parameter.get("record");


        BEGIN();
        UPDATE("purchase_po_receipt_notice_entry");

        if (record.getRneId() != null) {
            SET("rne_id = #{record.rneId,jdbcType=BIGINT}");
        }

        if (record.getEntryId() != null) {
            SET("entry_id = #{record.entryId,jdbcType=INTEGER}");
        }

        if (record.getRnId() != null) {
            SET("rn_id = #{record.rnId,jdbcType=BIGINT}");
        }

        if (record.getProductId() != null) {
            SET("product_id = #{record.productId,jdbcType=INTEGER}");
        }

        if (record.getSourceTypeId() != null) {
            SET("source_type_id = #{record.sourceTypeId,jdbcType=BIGINT}");
        }

        if (record.getSourceId() != null) {
            SET("source_id = #{record.sourceId,jdbcType=VARCHAR}");
        }

        if (record.getPoeId() != null) {
            SET("poe_id = #{record.poeId,jdbcType=BIGINT}");
        }

        if (record.getDeliveryDate() != null) {
            SET("delivery_date = #{record.deliveryDate,jdbcType=BIGINT}");
        }

        if (record.getReciveWarehouseId() != null) {
            SET("recive_warehouse_id = #{record.reciveWarehouseId,jdbcType=BIGINT}");
        }

        if (record.getRecivePositionId() != null) {
            SET("recive_position_id = #{record.recivePositionId,jdbcType=BIGINT}");
        }

        if (record.getQuantity() != null) {
            SET("quantity = #{record.quantity,jdbcType=DECIMAL}");
        }

        if (record.getTransportCompanyId() != null) {
            SET("transport_company_id = #{record.transportCompanyId,jdbcType=BIGINT}");
        }


        if (record.getRneRemark() != null) {
            SET("rne_remark = #{record.rneRemark,jdbcType=VARCHAR}");
        }

        if (record.getRowClosed() != null) {
            SET("row_closed = #{record.rowClosed,jdbcType=INTEGER}");
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
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

import com.dt.project.model.purchasePo.PurchasePoOrder;
import com.dt.project.model.purchasePo.PurchasePoOrderEntry;
import com.dt.project.store.FieldStore;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.utils.StrUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class PurchasePoOrderEntrySqlProvider {

    public String countByExample(PurchasePoOrder example) {
        BEGIN();
        SELECT("count(*)");
        FROM("purchase_po_order_entry");

        return SQL();
    }

    public String deleteByExample(PurchasePoOrder example) {
        BEGIN();
        DELETE_FROM("purchase_po_order_entry");

        return SQL();
    }

    public String insertPoOrderEntry(Map<String, List<PurchasePoOrderEntry>> poOrderMap) {
        List<PurchasePoOrderEntry> poOrderEntryList = poOrderMap.get("recordList");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO purchase_po_order_entry " +
                "(entry_id,po_id, product_id,quantity, tax_rate,price, price_tax,\n" +
                "tax_amt, amount,amount_tax, poe_source_type_id,\n" +
                "poe_source_id, delivery_date,\n" +
                "invoice_entry_id, recive_warehouse_id,\n" +
                "recive_position_id, poe_qu_qty,\n" +
                "poe_fa_qty, inbound_qty,\n" +
                "poe_return_qty,e_remark,\n" +
                "row_closed)\n" +
                "value");
        for (PurchasePoOrderEntry poOrderEntry : poOrderEntryList) {
            sb.append("(").append(poOrderEntry.getEntryId()).append(",").
                    append(poOrderEntry.getPoId()).append(",").append(poOrderEntry.getProductId()).append(",");
            sb.append(poOrderEntry.getQuantity()).append(",").append(poOrderEntry.getTaxRate()).append(",");
            sb.append(poOrderEntry.getPrice()).append(",").append(poOrderEntry.getPriceTax()).append(",");
            sb.append(poOrderEntry.getTaxAmt()).append(",").append(poOrderEntry.getAmount()).append(",").
                    append(poOrderEntry.getAmountTax()).append(",").append(poOrderEntry.getPoeSourceTypeId()).append(",");
            StrUtils.appBuider(sb, poOrderEntry.getPoeSourceId());
            sb.append(",").append(poOrderEntry.getDeliveryDate()).append(",")
                    .append(poOrderEntry.getInvoiceEntryId()).append(",").append(poOrderEntry.getReciveWarehouseId()).append(",")
                    .append(poOrderEntry.getRecivePositionId()).append(",").append(poOrderEntry.getPoeQuQty()).append(",")
                    .append(poOrderEntry.getPoeFaQty()).append(",").append(poOrderEntry.getInboundQty()).append(",")
                    .append(poOrderEntry.getPoeReturnQty()).append(",");
            StrUtils.appBuider(sb, poOrderEntry.getPoeRemark());
            sb.append(",").append(poOrderEntry.getRowClosed());
            sb.append("),");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    public String selectByPoOrderEntry(PurchasePoOrderEntry poOrderEntry) throws IllegalAccessException {
        String alias = "poe";
        SQL sql = new SQL();
        sql.SELECT("`poe_id`,`entry_id`,`po_id`,`product_id`,`tax_rate`,`price`,`price_tax`,\n" +
                "`tax_amt`,`amount`,`amount_tax`,`poe_source_type_id`,`poe_source_id`,`delivery_date`,`invoice_entry_id`,\n" +
                "`recive_warehouse_id`,`recive_position_id`,`poe_qu_qty`, `poe_fa_qty`,`inbound_qty`, `poe_return_qty`," +
                "" + alias + ".`e_remark`,`row_closed`," + alias + ".`version` FROM `purchase_po_order_entry` AS " + alias + "");
        //sql动态查询
        FieldStore.query(poOrderEntry.getClass(), poOrderEntry.getJavaSqlName(), poOrderEntry, sql);
        sql.WHERE(alias + ".`del_or_not`=0");
        if (poOrderEntry.getInList() != null && poOrderEntry.getInList().size() > 0) {
            return sql.toString() + " AND " + StrUtils.in(poOrderEntry.getInList(), "poe_id");
        }
        return sql.toString();


    }

    public String updateByPoOrderEntry(PurchasePoOrderEntry record) {
        SQL sql = new SQL();
        sql.UPDATE("purchase_po_order_entry");

        if (record.getEntryId() != null) {
            sql.SET("entry_id = #{entryId,jdbcType=INTEGER}");
        }

        if (record.getPoId() != null) {
            sql.SET("po_id = #{poId,jdbcType=BIGINT}");
        }

        if (record.getProductId() != null) {
            sql.SET("product_id = #{productId,jdbcType=INTEGER}");
        }

        if (record.getQuantity() != null) {
            sql.SET("quantity = #{quantity,jdbcType=DECIMAL}");
        }

        if (record.getTaxRate() != null) {
            sql.SET("tax_rate = #{taxRate,jdbcType=DECIMAL}");
        }

        if (record.getPrice() != null) {
            sql.SET("price = #{price,jdbcType=DECIMAL}");
        }

        if (record.getPriceTax() != null) {
            sql.SET("price_tax = #{priceTax,jdbcType=DECIMAL}");
        }

        if (record.getTaxAmt() != null) {
            sql.SET("tax_amt = #{taxAmt,jdbcType=DECIMAL}");
        }

        if (record.getAmount() != null) {
            sql.SET("amount = #{amount,jdbcType=DECIMAL}");
        }

        if (record.getAmountTax() != null) {
            sql.SET("amount_tax = #{amountTax,jdbcType=DECIMAL}");
        }

        if (record.getPoeSourceTypeId() != null) {
            sql.SET("poe_source_type_id = #{poeSourceTypeId,jdbcType=BIGINT}");
        }

        if (StringUtils.isNotBlank(record.getPoeSourceId())) {
            sql.SET("poe_source_id = #{poeSourceId,jdbcType=VARCHAR}");
        }

        if (record.getDeliveryDate() != null) {
            sql.SET("delivery_date = #{deliveryDate,jdbcType=BIGINT}");
        }

        if (record.getInvoiceEntryId() != null) {
            sql.SET("invoice_entry_id = #{invoiceEntryId,jdbcType=BIGINT}");
        }

        if (record.getReciveWarehouseId() != null) {
            sql.SET("recive_warehouse_id = #{reciveWarehouseId,jdbcType=BIGINT}");
        }

        if (record.getRecivePositionId() != null) {
            sql.SET("recive_position_id = #{recivePositionId,jdbcType=BIGINT}");
        }

        if (record.getPoeQuQty() != null) {
            sql.SET("poe_qu_qty = #{poeQuQty,jdbcType=DECIMAL}");
        }

        if (record.getPoeFaQty() != null) {
            sql.SET("poe_fa_qty = #{poeFaQty,jdbcType=DECIMAL}");
        }

        if (record.getInboundQty() != null) {
            sql.SET("inbound_qty = #{inboundQty,jdbcType=DECIMAL}");
        }

        if (record.getPoeReturnQty() != null) {
            sql.SET("poe_return_qty = #{poeReturnQty,jdbcType=DECIMAL}");
        }

        if (StringUtils.isNotBlank(record.getPoeRemark())) {
            sql.SET("e_remark = #{poeRemark,jdbcType=VARCHAR}");
        }

        if (record.getRowClosed() != null) {
            sql.SET("row_closed = #{rowClosed,jdbcType=INTEGER}");
        }
        ProviderSqlStore.setVersion(sql, record.getVersion());
        sql.WHERE("poe_id = #{poeId,jdbcType=BIGINT}");
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("purchase_po_order_entry");

        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("entry_id = #{record.entryId,jdbcType=INTEGER}");
        SET("po_id = #{record.poId,jdbcType=BIGINT}");
        SET("product_id = #{record.productId,jdbcType=INTEGER}");
        SET("tax_rate = #{record.taxRate,jdbcType=DECIMAL}");
        SET("price = #{record.price,jdbcType=DECIMAL}");
        SET("price_tax = #{record.priceTax,jdbcType=DECIMAL}");
        SET("tax_amount = #{record.taxAmount,jdbcType=DECIMAL}");
        SET("poe_amount = #{record.poeAmount,jdbcType=DECIMAL}");
        SET("poe_amount_tax = #{record.poeAmountTax,jdbcType=DECIMAL}");
        SET("poe__source_type_id = #{record.poeSourceTypeId,jdbcType=BIGINT}");
        SET("poe__source_id = #{record.poeSourceId,jdbcType=VARCHAR}");
        SET("delivery_date = #{record.deliveryDate,jdbcType=BIGINT}");
        SET("invoice_entry_id = #{record.invoiceEntryId,jdbcType=BIGINT}");
        SET("recive_warehouse_id = #{record.reciveWarehouseId,jdbcType=BIGINT}");
        SET("recive_position_id = #{record.recivePositionId,jdbcType=BIGINT}");
        SET("poe_qu_qty = #{record.poeQuQty,jdbcType=DECIMAL}");
        SET("poe_fa_qty = #{record.poeFaQty,jdbcType=DECIMAL}");
        SET("inbound_qty = #{record.inboundQty,jdbcType=DECIMAL}");
        SET("poe_return_qty = #{record.poeReturnQty,jdbcType=DECIMAL}");
        SET("poe_remark = #{record.poeRemark,jdbcType=VARCHAR}");
        SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("del_or_not = #{record.delOrNot,jdbcType=BIT}");

        return SQL();
    }

}
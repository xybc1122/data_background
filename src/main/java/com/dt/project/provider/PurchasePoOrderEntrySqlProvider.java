package com.dt.project.provider;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;

import com.dt.project.model.PurchasePo.PurchasePoOrder;
import com.dt.project.model.PurchasePo.PurchasePoOrderEntry;
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

    public String insertSelective(PurchasePoOrderEntry record) {
        BEGIN();
        INSERT_INTO("purchase_po_order_entry");
        
        if (record.getEntryId() != null) {
            VALUES("entry_id", "#{entryId,jdbcType=INTEGER}");
        }
        
        if (record.getPoId() != null) {
            VALUES("po_id", "#{poId,jdbcType=BIGINT}");
        }
        
        if (record.getProductId() != null) {
            VALUES("product_id", "#{productId,jdbcType=INTEGER}");
        }
        
        if (record.getTaxRate() != null) {
            VALUES("tax_rate", "#{taxRate,jdbcType=DECIMAL}");
        }
        
        if (record.getPrice() != null) {
            VALUES("price", "#{price,jdbcType=DECIMAL}");
        }
        
        if (record.getPriceTax() != null) {
            VALUES("price_tax", "#{priceTax,jdbcType=DECIMAL}");
        }
        
        if (record.getPoeTaxAmount() != null) {
            VALUES("poe_tax_amount", "#{poeTaxAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPoeAmount() != null) {
            VALUES("poe_amount", "#{poeAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPoeAmountTax() != null) {
            VALUES("poe_amount_tax", "#{poeAmountTax,jdbcType=DECIMAL}");
        }
        
        if (record.getPoeSourceTypeId() != null) {
            VALUES("poe__source_type_id", "#{poeSourceTypeId,jdbcType=BIGINT}");
        }
        
        if (record.getPoeSourceId() != null) {
            VALUES("poe__source_id", "#{poeSourceId,jdbcType=VARCHAR}");
        }
        
        if (record.getDeliveryDate() != null) {
            VALUES("delivery_date", "#{deliveryDate,jdbcType=BIGINT}");
        }
        
        if (record.getInvoiceEntryId() != null) {
            VALUES("invoice_entry_id", "#{invoiceEntryId,jdbcType=BIGINT}");
        }
        
        if (record.getReciveWarehouseId() != null) {
            VALUES("recive_warehouse_id", "#{reciveWarehouseId,jdbcType=BIGINT}");
        }
        
        if (record.getRecivePositionId() != null) {
            VALUES("recive_position_id", "#{recivePositionId,jdbcType=BIGINT}");
        }
        
        if (record.getPoeQuQty() != null) {
            VALUES("poe_qu_qty", "#{poeQuQty,jdbcType=DECIMAL}");
        }
        
        if (record.getPoeFaQty() != null) {
            VALUES("poe_fa_qty", "#{poeFaQty,jdbcType=DECIMAL}");
        }
        
        if (record.getPoeInboundQty() != null) {
            VALUES("poe_inbound_qty", "#{poeInboundQty,jdbcType=DECIMAL}");
        }
        
        if (record.getPoeReturnQty() != null) {
            VALUES("poe_return_qty", "#{poeReturnQty,jdbcType=DECIMAL}");
        }
        
        if (record.getPoeRemark() != null) {
            VALUES("poe_remark", "#{poeRemark,jdbcType=VARCHAR}");
        }
        
        if (record.getStatusId() != null) {
            VALUES("status_id", "#{statusId,jdbcType=BIGINT}");
        }
        
        if (record.getVersion() != null) {
            VALUES("version", "#{version,jdbcType=INTEGER}");
        }
        
        if (record.getDelOrNot() != null) {
            VALUES("del_or_not", "#{delOrNot,jdbcType=BIT}");
        }
        
        return SQL();
    }

    public String selectByExample(PurchasePoOrder example) {

        SELECT("entry_id");
        SELECT("po_id");
        SELECT("product_id");
        SELECT("tax_rate");
        SELECT("price");
        SELECT("price_tax");
        SELECT("poe_tax_amount");
        SELECT("poe_amount");
        SELECT("poe_amount_tax");
        SELECT("poe__source_type_id");
        SELECT("poe__source_id");
        SELECT("delivery_date");
        SELECT("invoice_entry_id");
        SELECT("recive_warehouse_id");
        SELECT("recive_position_id");
        SELECT("poe_qu_qty");
        SELECT("poe_fa_qty");
        SELECT("poe_inbound_qty");
        SELECT("poe_return_qty");
        SELECT("poe_remark");
        SELECT("status_id");
        SELECT("version");
        SELECT("del_or_not");
        FROM("purchase_po_order_entry");

        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        PurchasePoOrderEntry record = (PurchasePoOrderEntry) parameter.get("record");

        UPDATE("purchase_po_order_entry");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getEntryId() != null) {
            SET("entry_id = #{record.entryId,jdbcType=INTEGER}");
        }
        
        if (record.getPoId() != null) {
            SET("po_id = #{record.poId,jdbcType=BIGINT}");
        }
        
        if (record.getProductId() != null) {
            SET("product_id = #{record.productId,jdbcType=INTEGER}");
        }
        
        if (record.getTaxRate() != null) {
            SET("tax_rate = #{record.taxRate,jdbcType=DECIMAL}");
        }
        
        if (record.getPrice() != null) {
            SET("price = #{record.price,jdbcType=DECIMAL}");
        }
        
        if (record.getPriceTax() != null) {
            SET("price_tax = #{record.priceTax,jdbcType=DECIMAL}");
        }
        
        if (record.getPoeTaxAmount() != null) {
            SET("poe_tax_amount = #{record.poeTaxAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPoeAmount() != null) {
            SET("poe_amount = #{record.poeAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPoeAmountTax() != null) {
            SET("poe_amount_tax = #{record.poeAmountTax,jdbcType=DECIMAL}");
        }
        
        if (record.getPoeSourceTypeId() != null) {
            SET("poe__source_type_id = #{record.poeSourceTypeId,jdbcType=BIGINT}");
        }
        
        if (record.getPoeSourceId() != null) {
            SET("poe__source_id = #{record.poeSourceId,jdbcType=VARCHAR}");
        }
        
        if (record.getDeliveryDate() != null) {
            SET("delivery_date = #{record.deliveryDate,jdbcType=BIGINT}");
        }
        
        if (record.getInvoiceEntryId() != null) {
            SET("invoice_entry_id = #{record.invoiceEntryId,jdbcType=BIGINT}");
        }
        
        if (record.getReciveWarehouseId() != null) {
            SET("recive_warehouse_id = #{record.reciveWarehouseId,jdbcType=BIGINT}");
        }
        
        if (record.getRecivePositionId() != null) {
            SET("recive_position_id = #{record.recivePositionId,jdbcType=BIGINT}");
        }
        
        if (record.getPoeQuQty() != null) {
            SET("poe_qu_qty = #{record.poeQuQty,jdbcType=DECIMAL}");
        }
        
        if (record.getPoeFaQty() != null) {
            SET("poe_fa_qty = #{record.poeFaQty,jdbcType=DECIMAL}");
        }
        
        if (record.getPoeInboundQty() != null) {
            SET("poe_inbound_qty = #{record.poeInboundQty,jdbcType=DECIMAL}");
        }
        
        if (record.getPoeReturnQty() != null) {
            SET("poe_return_qty = #{record.poeReturnQty,jdbcType=DECIMAL}");
        }
        
        if (record.getPoeRemark() != null) {
            SET("poe_remark = #{record.poeRemark,jdbcType=VARCHAR}");
        }
        
        if (record.getStatusId() != null) {
            SET("status_id = #{record.statusId,jdbcType=BIGINT}");
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
        UPDATE("purchase_po_order_entry");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("entry_id = #{record.entryId,jdbcType=INTEGER}");
        SET("po_id = #{record.poId,jdbcType=BIGINT}");
        SET("product_id = #{record.productId,jdbcType=INTEGER}");
        SET("tax_rate = #{record.taxRate,jdbcType=DECIMAL}");
        SET("price = #{record.price,jdbcType=DECIMAL}");
        SET("price_tax = #{record.priceTax,jdbcType=DECIMAL}");
        SET("poe_tax_amount = #{record.poeTaxAmount,jdbcType=DECIMAL}");
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
        SET("poe_inbound_qty = #{record.poeInboundQty,jdbcType=DECIMAL}");
        SET("poe_return_qty = #{record.poeReturnQty,jdbcType=DECIMAL}");
        SET("poe_remark = #{record.poeRemark,jdbcType=VARCHAR}");
        SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("del_or_not = #{record.delOrNot,jdbcType=BIT}");

        return SQL();
    }

}
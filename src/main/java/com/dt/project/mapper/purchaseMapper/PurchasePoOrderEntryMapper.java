package com.dt.project.mapper.purchaseMapper;

import com.dt.project.model.purchasePo.PurchasePoOrderEntry;

import java.util.List;

import com.dt.project.provider.PurchasePoOrderEntrySqlProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

public interface PurchasePoOrderEntryMapper {
    @SelectProvider(type = PurchasePoOrderEntrySqlProvider.class, method = "countByExample")
    int countByExample(PurchasePoOrderEntry example);

    @DeleteProvider(type = PurchasePoOrderEntrySqlProvider.class, method = "deleteByExample")
    int deleteByExample(PurchasePoOrderEntry example);

    @Insert({
            "insert into purchase_po_order_entry (entry_id, po_id, ",
            "product_id, tax_rate, ",
            "price, price_tax, ",
            "poe_tax_amount, poe_amount, ",
            "poe_amount_tax, poe__source_type_id, ",
            "poe__source_id, delivery_date, ",
            "invoice_entry_id, recive_warehouse_id, ",
            "recive_position_id, poe_qu_qty, ",
            "poe_fa_qty, poe_inbound_qty, ",
            "poe_return_qty, poe_remark, ",
            "status_id, version, ",
            "del_or_not)",
            "values (#{entryId,jdbcType=INTEGER}, #{poId,jdbcType=BIGINT}, ",
            "#{productId,jdbcType=INTEGER}, #{taxRate,jdbcType=DECIMAL}, ",
            "#{price,jdbcType=DECIMAL}, #{priceTax,jdbcType=DECIMAL}, ",
            "#{poeTaxAmount,jdbcType=DECIMAL}, #{poeAmount,jdbcType=DECIMAL}, ",
            "#{poeAmountTax,jdbcType=DECIMAL}, #{poeSourceTypeId,jdbcType=BIGINT}, ",
            "#{poeSourceId,jdbcType=VARCHAR}, #{deliveryDate,jdbcType=BIGINT}, ",
            "#{invoiceEntryId,jdbcType=BIGINT}, #{reciveWarehouseId,jdbcType=BIGINT}, ",
            "#{recivePositionId,jdbcType=BIGINT}, #{poeQuQty,jdbcType=DECIMAL}, ",
            "#{poeFaQty,jdbcType=DECIMAL}, #{poeInboundQty,jdbcType=DECIMAL}, ",
            "#{poeReturnQty,jdbcType=DECIMAL}, #{poeRemark,jdbcType=VARCHAR}, ",
            "#{statusId,jdbcType=BIGINT}, #{version,jdbcType=INTEGER}, ",
            "#{delOrNot,jdbcType=BIT})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(PurchasePoOrderEntry record);

    @InsertProvider(type = PurchasePoOrderEntrySqlProvider.class, method = "insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSelective(PurchasePoOrderEntry record);

    /**
     * 查询  一对多 采购订单表体
     *
     * @param record
     * @return
     */
    @SelectProvider(type = PurchasePoOrderEntrySqlProvider.class, method = "selectByPoOrderEntry")
    List<PurchasePoOrderEntry> selectByPoOrderEntry(PurchasePoOrderEntry record);

    @UpdateProvider(type = PurchasePoOrderEntrySqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PurchasePoOrderEntry record);

    @UpdateProvider(type = PurchasePoOrderEntrySqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") PurchasePoOrderEntry record);
}
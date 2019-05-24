package com.dt.project.mapper.PurchasePoOrderMapper;

import com.dt.project.model.PurchasePo.PurchasePoOrderEntry;
import java.util.List;

import com.dt.project.provider.PurchasePoOrderEntrySqlProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface PurchasePoOrderEntryMapper {
    @SelectProvider(type= PurchasePoOrderEntrySqlProvider.class, method="countByExample")
    int countByExample(PurchasePoOrderEntry example);

    @DeleteProvider(type=PurchasePoOrderEntrySqlProvider.class, method="deleteByExample")
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
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(PurchasePoOrderEntry record);

    @InsertProvider(type=PurchasePoOrderEntrySqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(PurchasePoOrderEntry record);

    @SelectProvider(type=PurchasePoOrderEntrySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT),
        @Result(column="entry_id", property="entryId", jdbcType=JdbcType.INTEGER),
        @Result(column="po_id", property="poId", jdbcType=JdbcType.BIGINT),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER),
        @Result(column="tax_rate", property="taxRate", jdbcType=JdbcType.DECIMAL),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="price_tax", property="priceTax", jdbcType=JdbcType.DECIMAL),
        @Result(column="poe_tax_amount", property="poeTaxAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="poe_amount", property="poeAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="poe_amount_tax", property="poeAmountTax", jdbcType=JdbcType.DECIMAL),
        @Result(column="poe__source_type_id", property="poeSourceTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="poe__source_id", property="poeSourceId", jdbcType=JdbcType.VARCHAR),
        @Result(column="delivery_date", property="deliveryDate", jdbcType=JdbcType.BIGINT),
        @Result(column="invoice_entry_id", property="invoiceEntryId", jdbcType=JdbcType.BIGINT),
        @Result(column="recive_warehouse_id", property="reciveWarehouseId", jdbcType=JdbcType.BIGINT),
        @Result(column="recive_position_id", property="recivePositionId", jdbcType=JdbcType.BIGINT),
        @Result(column="poe_qu_qty", property="poeQuQty", jdbcType=JdbcType.DECIMAL),
        @Result(column="poe_fa_qty", property="poeFaQty", jdbcType=JdbcType.DECIMAL),
        @Result(column="poe_inbound_qty", property="poeInboundQty", jdbcType=JdbcType.DECIMAL),
        @Result(column="poe_return_qty", property="poeReturnQty", jdbcType=JdbcType.DECIMAL),
        @Result(column="poe_remark", property="poeRemark", jdbcType=JdbcType.VARCHAR),
        @Result(column="status_id", property="statusId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="del_or_not", property="delOrNot", jdbcType=JdbcType.BIT)
    })
    List<PurchasePoOrderEntry> selectByExample(PurchasePoOrderEntry example);

    @UpdateProvider(type=PurchasePoOrderEntrySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PurchasePoOrderEntry record);

    @UpdateProvider(type=PurchasePoOrderEntrySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PurchasePoOrderEntry record);
}
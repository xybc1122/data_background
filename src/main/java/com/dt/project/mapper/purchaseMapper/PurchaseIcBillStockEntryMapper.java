package com.dt.project.mapper.purchaseMapper;

import com.dt.project.provider.PurchaseIcBillStockEntrySqlProvider;
import com.dt.project.model.purchasePo.PurchaseIcBillStockEntry;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

public interface PurchaseIcBillStockEntryMapper {
    @SelectProvider(type = PurchaseIcBillStockEntrySqlProvider.class, method = "countByExample")
    int countByExample(PurchaseIcBillStockEntry example);

    @DeleteProvider(type = PurchaseIcBillStockEntrySqlProvider.class, method = "deleteByExample")
    int deleteByExample(PurchaseIcBillStockEntry example);

    @Insert({
            "insert into purchase_ic_bill_stock_entry (sbe_id, entry_id, ",
            "sb_id, product_id, ",
            "source_type_id, source_id, ",
            "rne_id, recive_warehouse_id, ",
            "recive_position_id, quantity, ",
            "e_remark, row_closed, ",
            "version, del_or_not)",
            "values (#{sbeId,jdbcType=BIGINT}, #{entryId,jdbcType=INTEGER}, ",
            "#{sbId,jdbcType=BIGINT}, #{productId,jdbcType=INTEGER}, ",
            "#{sourceTypeId,jdbcType=BIGINT}, #{sourceId,jdbcType=VARCHAR}, ",
            "#{rneId,jdbcType=BIGINT}, #{reciveWarehouseId,jdbcType=BIGINT}, ",
            "#{recivePositionId,jdbcType=BIGINT}, #{quantity,jdbcType=DECIMAL}, ",
            "#{eRemark,jdbcType=VARCHAR}, #{rowClosed,jdbcType=INTEGER}, ",
            "#{version,jdbcType=INTEGER}, #{delOrNot,jdbcType=BIT})"
    })
    int insert(PurchaseIcBillStockEntry record);

    @InsertProvider(type = PurchaseIcBillStockEntrySqlProvider.class, method = "insertSelective")
    int insertSelective(PurchaseIcBillStockEntry record);

    /**
     * 查询外购出库单表体 用于一对多
     *
     * @param record
     * @return
     */
    @SelectProvider(type = PurchaseIcBillStockEntrySqlProvider.class, method = "selectByIcBillStockEntry")
    List<PurchaseIcBillStockEntry> selectByIcBillStockEntry(PurchaseIcBillStockEntry record);

    @UpdateProvider(type = PurchaseIcBillStockEntrySqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PurchaseIcBillStockEntry record, @Param("example") PurchaseIcBillStockEntry example);

    @UpdateProvider(type = PurchaseIcBillStockEntrySqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") PurchaseIcBillStockEntry record, @Param("example") PurchaseIcBillStockEntry example);
}
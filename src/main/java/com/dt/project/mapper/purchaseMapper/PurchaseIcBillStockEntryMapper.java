package com.dt.project.mapper.purchaseMapper;

import com.dt.project.provider.PurchaseIcBillStockEntrySqlProvider;
import com.dt.project.model.purchasePo.PurchaseIcBillStockEntry;

import java.util.List;

import org.apache.ibatis.annotations.*;

public interface PurchaseIcBillStockEntryMapper {
    @SelectProvider(type = PurchaseIcBillStockEntrySqlProvider.class, method = "countByExample")
    int countByExample(PurchaseIcBillStockEntry example);

    @DeleteProvider(type = PurchaseIcBillStockEntrySqlProvider.class, method = "deleteByExample")
    int deleteByExample(PurchaseIcBillStockEntry example);

    /**
     * 批量新增外购出库单表体
     *
     * @param record
     * @return
     */
    @InsertProvider(type = PurchaseIcBillStockEntrySqlProvider.class, method = "insertIcBillStockEntry")
    int insertIcBillStockEntry(@Param("IcBillStockEntryList") List<PurchaseIcBillStockEntry> record);

    /**
     * 查询外购出库单表体 用于一对多
     *
     * @param record
     * @return
     */
    @SelectProvider(type = PurchaseIcBillStockEntrySqlProvider.class, method = "selectByIcBillStockEntry")
    List<PurchaseIcBillStockEntry> selectByIcBillStockEntry(PurchaseIcBillStockEntry record);

    /**
     * 修改外购出库单子表
     *
     * @param record
     * @return
     */
    @UpdateProvider(type = PurchaseIcBillStockEntrySqlProvider.class, method = "updateByIcBillStockEntry")
    int updateByIcBillStockEntry(PurchaseIcBillStockEntry record);






    @UpdateProvider(type = PurchaseIcBillStockEntrySqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") PurchaseIcBillStockEntry record, @Param("example") PurchaseIcBillStockEntry example);
}
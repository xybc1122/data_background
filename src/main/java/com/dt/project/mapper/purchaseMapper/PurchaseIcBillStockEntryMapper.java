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
    @Results({
            @Result(property = "icBRemark", column = "e_remark"),
            @Result(property = "icBSourceId", column = "source_id")
    })
    List<PurchaseIcBillStockEntry> selectByIcBillStockEntry(PurchaseIcBillStockEntry record);


    @UpdateProvider(type = PurchaseIcBillStockEntrySqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PurchaseIcBillStockEntry record, @Param("example") PurchaseIcBillStockEntry example);

    @UpdateProvider(type = PurchaseIcBillStockEntrySqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") PurchaseIcBillStockEntry record, @Param("example") PurchaseIcBillStockEntry example);
}
package com.dt.project.mapper.purchaseMapper;

import com.dt.project.provider.PurchasePoReceiptNoticeEntrySqlProvider;
import com.dt.project.model.purchasePo.PurchasePoReceiptNoticeEntry;

import java.util.List;

import org.apache.ibatis.annotations.*;

public interface PurchasePoReceiptNoticeEntryMapper {
    @SelectProvider(type = PurchasePoReceiptNoticeEntrySqlProvider.class, method = "countByExample")
    int countByExample(PurchasePoReceiptNoticeEntry example);

    @DeleteProvider(type = PurchasePoReceiptNoticeEntrySqlProvider.class, method = "deleteByExample")
    int deleteByExample(PurchasePoReceiptNoticeEntry example);




    /**
     * 批量新增收货通知单子表数据
     *
     * @param record
     * @return
     */
    @InsertProvider(type = PurchasePoReceiptNoticeEntrySqlProvider.class, method = "insertReceiptNoticeEntry")
    int insertReceiptNoticeEntry(@Param("poReceiptNoticeEntryList") List<PurchasePoReceiptNoticeEntry> record);

    /**
     * 收货通知单一对多查询
     *
     * @param record
     * @return
     */
    @SelectProvider(type = PurchasePoReceiptNoticeEntrySqlProvider.class, method = "selectByPRNoticeEntry")
    List<PurchasePoReceiptNoticeEntry> selectByPRNoticeEntry(PurchasePoReceiptNoticeEntry record);


    /**
     * 修改收货通知单子表数据
     *
     * @param record
     * @return
     */
    @UpdateProvider(type = PurchasePoReceiptNoticeEntrySqlProvider.class, method = "updateByReceiptNoticeEntry")
    int updateByReceiptNoticeEntry(PurchasePoReceiptNoticeEntry record);





    @UpdateProvider(type = PurchasePoReceiptNoticeEntrySqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") PurchasePoReceiptNoticeEntry record, @Param("example") PurchasePoReceiptNoticeEntry example);
}
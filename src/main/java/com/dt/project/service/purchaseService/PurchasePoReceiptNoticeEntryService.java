package com.dt.project.service.purchaseService;

import com.dt.project.model.purchasePo.PurchasePoReceiptNoticeEntry;

import java.util.List;

/**
 * @ClassName PurchasePoReceiptNoticeEntryService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/30 9:05
 **/
public interface PurchasePoReceiptNoticeEntryService {

    /**
     * 收货通知单一对多查询
     *
     * @param record
     * @return
     */
    List<PurchasePoReceiptNoticeEntry> serviceSelectByPRNoticeEntry(PurchasePoReceiptNoticeEntry record);


    /**
     * 批量新增收货通知单子表数据
     *
     * @param record
     * @return
     */
    int serviceInsertReceiptNoticeEntry(List<PurchasePoReceiptNoticeEntry> record);


    /**
     * 修改收货通知单子表数据
     *
     * @param record
     * @return
     */
    int serviceUpdateByReceiptNoticeEntry(PurchasePoReceiptNoticeEntry record);


}

package com.dt.project.service.purchaseService;

import com.dt.project.model.purchasePo.PurchaseIcBillStockEntry;

import java.util.List;

/**
 * @ClassName PurchaseIcBillStockEntryService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/30 14:19
 **/
public interface PurchaseIcBillStockEntryService {

    /**
     * 查询外购出库单表体 用于一对多
     *
     * @param record
     * @return
     */
    List<PurchaseIcBillStockEntry> serviceSelectByIcBillStockEntry(PurchaseIcBillStockEntry record);


    /**
     * 批量新增外购出库单表体
     *
     * @param record
     * @return
     */
    int serviceInsertIcBillStockEntry(List<PurchaseIcBillStockEntry> record);
}

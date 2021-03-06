package com.dt.project.service.purchaseService;

import com.dt.project.model.purchasePo.PurchasePoOrderEntry;

import java.util.List;

/**
 * @ClassName PurchasePoOrderEntryService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/27 10:24
 **/
public interface PurchasePoOrderEntryService {


    /**
     * 查询  一对多 采购订单表体
     *
     * @param record
     * @return
     */
    List<PurchasePoOrderEntry> serviceSelectByPoOrderEntry(PurchasePoOrderEntry record);

    /**
     * 存入采购订单子表
     *
     * @param record
     * @return
     */
    int serviceInsertPoOrderEntry(List<PurchasePoOrderEntry> record);

    /**
     * 更新采购订单子表
     *
     * @param record
     * @return
     */
    int serviceUpdateByPoOrderEntry(PurchasePoOrderEntry record);

}

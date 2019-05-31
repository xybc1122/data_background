package com.dt.project.service.purchaseService;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.purchasePo.PurchasePoReceiptNotice;

import java.util.Map;

/**
 * @ClassName PurchasePoReceiptNoticeService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/30 8:50
 **/
public interface PurchasePoReceiptNoticeService {


    /**
     * 查询收货通知单
     *
     * @param record
     * @return
     */

    ResponseBase serviceSelectByPoReceiptNotice(PurchasePoReceiptNotice record);

    /**
     * 新增收货通知单
     *
     * @param objectMap
     * @return
     */
    ResponseBase serviceInsertPoReceiptNotice(Map<String, Object> objectMap);


    /**
     * 修改发货通知单
     *
     * @param objectMap
     * @return
     */
    ResponseBase serviceUpdateByPoReceiptNotice(Map<String, Object> objectMap);

}

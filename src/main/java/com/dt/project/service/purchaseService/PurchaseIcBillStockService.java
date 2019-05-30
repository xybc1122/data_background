package com.dt.project.service.purchaseService;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.purchasePo.PurchaseIcBillStock;

/**
 * @ClassName PurchaseIcBillStockService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/30 14:06
 **/
public interface PurchaseIcBillStockService {


    /**
     * 查询外购入库接口
     *
     * @param record
     * @return
     */

    ResponseBase serviceSelectByIcBillStock(PurchaseIcBillStock record);
}

package com.dt.project.service.purchaseService;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.purchasePo.PurchasePoOrder;

/**
 * @ClassName PurchasePoOrderService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/27 10:05
 **/
public interface PurchasePoOrderService {


    /**
     * 查询采购订单表
     *
     * @return
     */
    ResponseBase serviceSelectByPoOrder(PurchasePoOrder record);
}

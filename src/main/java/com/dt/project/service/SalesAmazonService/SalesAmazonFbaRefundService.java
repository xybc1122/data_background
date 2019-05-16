package com.dt.project.service.SalesAmazonService;

import com.dt.project.model.SalesAmazon.SalesAmazonFbaRefund;

import java.util.List;

public interface SalesAmazonFbaRefundService {



    /**
     * 存入退货数据
     *
     * @return
     */
    int serviceAddSalesAmazonAdRefundList(List<SalesAmazonFbaRefund> refundList);

    /**
     * 查询退货报告数据
     */
    List<SalesAmazonFbaRefund> serviceFindByListRefund(SalesAmazonFbaRefund report);
}

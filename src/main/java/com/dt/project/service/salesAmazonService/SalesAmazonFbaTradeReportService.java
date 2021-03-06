package com.dt.project.service.salesAmazonService;

import com.dt.project.model.salesAmazon.SalesAmazonFbaTradeReport;

import java.util.List;

public interface SalesAmazonFbaTradeReportService {

    /**
     * 存入订单数据 txt
     *
     * @return
     */
    int serviceAddSalesAmazonAdTrdList(List<SalesAmazonFbaTradeReport> trdList);

    /**
     * 通过站点店铺ID 跟订单号 查询 下单时间 站点 ID
     */
    SalesAmazonFbaTradeReport getReport(Integer sId, String oId);


    /**
     * 查询订单报告数据
     */
    List<SalesAmazonFbaTradeReport> serviceFindByListOrderReport(SalesAmazonFbaTradeReport report);
}

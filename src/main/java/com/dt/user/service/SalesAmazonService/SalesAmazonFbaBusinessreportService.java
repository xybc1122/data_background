package com.dt.user.service.SalesAmazonService;

import com.dt.user.model.SalesAmazonAd.SalesAmazonFbaBusinessreport;

import java.util.List;

public interface SalesAmazonFbaBusinessreportService {

    /**
     * 存业务数据
     *
     * @return
     */
    int AddSalesAmazonAdBusList(List<SalesAmazonFbaBusinessreport> hlList);

    /**
     * 查询业务报告数据
     *
     * @param rePort
     * @return
     */
    List<SalesAmazonFbaBusinessreport> serviceFindByListBus(SalesAmazonFbaBusinessreport rePort);

}

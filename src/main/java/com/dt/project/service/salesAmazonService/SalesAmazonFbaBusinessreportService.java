package com.dt.project.service.salesAmazonService;

import com.dt.project.model.salesAmazon.SalesAmazonFbaBusinessreport;

import java.util.List;

public interface SalesAmazonFbaBusinessreportService {

    /**
     * 存业务数据
     *
     * @return
     */
    int addSalesAmazonAdBusList(List<SalesAmazonFbaBusinessreport> hlList);

    /**
     * 查询业务报告数据
     *
     * @param rePort
     * @return
     */
    List<SalesAmazonFbaBusinessreport> serviceFindByListBus(SalesAmazonFbaBusinessreport rePort);

}

package com.dt.project.service.SalesAmazonService;

import com.dt.project.model.SalesAmazon.SalesAmazonFbaBusinessreport;

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

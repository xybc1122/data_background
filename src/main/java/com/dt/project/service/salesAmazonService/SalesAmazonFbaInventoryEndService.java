package com.dt.project.service.salesAmazonService;

import com.dt.project.model.salesAmazon.SalesAmazonFbaInventoryEnd;

import java.util.List;

public interface SalesAmazonFbaInventoryEndService {

    /**
     * 存入期末库存数据
     *
     * @return
     */
    int addSalesAmazonAdInventoryEndList(List<SalesAmazonFbaInventoryEnd> endList);

    /**
     * 查询期末库存数据
     */
    List<SalesAmazonFbaInventoryEnd> serviceFindByListEnd(SalesAmazonFbaInventoryEnd end);
}

package com.dt.project.service.salesAmazonService;

import com.dt.project.model.salesAmazon.SalesAmazonFbaReceivestock;

import java.util.List;

public interface SalesAmazonFbaReceivestockService {

    /**
     * 存入接收库存数据
     *
     * @return
     */
    int addSalesAmazonAdReceivestockList(List<SalesAmazonFbaReceivestock> receivesList);

    /**
     * 查询接收库存数据
     *
     * @param rec
     * @return
     */
    List<SalesAmazonFbaReceivestock> serviceFindByListRec(SalesAmazonFbaReceivestock rec);
}

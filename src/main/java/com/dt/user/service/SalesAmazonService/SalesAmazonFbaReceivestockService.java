package com.dt.user.service.SalesAmazonService;

import com.dt.user.model.SalesAmazon.SalesAmazonFbaReceivestock;

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

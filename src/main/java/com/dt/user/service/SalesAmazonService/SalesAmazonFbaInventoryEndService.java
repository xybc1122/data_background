package com.dt.user.service.SalesAmazonService;

import com.dt.user.model.SalesAmazon.SalesAmazonFbaInventoryEnd;

import java.util.List;

public interface SalesAmazonFbaInventoryEndService {

    /**
     * 存入接收库存数据
     *
     * @return
     */
    int addSalesAmazonAdInventoryEndList(List<SalesAmazonFbaInventoryEnd> endList);

    /**
     * 查询接收库存数据
     */
    List<SalesAmazonFbaInventoryEnd> serviceFindByListEnd(SalesAmazonFbaInventoryEnd end);
}

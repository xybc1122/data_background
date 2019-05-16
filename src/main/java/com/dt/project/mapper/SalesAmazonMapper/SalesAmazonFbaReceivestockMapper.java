package com.dt.project.mapper.SalesAmazonMapper;

import com.dt.project.model.SalesAmazon.SalesAmazonFbaReceivestock;
import com.dt.project.provider.SalesAmazonFbaReceivestockProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface SalesAmazonFbaReceivestockMapper {


    /**
     * 存入接收库存数据
     *
     * @return
     */
    @InsertProvider(type = SalesAmazonFbaReceivestockProvider.class, method = "addReceives")
    int addSalesAmazonAdReceiveStockList(@Param("receivesList") List<SalesAmazonFbaReceivestock> receivesList);

    /**
     * 查询接收库存数据
     */
    @SelectProvider(type = SalesAmazonFbaReceivestockProvider.class, method = "getRecInfo")
    List<SalesAmazonFbaReceivestock> findByListRec(SalesAmazonFbaReceivestock rec);
}

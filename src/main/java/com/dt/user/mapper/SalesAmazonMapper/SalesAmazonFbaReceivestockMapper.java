package com.dt.user.mapper.SalesAmazonMapper;

import com.dt.user.model.SalesAmazonAd.SalesAmazonFbaReceivestock;
import com.dt.user.provider.SalesAmazonFbaReceivestockProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SalesAmazonFbaReceivestockMapper {


    /**
     * 存入接收库存数据
     *
     * @return
     */
    @InsertProvider(type = SalesAmazonFbaReceivestockProvider.class, method = "addReceives")
    int AddSalesAmazonAdReceivestockList(@Param("receivesList") List<SalesAmazonFbaReceivestock> receivesList);


}
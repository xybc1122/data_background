package com.dt.user.mapper.SalesAmazonMapper;

import com.dt.user.model.SalesAmazon.SalesAmazonFbaInventoryEnd;
import com.dt.user.provider.SalesAmazonFbaInventoryEndProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface SalesAmazonFbaInventoryEndMapper {

    /**
     * 存入期末库存数据
     *
     * @return
     */
    @InsertProvider(type = SalesAmazonFbaInventoryEndProvider.class, method = "addEndList")
    int addSalesAmazonAdInventoryEndList(@Param("endList") List<SalesAmazonFbaInventoryEnd> endList);


    /**
     * 查询接收库存数据
     */
    @SelectProvider(type = SalesAmazonFbaInventoryEndProvider.class, method = "getEndInfo")
    List<SalesAmazonFbaInventoryEnd> findByListEnd(SalesAmazonFbaInventoryEnd end);

}

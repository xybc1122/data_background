package com.dt.project.mapper.SalesAmazonMapper;

import com.dt.project.model.SalesAmazon.SalesAmazonFbaInventoryEnd;
import com.dt.project.provider.SalesAmazonFbaInventoryEndProvider;
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
     * 查询期末库存数据
     */
    @SelectProvider(type = SalesAmazonFbaInventoryEndProvider.class, method = "getEndInfo")
    List<SalesAmazonFbaInventoryEnd> findByListEnd(SalesAmazonFbaInventoryEnd end);

}

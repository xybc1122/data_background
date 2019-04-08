package com.dt.user.mapper.SalesAmazonMapper;

import com.dt.user.model.SalesAmazonAd.SalesAmazonFbaBusinessreport;
import com.dt.user.provider.SalesAmazonFbaBusinessreporProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface SalesAmazonFbaBusinessreportMapper {


    /**
     * 存业务数据
     *
     * @return
     */
    @InsertProvider(type = SalesAmazonFbaBusinessreporProvider.class, method = "addAmazonAdBus")
    int AddSalesAmazonAdHlList(@Param("busList") List<SalesAmazonFbaBusinessreport> busList);


    /**
     * 查询业务报告 数据
     */
    @SelectProvider(type = SalesAmazonFbaBusinessreporProvider.class, method = "getBusInfo")
    List<SalesAmazonFbaBusinessreport> findByListBus(SalesAmazonFbaBusinessreport rePort);

}

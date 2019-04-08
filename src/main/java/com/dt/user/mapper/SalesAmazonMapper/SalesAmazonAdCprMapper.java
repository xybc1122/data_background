package com.dt.user.mapper.SalesAmazonMapper;

import com.dt.user.model.SalesAmazonAd.SalesAmazonAdCpr;
import com.dt.user.provider.SalesAmazonAdCprProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface SalesAmazonAdCprMapper {
    /**
     * 存入广告Cpr数据
     *
     * @param cprList
     * @return
     */
    @InsertProvider(type = SalesAmazonAdCprProvider.class, method = "addAmazonAdCpr")
    int AddSalesAmazonAdCprList(@Param("cprList") List<SalesAmazonAdCpr> cprList);

    /**
     * 查询cpr 数据
     */
    @SelectProvider(type = SalesAmazonAdCprProvider.class, method = "getCprInfo")
    List<SalesAmazonAdCpr> findByListCpr(SalesAmazonAdCpr cpr);


}

package com.dt.project.mapper.SalesAmazonMapper;

import com.dt.project.model.SalesAmazon.SalesAmazonAdCpr;
import com.dt.project.provider.SalesAmazonAdCprProvider;
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
    int setSalesAmazonAdCprList(@Param("cprList") List<SalesAmazonAdCpr> cprList);

    /**
     * 查询cpr 数据
     */
    @SelectProvider(type = SalesAmazonAdCprProvider.class, method = "getCprInfo")
    List<SalesAmazonAdCpr> findByListCpr(SalesAmazonAdCpr cpr);


}

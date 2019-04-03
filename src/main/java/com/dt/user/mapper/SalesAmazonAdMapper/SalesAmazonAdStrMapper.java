package com.dt.user.mapper.SalesAmazonAdMapper;
import com.dt.user.model.SalesAmazonAd.SalesAmazonAdStr;
import com.dt.user.provider.SalesAmazonAdStrProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface SalesAmazonAdStrMapper {
    /**
     * 存入广告Str数据
     *
     * @return
     */
    @InsertProvider(type = SalesAmazonAdStrProvider.class, method = "addAmazonAdStr")
    int AddSalesAmazonAdStrList(@Param("strList") List<SalesAmazonAdStr> strList);


    /**
     * 查询str 数据
     */
    @SelectProvider(type = SalesAmazonAdStrProvider.class, method = "getStrInfo")
    List<SalesAmazonAdStr> findByListStr(SalesAmazonAdStr str);
}

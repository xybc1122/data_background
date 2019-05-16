package com.dt.project.mapper.SalesAmazonMapper;

import com.dt.project.model.SalesAmazon.SalesAmazonAdOar;
import com.dt.project.provider.SalesAmazonAdOarProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface SalesAmazonAdOarMapper {
    /**
     * 存入广告Oar数据
     *
     * @return
     */
    @InsertProvider(type = SalesAmazonAdOarProvider.class, method = "addAmazonAdOar")
    int setSalesAmazonAdOarList(@Param("oarList") List<SalesAmazonAdOar> oarList);

    /**
     * 查询oar 数据
     */
    @SelectProvider(type = SalesAmazonAdOarProvider.class, method = "getOarInfo")
    List<SalesAmazonAdOar> findByListOar(SalesAmazonAdOar oar);
}

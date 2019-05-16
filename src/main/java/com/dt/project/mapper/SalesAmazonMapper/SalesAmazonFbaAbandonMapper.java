package com.dt.project.mapper.SalesAmazonMapper;

import com.dt.project.model.SalesAmazon.SalesAmazonFbaAbandon;
import com.dt.project.provider.SalesAmazonFbaAbandonProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName SalesAmazonFbaAbandonMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/9 13:15
 **/
public interface SalesAmazonFbaAbandonMapper {


    /**
     * 查询FBA遗弃
     */
    @SelectProvider(type = SalesAmazonFbaAbandonProvider.class, method = "getAbandonInfo")
    List<SalesAmazonFbaAbandon> findByListAbandon(SalesAmazonFbaAbandon abandon);


    /**
     * 存入广告FBA遗弃数据
     *
     * @return
     */
    @InsertProvider(type = SalesAmazonFbaAbandonProvider.class, method = "setAbandon")
    int setSalesAmazonAbandonList(@Param("abandonList") List<SalesAmazonFbaAbandon> abandonList);


}

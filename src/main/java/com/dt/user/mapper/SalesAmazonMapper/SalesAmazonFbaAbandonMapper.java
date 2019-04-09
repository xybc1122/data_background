package com.dt.user.mapper.SalesAmazonMapper;

import com.dt.user.model.SalesAmazon.SalesAmazonFbaAbandon;
import com.dt.user.provider.SalesAmazonFbaAbandonProvider;
import org.apache.ibatis.annotations.SelectProvider;

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


}

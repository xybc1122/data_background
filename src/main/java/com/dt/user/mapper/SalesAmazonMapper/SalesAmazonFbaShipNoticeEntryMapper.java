package com.dt.user.mapper.SalesAmazonMapper;

import com.dt.user.model.SalesAmazon.SalesAmazonFbaShipNoticeEntry;
import com.dt.user.provider.SalesAmazonFbaShipNoticeEntryProvider;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @ClassName SalesAmazonFbaShipNoticeEntryMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/9 13:39
 **/
public interface SalesAmazonFbaShipNoticeEntryMapper {


    /**
     * 查询出货通知单
     */
    @SelectProvider(type = SalesAmazonFbaShipNoticeEntryProvider.class, method = "getEntryInfo")
    List<SalesAmazonFbaShipNoticeEntry> findByListAbandon(SalesAmazonFbaShipNoticeEntry entry);


}

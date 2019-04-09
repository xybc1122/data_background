package com.dt.user.service.SalesAmazonService;

import com.dt.user.model.SalesAmazon.SalesAmazonFbaShipNoticeEntry;

import java.util.List;

/**
 * @ClassName SalesAmazonFbaShipNoticeEntryService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/9 13:53
 **/
public interface SalesAmazonFbaShipNoticeEntryService {


    /**
     * 查询出货通知单
     */
    List<SalesAmazonFbaShipNoticeEntry> serviceFindByListAbandon(SalesAmazonFbaShipNoticeEntry entry);

}

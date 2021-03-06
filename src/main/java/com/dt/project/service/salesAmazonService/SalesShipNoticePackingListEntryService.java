package com.dt.project.service.salesAmazonService;

import com.dt.project.model.salesAmazon.SalesShipNoticePackingListEntry;

import java.util.List;

/**
 * @ClassName SalesShipNoticePackingListEntryService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/13 15:32
 **/
public interface SalesShipNoticePackingListEntryService {

    /**
     * 查询 装箱单-表体  用于一对多
     *
     * @param
     * @return
     */
    List<SalesShipNoticePackingListEntry> serviceSelectPackingListEntry(SalesShipNoticePackingListEntry pLEntry);

}

package com.dt.user.service;

import com.dt.user.config.ResponseBase;
import com.dt.user.model.SalesAmazon.SalesShipNoticePackingListEntry;

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
    ResponseBase serviceSelectPackingListEntry(SalesShipNoticePackingListEntry pLEntry);

}

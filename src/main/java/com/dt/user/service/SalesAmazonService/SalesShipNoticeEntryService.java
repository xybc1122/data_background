package com.dt.user.service.SalesAmazonService;

import com.dt.user.config.ResponseBase;
import com.dt.user.model.SalesAmazon.SalesShipNoticeEntry;

import java.util.List;


/**
 * @ClassName SalesShipNoticeEntryService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/13 14:51
 **/
public interface SalesShipNoticeEntryService {


    /**
     * 查询发货通知表体    用于一对多查询
     *
     * @return
     */
    List<SalesShipNoticeEntry> serviceSelectByNoticeEntry(SalesShipNoticeEntry shipNoticeEntry);


}

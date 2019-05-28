package com.dt.project.service.salesAmazonService;

import com.dt.project.model.salesAmazon.SalesShipNoticeEntry;

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


    /**
     * 查询是否有重复的
     *
     * @return
     */
    boolean serviceIsItRedundant(Long shipNoticeId, Long skuId);


}

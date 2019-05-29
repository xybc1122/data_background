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
     * 批量插入出库通知单子表数据
     *
     * @param noticeEntryList
     * @return
     */
    int insertShipNoticeEntry(List<SalesShipNoticeEntry> noticeEntryList);

    /**
     * 用父ID查询子ID下面是否还有节点
     *
     * @return
     */
    List<Integer> serviceSelIsNull(List snIds);

}

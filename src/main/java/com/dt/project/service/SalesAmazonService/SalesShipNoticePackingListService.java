package com.dt.project.service.salesAmazonService;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.salesAmazon.SalesShipNoticePackingList;

/**
 * @ClassName SalesShipNoticePackingListService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/29 9:25
 **/
public interface SalesShipNoticePackingListService {



    /**
     * 查询出货装箱单
     *
     * @param record
     * @return
     */
    ResponseBase serviceSelectNoticePackingList(SalesShipNoticePackingList record);
}

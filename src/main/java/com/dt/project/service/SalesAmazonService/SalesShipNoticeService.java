package com.dt.project.service.SalesAmazonService;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.SalesAmazon.SalesShipNotice;

/**
 * @ClassName SalesShipNoticeService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/10 17:04
 **/
public interface SalesShipNoticeService {


    /**
     * 查询发货通知单
     *
     * @param notice
     * @return
     */

    ResponseBase selectSelectByNotice(SalesShipNotice notice);
}

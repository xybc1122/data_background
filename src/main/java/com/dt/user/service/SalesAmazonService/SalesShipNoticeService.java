package com.dt.user.service.SalesAmazonService;

import com.dt.user.config.ResponseBase;
import com.dt.user.model.SalesAmazon.SalesShipNotice;

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

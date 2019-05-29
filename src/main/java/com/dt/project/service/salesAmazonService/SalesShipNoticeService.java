package com.dt.project.service.salesAmazonService;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.salesAmazon.SalesShipNotice;

import java.util.List;
import java.util.Map;

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

    /**
     * 新增出货通知单
     *
     * @return
     */
    ResponseBase saveNotice(Map<String, Object> noMap);

    /**
     * 批量删除出货通知单 /只做了字段更新
     *
     * @return
     */
    ResponseBase serviceDeleteByShipNoticesAndNoticeEntry(Map<String, List<Integer>> objectMap);
}

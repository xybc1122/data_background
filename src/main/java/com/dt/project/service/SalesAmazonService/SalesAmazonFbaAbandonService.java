package com.dt.project.service.SalesAmazonService;

import com.dt.project.model.SalesAmazon.SalesAmazonFbaAbandon;

import java.util.List;

/**
 * @ClassName SalesAmazonFbaAbandonService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/9 13:25
 **/
public interface SalesAmazonFbaAbandonService {


    /**
     * 存入广告FBA遗弃数据
     *
     * @return
     */
    int serviceSetSalesAmazonAbandonList(List<SalesAmazonFbaAbandon> abandonList);


    /**
     * 查询FBA遗弃
     */
    List<SalesAmazonFbaAbandon> serviceFindByListAbandon(SalesAmazonFbaAbandon abandon);


}

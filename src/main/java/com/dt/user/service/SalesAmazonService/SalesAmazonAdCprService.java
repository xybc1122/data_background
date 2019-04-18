package com.dt.user.service.SalesAmazonService;

import com.dt.user.model.SalesAmazon.SalesAmazonAdCpr;

import java.util.List;

public interface SalesAmazonAdCprService {


    /**
     * 存入广告数据
     *
     * @param cprList
     * @return
     */
    int saveSalesAmazonAdCprList(List<SalesAmazonAdCpr> cprList);

    /**
     * 查询cpr数据
     *
     * @param cpr
     * @return
     */
    List<SalesAmazonAdCpr> serviceFindByListCpr(SalesAmazonAdCpr cpr);
}

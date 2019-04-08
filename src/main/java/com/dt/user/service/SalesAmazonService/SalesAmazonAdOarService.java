package com.dt.user.service.SalesAmazonService;

import com.dt.user.model.SalesAmazonAd.SalesAmazonAdOar;

import java.util.List;

public interface SalesAmazonAdOarService {

    /**
     * 存入广告Oar数据
     *
     * @return
     */
    int AddSalesAmazonAdOarList(List<SalesAmazonAdOar> oarList);

    /**
     * 查询oar 数据
     */
    List<SalesAmazonAdOar> serviceFindByListOar(SalesAmazonAdOar oar);

}
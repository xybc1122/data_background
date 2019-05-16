package com.dt.project.service.SalesAmazonService;

import com.dt.project.model.SalesAmazon.SalesAmazonAdOar;

import java.util.List;

public interface SalesAmazonAdOarService {

    /**
     * 存入广告Oar数据
     *
     * @return
     */
    int saveSalesAmazonAdOarList(List<SalesAmazonAdOar> oarList);

    /**
     * 查询oar 数据
     */
    List<SalesAmazonAdOar> serviceFindByListOar(SalesAmazonAdOar oar);

}

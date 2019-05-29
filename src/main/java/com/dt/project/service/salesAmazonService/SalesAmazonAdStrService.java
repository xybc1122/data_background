package com.dt.project.service.salesAmazonService;

import com.dt.project.model.salesAmazon.SalesAmazonAdStr;

import java.util.List;

public interface SalesAmazonAdStrService {
    /**
     * 存入广告数据
     *
     * @param strList
     * @return
     */
    int saveSalesAmazonAdStrList(List<SalesAmazonAdStr> strList);

    /**
     * 查询str 数据
     */
    List<SalesAmazonAdStr> serviceFindByListStr(SalesAmazonAdStr str);
}

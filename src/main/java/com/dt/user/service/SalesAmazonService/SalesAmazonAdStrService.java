package com.dt.user.service.SalesAmazonService;

import com.dt.user.model.SalesAmazon.SalesAmazonAdStr;

import java.util.List;

public interface SalesAmazonAdStrService {
    /**
     * 存入广告数据
     *
     * @param strList
     * @return
     */
    int AddSalesAmazonAdStrList(List<SalesAmazonAdStr> strList);

    /**
     * 查询str 数据
     */
    List<SalesAmazonAdStr> serviceFindByListStr(SalesAmazonAdStr str);
}

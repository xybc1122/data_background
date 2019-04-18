package com.dt.user.service.SalesAmazonService;

import com.dt.user.model.SalesAmazon.SalesAmazonAdHl;

import java.util.List;

public interface SalesAmazonAHlService {

    /**
     * 存入广告Hl数据
     *
     * @return
     */
    int saveSalesAmazonAdHlList(List<SalesAmazonAdHl> hlList);

    /**
     * 查询HL数据
     *
     * @param hl
     * @return
     */
    List<SalesAmazonAdHl> serviceFindByListHl(SalesAmazonAdHl hl);
}

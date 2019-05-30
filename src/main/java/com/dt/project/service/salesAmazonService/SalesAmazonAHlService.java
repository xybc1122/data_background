package com.dt.project.service.salesAmazonService;

import com.dt.project.model.salesAmazon.SalesAmazonAdHl;

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

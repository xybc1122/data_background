package com.dt.user.service.BasePublicService;

public interface BasicSalesAmazonSkuService {


    /**
     * 通过店铺ID  站点ID  skuName 查找 skuId
     * @param sId
     * @param siteId
     * @param skuName
     * @return
     */
    Long selSkuId(Integer sId, Integer siteId, String skuName);


    /**
     * 通过店铺ID  站点ID  sAsin 查找 skuId
     * @param sId
     * @param siteId
     * @return
     */
    Long getAsinSkuId(Integer sId, Integer siteId, String sAsin);
}

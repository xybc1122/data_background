package com.dt.user.service.BasePublicService;

import com.dt.user.dto.SkuDto;
import com.dt.user.model.BasePublicModel.BasicPublicSku;

import java.util.List;

/**
 * @ClassName BasicPublicSkuService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 11:16
 **/
public interface BasicPublicSkuService {
    /**
     * 查询SKU信息
     *
     * @param skuDto
     * @return
     */
    List<SkuDto> serviceFindByListSku(SkuDto skuDto);


    /**
     * 通过店铺ID  站点ID  skuName 查找 skuId
     *
     * @param sId
     * @param siteId
     * @param skuName
     * @return
     */
    Long selSkuId(Integer sId, Integer siteId, String skuName);


    /**
     * 通过店铺ID  站点ID  sAsin 查找 skuId
     *
     * @param sId
     * @param siteId
     * @return
     */
    Long getAsinSkuId(Integer sId, Integer siteId, String sAsin);


    /**
     * 通过站点 店铺  id  kuName 查找对应的sku
     *
     * @param sId
     * @param siteId
     * @return
     */
    List<BasicPublicSku> serviceGetListKu(Integer sId, Integer siteId,String kuName);


    /**
     * 查询所有sku
     *
     * @return
     */
    List<BasicPublicSku> serviceSelAllSku();
}

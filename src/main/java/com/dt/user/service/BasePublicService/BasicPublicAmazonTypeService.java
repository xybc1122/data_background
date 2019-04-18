package com.dt.user.service.BasePublicService;

/**
 * @ClassName BasicPublicAmazonTypeService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/18 11:15
 **/
public interface BasicPublicAmazonTypeService {

    /**
     * 查询type中文名称
     * @param siteId
     * @param type
     * @return
     */
    String getTypeName(Integer siteId, String type);
}

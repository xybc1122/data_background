package com.dt.project.service.basePublicService;

import com.dt.project.model.basePublic.BasicSalesAmazonDescription;

import java.util.List;

/**
 * @ClassName BasicSalesAmazonDescriptionService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 15:52
 **/
public interface BasicSalesAmazonDescriptionService {

    /**
     * 查询获得亚马逊描述
     */
    List<BasicSalesAmazonDescription> serviceGetDescription(BasicSalesAmazonDescription description);
}

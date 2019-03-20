package com.dt.user.service.BasePublicService;

import com.dt.user.model.BasePublicModel.BasicSalesAmazonType;

import java.util.List;

/**
 * @ClassName BasicSalesAmazonTypeService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/20 10:43
 **/
public interface BasicSalesAmazonTypeService {


    /**
     * 查询亚马逊-订单类型'
     */
    List<BasicSalesAmazonType> serviceFindByListAmazonType(BasicSalesAmazonType amazonType);
}

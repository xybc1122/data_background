package com.dt.project.service.BasePublicService;

import com.dt.project.model.BasePublicModel.BasicSalesAmazonPaymentType;

import java.util.List;

/**
 * @ClassName BasicSalesAmazonPaymentTypeService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 16:10
 **/
public interface BasicSalesAmazonPaymentTypeService {

    /**
     * 付款类型
     *
     * @return
     */
    List<BasicSalesAmazonPaymentType> serviceFindByListPayType();
}

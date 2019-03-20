package com.dt.user.service.BasePublicService;

import com.dt.user.model.BasePublicModel.BasicSalesDeliveryType;

import java.util.List;

/**
 * @ClassName BasicSalesDeliveryTypeService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/20 13:25
 **/
public interface BasicSalesDeliveryTypeService {

    /**
     * 查询发货方式
     *
     * @return
     */
    List<BasicSalesDeliveryType> serviceFindByListDeliveryType();
}

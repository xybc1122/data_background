package com.dt.project.service.basePublicService;

import com.dt.project.model.basePublic.BasicSalesDeliveryType;

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

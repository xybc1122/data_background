package com.dt.user.service.BasePublicService;

import com.dt.user.model.BasePublicModel.BasicPurchasePrice;

import java.util.List;

/**
 * @ClassName BasicPurchasePriceService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 14:31
 **/
public interface BasicPurchasePriceService {

    /**
     * 查询采购价格
     *
     * @return
     */
    List<BasicPurchasePrice> serviceFindByListPrice(BasicPurchasePrice price);
}

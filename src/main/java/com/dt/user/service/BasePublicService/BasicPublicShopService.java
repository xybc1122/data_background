package com.dt.user.service.BasePublicService;

import com.dt.user.dto.ShopDto;
import com.dt.user.model.BasePublicModel.BasicPublicShop;

import java.util.List;

public interface BasicPublicShopService {


    /**
     * 查询店铺所有相关信息
     * @return
     */
    List<ShopDto> findByListShop();

    /**
     * 查询店铺名字
     * @return
     */
    List<BasicPublicShop> getByListShopName();


    /**
     * 查询店铺ID
     *
     * @return
     */
    Integer getSId(String shopName);
}

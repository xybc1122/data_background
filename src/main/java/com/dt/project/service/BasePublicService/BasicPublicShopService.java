package com.dt.project.service.BasePublicService;

import com.dt.project.dto.ShopDto;
import com.dt.project.model.BasePublicModel.BasicPublicShop;

import java.util.List;

public interface BasicPublicShopService {


    /**
     * 查询店铺所有相关信息
     *
     * @return
     */
    List<ShopDto> findByListShop();

    /**
     * 通过角色id 查询店铺名字
     *
     * @return
     */
    List<BasicPublicShop> getByListShopName(String rId);


    /**
     * 查询店铺ID
     *
     * @return
     */
    Integer getSId(String shopName);
}

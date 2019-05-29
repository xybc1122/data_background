package com.dt.project.service.basePublicService;

import com.dt.project.model.dto.ShopDto;
import com.dt.project.model.basePublicModel.BasicPublicShop;

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

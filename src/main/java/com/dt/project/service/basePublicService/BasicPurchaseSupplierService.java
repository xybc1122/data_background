package com.dt.project.service.basePublicService;

import com.dt.project.model.basePublic.BasicPurchaseSupplier;

import java.util.List;

/**
 * @ClassName BasicPurchaseSupplierService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/3 9:07
 **/
public interface BasicPurchaseSupplierService {


    /**
     * 查询供应商信息  id name
     *
     * @return
     */
    List<BasicPurchaseSupplier> selectByPurchaseSupplier();
}

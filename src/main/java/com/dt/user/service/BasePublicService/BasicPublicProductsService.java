package com.dt.user.service.BasePublicService;

import com.dt.user.config.ResponseBase;
import com.dt.user.model.BasePublicModel.BasicPublicProducts;
import com.dt.user.model.Parent.ParentTree;

import java.util.List;
import java.util.Map;

public interface BasicPublicProductsService {


    /**
     * 查询类目信息
     *
     * @return
     */
    List<ParentTree> serviceFindByProductsInfo();


    /**
     * 修改产品类目信息
     */
    ResponseBase serviceUpProducts(BasicPublicProducts products);

    /**
     * 删除产品类目信息
     *
     * @return
     */
    ResponseBase serviceDelProducts(Map<String, String> delMap);

    /**
     * 新增产品类目信息
     */
    ResponseBase serviceSaveProducts(BasicPublicProducts products);
}

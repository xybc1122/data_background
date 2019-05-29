package com.dt.project.service.basePublicService;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.basePublicModel.BasicPublicProducts;
import com.dt.project.model.parent.ParentTree;

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

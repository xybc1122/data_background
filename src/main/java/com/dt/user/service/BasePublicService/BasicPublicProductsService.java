package com.dt.user.service.BasePublicService;

import com.dt.user.model.ParentTree;

import java.util.List;

public interface BasicPublicProductsService{


    /**
     * 查询类目信息
     * @return
     */
    List<ParentTree> serviceFindByProductsInfo();
}

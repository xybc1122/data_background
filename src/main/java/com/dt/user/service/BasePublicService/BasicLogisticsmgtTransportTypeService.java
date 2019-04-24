package com.dt.user.service.BasePublicService;

import com.dt.user.model.Parent.ParentTree;

import java.util.List;

public interface BasicLogisticsmgtTransportTypeService {

    /**
     * 查询运输类型
     */
    List<ParentTree> serviceFindByTypeInfo();

}

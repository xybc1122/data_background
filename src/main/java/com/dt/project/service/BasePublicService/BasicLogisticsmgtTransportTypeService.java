package com.dt.project.service.basePublicService;

import com.dt.project.model.parent.ParentTree;

import java.util.List;

public interface BasicLogisticsmgtTransportTypeService {

    /**
     * 查询运输类型
     */
    List<ParentTree> serviceFindByTypeInfo();

}

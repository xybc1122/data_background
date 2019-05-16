package com.dt.project.service.BasePublicService;

import com.dt.project.model.Parent.ParentTree;

import java.util.List;

public interface BasicLogisticsmgtTransportTypeService {

    /**
     * 查询运输类型
     */
    List<ParentTree> serviceFindByTypeInfo();

}

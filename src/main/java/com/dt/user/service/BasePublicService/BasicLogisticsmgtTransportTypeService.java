package com.dt.user.service.BasePublicService;

import com.dt.user.model.BasePublicModel.BasicLogisticsmgtTransportType;

import java.util.List;

public interface BasicLogisticsmgtTransportTypeService {

    /**
     * 查询运输类型
     */
    List<BasicLogisticsmgtTransportType> serviceFindByTypeInfo();

}

package com.dt.project.service.basePublicService;

import com.dt.project.model.basePublic.BasicLogisticsmgtTransportProperty;

import java.util.List;

public interface BasicLogisticsmgtTransportPropertyService {


    /**
     * 查询运输性质
     * @return
     */
    List<BasicLogisticsmgtTransportProperty> findByListProperty();
}

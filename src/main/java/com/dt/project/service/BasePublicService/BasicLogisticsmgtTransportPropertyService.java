package com.dt.project.service.BasePublicService;

import com.dt.project.model.BasePublicModel.BasicLogisticsmgtTransportProperty;

import java.util.List;

public interface BasicLogisticsmgtTransportPropertyService {


    /**
     * 查询运输性质
     * @return
     */
    List<BasicLogisticsmgtTransportProperty> findByListProperty();
}

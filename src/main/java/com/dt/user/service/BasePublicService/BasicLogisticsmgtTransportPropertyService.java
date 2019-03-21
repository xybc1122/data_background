package com.dt.user.service.BasePublicService;

import com.dt.user.model.BasePublicModel.BasicLogisticsmgtTransportProperty;

import java.util.List;

public interface BasicLogisticsmgtTransportPropertyService {


    /**
     * 查询运输性质
     * @return
     */
    List<BasicLogisticsmgtTransportProperty> findByListProperty();
}

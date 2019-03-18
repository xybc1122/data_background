package com.dt.user.service.BasePublicService;

import com.dt.user.model.BasePublicModel.BasicLogisticsmgtTransportAbnormalType;

import java.util.List;

public interface BasicLogisticsmgtTransportAbnormalTypeService {


    /**
     * 异常类型
     *
     * @return
     */

    List<BasicLogisticsmgtTransportAbnormalType> serviceFindByListAbnormalType();
}

package com.dt.user.service.BasePublicService;

import com.dt.user.model.BasePublicModel.BasicLogisticsmgtTransportCompany;

import java.util.List;

public interface BasicLogisticsmgtTransportCompanyService {

    /**
     * 查询货运公司
     *
     * @return
     */
    List<BasicLogisticsmgtTransportCompany> serviceFindByListFreight(BasicLogisticsmgtTransportCompany company);
}

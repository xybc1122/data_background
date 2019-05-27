package com.dt.project.service.basePublicService;

import com.dt.project.model.basePublicModel.BasicLogisticsmgtTransportCompany;

import java.util.List;

public interface BasicLogisticsmgtTransportCompanyService {

    /**
     * 查询货运公司
     *
     * @return
     */
    List<BasicLogisticsmgtTransportCompany> serviceFindByListFreight(BasicLogisticsmgtTransportCompany company);
}

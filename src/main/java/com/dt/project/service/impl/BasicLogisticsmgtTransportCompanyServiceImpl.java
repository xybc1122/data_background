package com.dt.project.service.impl;

import com.dt.project.mapper.BasePublicMapper.BasicLogisticsmgtTransportCompanyMapper;
import com.dt.project.model.BasePublicModel.BasicLogisticsmgtTransportCompany;
import com.dt.project.service.BasePublicService.BasicLogisticsmgtTransportCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicLogisticsmgtTransportCompanyServiceImpl implements BasicLogisticsmgtTransportCompanyService {
    @Autowired
    private BasicLogisticsmgtTransportCompanyMapper companyMapper;

    @Override
    public List<BasicLogisticsmgtTransportCompany> serviceFindByListFreight(BasicLogisticsmgtTransportCompany company) {
        return companyMapper.findByListFreight(company);
    }
}

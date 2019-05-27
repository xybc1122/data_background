package com.dt.project.service.impl;

import com.dt.project.mapper.basePublicMapper.BasicLogisticsmgtTransportCompanyMapper;
import com.dt.project.model.basePublicModel.BasicLogisticsmgtTransportCompany;
import com.dt.project.service.basePublicService.BasicLogisticsmgtTransportCompanyService;
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

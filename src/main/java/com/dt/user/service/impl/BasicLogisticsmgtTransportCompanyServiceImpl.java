package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicLogisticsmgtTransportCompanyMapper;
import com.dt.user.model.BasePublicModel.BasicLogisticsmgtTransportCompany;
import com.dt.user.service.BasePublicService.BasicLogisticsmgtTransportCompanyService;
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

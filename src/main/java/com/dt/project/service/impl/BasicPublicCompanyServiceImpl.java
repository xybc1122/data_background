package com.dt.project.service.impl;


import com.dt.project.config.ResponseBase;
import com.dt.project.model.dto.CompanyDto;
import com.dt.project.mapper.basePublicMapper.BasicPublicCompanyMapper;
import com.dt.project.model.basePublic.BasicPublicCompany;
import com.dt.project.service.basePublicService.BasicPublicCompanyService;
import com.dt.project.service.SystemLogStatusService;
import com.dt.project.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class BasicPublicCompanyServiceImpl implements BasicPublicCompanyService {
    @Autowired
    private BasicPublicCompanyMapper companyMapper;
    @Autowired
    private SystemLogStatusService logStatusService;


    @Override
    public List<CompanyDto> findByListCompany() {
        return companyMapper.findByListCompany();
    }

    @Override
    @Transactional
    public ResponseBase serviceUpCompany(BasicPublicCompany company) {
               int result = companyMapper.upCompany(company);
        //通用更新消息
        return logStatusService.msgCodeUp(result, company.getSystemLogStatus(), company.getStatusId());
    }

    @Override
    @Transactional
    public ResponseBase serviceDelCompany(Map<String, String> companyMap) {
        int result = companyMapper.delCompany(companyMap.get("thisIds"));
        return logStatusService.msgCodeDel(result, companyMap);

    }

    @Override
    public ResponseBase serviceSaveCompany(BasicPublicCompany company) {
        //新增公司数据
        int result = companyMapper.saveCompany((BasicPublicCompany) logStatusService.setObjStatusId(company));
        return JsonUtils.saveMsg(result);
    }
}

package com.dt.user.service.impl;


import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.dto.CompanyDto;
import com.dt.user.mapper.BasePublicMapper.BasicPublicCompanyMapper;
import com.dt.user.model.BasePublicModel.BasicPublicCompany;
import com.dt.user.service.BasePublicService.BasicPublicCompanyService;
import com.dt.user.service.SystemLogStatusService;
import com.dt.user.utils.JsonUtils;
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
        if (company.getStatusId() == null) return JsonData.setResultSuccess("状态为空,更新失败");
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

package com.dt.user.service.impl;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.dto.CompanyDto;
import com.dt.user.mapper.BasePublicMapper.BasicPublicCompanyMapper;
import com.dt.user.model.BasePublicModel.BasicPublicCompany;
import com.dt.user.model.SystemLogStatus;
import com.dt.user.service.BasePublicService.BasicPublicCompanyService;
import com.dt.user.service.GeneralQueryService;
import com.dt.user.service.SystemLogStatusService;
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
    @Autowired
    private GeneralQueryService queryService;

    @Override
    public List<CompanyDto> findByListCompany() {
        return companyMapper.findByListCompany();
    }

    @Override
    @Transactional
    public ResponseBase serviceUpCompany(BasicPublicCompany company) {
        int result;
        if (company.getStatusId() == null) {
            result = companyMapper.upCompany((BasicPublicCompany) logStatusService.setObjStatusId(company));
        } else {
            result = companyMapper.upCompany(company);
        }
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
        if (result != 0) {
            return JsonData.setResultSuccess("新增成功");
        }
        return JsonData.setResultError("新增失败");
    }
}

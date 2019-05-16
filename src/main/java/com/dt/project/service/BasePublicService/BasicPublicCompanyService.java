package com.dt.project.service.BasePublicService;

import com.dt.project.config.ResponseBase;
import com.dt.project.dto.CompanyDto;
import com.dt.project.model.BasePublicModel.BasicPublicCompany;

import java.util.List;
import java.util.Map;

public interface BasicPublicCompanyService {


    /**
     * 查询公司所有相关信息
     * @return
     */
    List<CompanyDto> findByListCompany();



    /**
     * 修改公司信息
     */
    ResponseBase serviceUpCompany(BasicPublicCompany company);

    /**
     * 删除公司信息 //更新
     */
    ResponseBase serviceDelCompany(Map<String, String> companyMap);

    /**
     * 新增公司信息
     */
    ResponseBase serviceSaveCompany(BasicPublicCompany company);
}

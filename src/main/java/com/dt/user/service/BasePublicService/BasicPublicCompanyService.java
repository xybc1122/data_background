package com.dt.user.service.BasePublicService;

import com.dt.user.config.ResponseBase;
import com.dt.user.dto.CompanyDto;
import com.dt.user.model.BasePublicModel.BasicPublicCompany;

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

package com.dt.user.controller.BasePublicController;

import com.dt.user.config.ResponseBase;
import com.dt.user.dto.CompanyDto;
import com.dt.user.service.BasePublicService.BasicPublicCompanyService;
import com.dt.user.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
public class BasicPublicCompanyController {

    @Autowired
    private BasicPublicCompanyService basicPublicCompanyService;

    /**
     * 获得公司的信息
     *
     * @return
     */
    @PostMapping("/findByListCompany")
    public ResponseBase findByListCompany(@RequestBody CompanyDto companyDto) {
        PageInfoUtils.setPage(companyDto.getPageSize(), companyDto.getCurrentPage());
        List<CompanyDto> basicPublicCompanyList = basicPublicCompanyService.findByListCompany();
        return PageInfoUtils.returnPage(basicPublicCompanyList, companyDto.getCurrentPage());
    }
}

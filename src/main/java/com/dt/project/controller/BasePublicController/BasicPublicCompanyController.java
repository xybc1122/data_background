package com.dt.project.controller.basePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.dto.CompanyDto;
import com.dt.project.model.basePublic.BasicPublicCompany;
import com.dt.project.service.basePublicService.BasicPublicCompanyService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/company")
public class BasicPublicCompanyController {

    @Autowired
    private BasicPublicCompanyService companyService;

    /**
     * 获得公司的信息
     *
     * @return
     */
    @PostMapping("/findByListCompany")
    public ResponseBase findByListCompany(@RequestBody CompanyDto companyDto) {
        PageInfoUtils.setPage(companyDto.getPageSize(), companyDto.getCurrentPage());
        return PageInfoUtils.returnPage(companyService.findByListCompany());
    }

    @PostMapping("/upCompany")
    public ResponseBase upCompanyInfo(@RequestBody BasicPublicCompany company) {
        return companyService.serviceUpCompany(company);
    }

    @PostMapping("/delCompany")
    public ResponseBase delWarInfo(@RequestBody Map<String, String> companyMap) {
        return companyService.serviceDelCompany(companyMap);
    }

    @PostMapping("/saveCompany")
    public ResponseBase saveWarInfo(@RequestBody BasicPublicCompany company) {
        return companyService.serviceSaveCompany(company);
    }
}

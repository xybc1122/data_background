package com.dt.user.controller.BasePublicController;

import com.dt.user.config.ResponseBase;
import com.dt.user.dto.CompanyDto;
import com.dt.user.model.BasePublicModel.BasicPublicCompany;
import com.dt.user.service.BasePublicService.BasicPublicCompanyService;
import com.dt.user.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        List<CompanyDto> basicPublicCompanyList = companyService.findByListCompany();
        return PageInfoUtils.returnPage(basicPublicCompanyList, companyDto.getCurrentPage());
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

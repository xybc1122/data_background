package com.dt.project.controller.basePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.dto.TaxrateDto;
import com.dt.project.service.basePublicService.BasicPublicDutiesTaxrateService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BasicPublicDutiesTaxrateController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/13 15:02
 **/
@RestController
@RequestMapping("/api/v1/tax")
public class BasicPublicDutiesTaxrateController {
    @Autowired
    private BasicPublicDutiesTaxrateService taxrateService;

    @PostMapping("/findByListTax")
    public ResponseBase findByListTax(@RequestBody TaxrateDto taxrateDto) {
        PageInfoUtils.setPage(taxrateDto.getPageSize(), taxrateDto.getCurrentPage());
        return PageInfoUtils.returnPage(taxrateService.findByListTaxrate(taxrateDto));

    }
}

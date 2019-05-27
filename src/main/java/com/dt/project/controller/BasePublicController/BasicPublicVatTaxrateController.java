package com.dt.project.controller.basePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.basePublicModel.BasicPublicVatTaxrate;
import com.dt.project.service.basePublicService.BasicPublicVatTaxrateService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName BasicPublicSurTaxrateController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 9:15
 **/
@RestController
@RequestMapping("/api/v1/vat")
public class BasicPublicVatTaxrateController {

    @Autowired
    private BasicPublicVatTaxrateService sTRService;


    @PostMapping("/findByListVat")
    public ResponseBase findByListVA(@RequestBody BasicPublicVatTaxrate taxRate) {
        PageInfoUtils.setPage(taxRate.getPageSize(), taxRate.getCurrentPage());
        return PageInfoUtils.returnPage(sTRService.serviceFindByListSurTaxrate(taxRate), taxRate.getCurrentPage());
    }
}

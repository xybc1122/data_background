package com.dt.project.controller.BasePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.BasePublicModel.BasicPublicVatTaxrate;
import com.dt.project.service.BasePublicService.BasicPublicVatSurTaxrateService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName BasicPublicSurTaxrateController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 9:15
 **/
@RestController
@RequestMapping("/api/v1/sur")
public class BasicPublicSurTaxrateController {

    @Autowired
    private BasicPublicVatSurTaxrateService sTRService;


    @PostMapping("/findByListSur")
    public ResponseBase findByListSur(@RequestBody BasicPublicVatTaxrate taxRate) {
        PageInfoUtils.setPage(taxRate.getPageSize(), taxRate.getCurrentPage());
        List<BasicPublicVatTaxrate> taxRateList = sTRService.serviceFindByListSurTaxrate(taxRate);
        return PageInfoUtils.returnPage(taxRateList, taxRate.getCurrentPage());
    }
}
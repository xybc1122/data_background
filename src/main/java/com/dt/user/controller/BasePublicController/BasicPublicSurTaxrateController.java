package com.dt.user.controller.BasePublicController;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.model.BasePublicModel.BasicHrEducation;
import com.dt.user.model.BasePublicModel.BasicPublicVatSurTaxrate;
import com.dt.user.service.BasePublicService.BasicPublicVatSurTaxrateService;
import com.dt.user.utils.PageInfoUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    private BasicPublicVatSurTaxrateService surTaxrateService;


    @PostMapping("/findByListSur")
    public ResponseBase findByListSur(@RequestBody BasicPublicVatSurTaxrate vatSurTaxrate) {
        PageInfoUtils.setPage(vatSurTaxrate.getPageSize(), vatSurTaxrate.getCurrentPage());
        List<BasicPublicVatSurTaxrate> surTaxrateList = surTaxrateService.serviceFindByListSurTaxrate(vatSurTaxrate);
        return PageInfoUtils.returnPage(surTaxrateList, vatSurTaxrate.getCurrentPage());
    }
}

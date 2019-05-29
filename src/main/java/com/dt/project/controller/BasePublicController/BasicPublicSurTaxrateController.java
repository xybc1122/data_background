package com.dt.project.controller.basePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.basePublicModel.BasicPublicSurTaxrate;
import com.dt.project.service.basePublicService.BasicPublicSurTaxrateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BasicPublicSurTaxrateController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/17 11:30
 **/
@RestController
@RequestMapping("/api/v1/sur")
public class BasicPublicSurTaxrateController {

    @Autowired
    private BasicPublicSurTaxrateService surService;

    /**
     * 查询附加税 接口
     *
     * @param surTaxrate
     * @return
     */
    @PostMapping("/findByListSur")
    public ResponseBase findByListSur(@RequestBody BasicPublicSurTaxrate surTaxrate) {
        return surService.serviceSelectBySurTax(surTaxrate);
    }

}

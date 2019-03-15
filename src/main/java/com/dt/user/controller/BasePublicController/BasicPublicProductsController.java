package com.dt.user.controller.BasePublicController;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.model.BasePublicModel.BasicPublicProducts;
import com.dt.user.service.BasePublicService.BasicPublicProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pro")
public class BasicPublicProductsController {
    @Autowired
    private BasicPublicProductsService publicProductsService;

    /**
     * 获取产品类目
     *
     * @return
     */
    @GetMapping("/findByListProducts")
    public ResponseBase findByListProducts() {
        List<BasicPublicProducts> basicPublicSiteList = publicProductsService.findByProductsInfo();
        return JsonData.setResultSuccess(basicPublicSiteList);
    }
}

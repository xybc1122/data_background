package com.dt.project.controller.BasePublicController;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.model.BasePublicModel.BasicPublicProducts;
import com.dt.project.model.Parent.ParentTree;
import com.dt.project.service.BasePublicService.BasicPublicProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
        List<ParentTree> basicPublicSiteList = publicProductsService.serviceFindByProductsInfo();
        return JsonData.setResultSuccess(basicPublicSiteList);
    }

    @PostMapping("/upProducts")
    public ResponseBase upProductInfo(@RequestBody BasicPublicProducts products) {
        return publicProductsService.serviceUpProducts(products);
    }

    @PostMapping("/delProducts")
    public ResponseBase delProductInfo(@RequestBody Map<String, String> delMap) {
        return publicProductsService.serviceDelProducts(delMap);
    }

    @PostMapping("/saveProducts")
    public ResponseBase saveProductInfo(@RequestBody BasicPublicProducts products) {
        return publicProductsService.serviceSaveProducts(products);
    }
}

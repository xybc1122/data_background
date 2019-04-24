package com.dt.user.controller.BasePublicController;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.model.BasePublicModel.BasicPublicProducts;
import com.dt.user.model.Parent.ParentTree;
import com.dt.user.service.BasePublicService.BasicPublicProductsService;
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

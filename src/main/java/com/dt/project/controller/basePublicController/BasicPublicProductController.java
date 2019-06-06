package com.dt.project.controller.basePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.dto.ProductDto;
import com.dt.project.model.basePublic.BasicPublicProduct;
import com.dt.project.service.basePublicService.BasicPublicProductService;
import com.dt.project.utils.PageInfoUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/v1/product")
@RestController
public class BasicPublicProductController {

    @Autowired
    private BasicPublicProductService productService;

    /**
     * 查询产品信息
     *
     * @return
     */
    @PostMapping("/findByListProduct")
    public ResponseBase findByListProduct(@RequestBody ProductDto productDto) {
        PageInfoUtils.setPage(productDto.getPageSize(), productDto.getCurrentPage());
        return PageInfoUtils.returnPage(productService.findProductInfo(productDto));
    }

    @PostMapping("/upProduct")
    public ResponseBase upProductInfo(@RequestBody BasicPublicProduct product) {
        return productService.serviceUpProduct(product);
    }


    @PostMapping("/delProduct")
    public ResponseBase delProductInfo(@RequestBody Map<String, String> proMap) {
        return productService.serviceDelProduct(proMap);
    }


    @PostMapping("/saveProduct")
    public ResponseBase saveProductInfo(@RequestBody BasicPublicProduct product) {
        return productService.serviceSaveProduct(product);
    }

    @GetMapping("/getProductAdnSku")
    public ResponseBase getProductAdnSku(@Param("skuId") String skuId) {
        return productService.serviceGetPublicProduct(Integer.parseInt(skuId));
    }
}

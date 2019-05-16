package com.dt.project.controller.BasePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.dto.ProductDto;
import com.dt.project.model.BasePublicModel.BasicPublicProduct;
import com.dt.project.service.BasePublicService.BasicPublicProductService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/v1/product")
@RestController
public class BasicPublicProductController {

    @Autowired
    private BasicPublicProductService productService;

    /**
     * 获得产品信息
     *
     * @return
     */
    @PostMapping("/findByListProduct")
    public ResponseBase findByListProduct(@RequestBody ProductDto productDto) {
        PageInfoUtils.setPage(productDto.getPageSize(), productDto.getCurrentPage());
        List<ProductDto> basicPublicCurrencies = productService.findProductInfo(productDto);
        return PageInfoUtils.returnPage(basicPublicCurrencies, productDto.getCurrentPage());
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
}
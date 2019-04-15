package com.dt.user.controller.BasePublicController;

import com.dt.user.config.ResponseBase;
import com.dt.user.dto.ProductDto;
import com.dt.user.model.BasePublicModel.BasicPublicProduct;
import com.dt.user.service.BasePublicService.BasicPublicProductService;
import com.dt.user.utils.PageInfoUtils;
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

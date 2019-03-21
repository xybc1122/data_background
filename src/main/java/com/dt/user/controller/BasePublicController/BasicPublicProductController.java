package com.dt.user.controller.BasePublicController;

import com.dt.user.config.ResponseBase;
import com.dt.user.dto.ProductDto;
import com.dt.user.service.BasePublicService.BasicPublicProductService;
import com.dt.user.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}

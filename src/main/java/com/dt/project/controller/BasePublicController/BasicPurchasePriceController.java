package com.dt.project.controller.basePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.basePublicModel.BasicPurchasePrice;
import com.dt.project.service.basePublicService.BasicPurchasePriceService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @ClassName BasicPurchasePriceController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 14:33
 **/
@RestController
@RequestMapping("/api/v1/price")
public class BasicPurchasePriceController {

    @Autowired
    private BasicPurchasePriceService priceService;


    @PostMapping("/findByListPrice")
    public ResponseBase findByListPrice(@RequestBody BasicPurchasePrice purchasePrice) {
        PageInfoUtils.setPage(purchasePrice.getPageSize(), purchasePrice.getCurrentPage());
        return PageInfoUtils.returnPage(priceService.serviceFindByListPrice(purchasePrice), purchasePrice.getCurrentPage());
    }

}

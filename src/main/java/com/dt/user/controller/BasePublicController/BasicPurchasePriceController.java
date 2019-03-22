package com.dt.user.controller.BasePublicController;

import com.dt.user.config.ResponseBase;
import com.dt.user.model.BasePublicModel.BasicPurchasePrice;
import com.dt.user.service.BasePublicService.BasicPurchasePriceService;
import com.dt.user.utils.PageInfoUtils;
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

package com.dt.user.controller.BasePublicController;

import com.dt.user.config.ResponseBase;
import com.dt.user.model.BasePublicModel.BasicLogisticsmgtTransportProperty;
import com.dt.user.model.BasePublicModel.BasicSalesAmazonPaymentType;
import com.dt.user.service.BasePublicService.BasicSalesAmazonPaymentTypeService;
import com.dt.user.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName BasicSalesAmazonPaymentTypeController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 16:12
 **/
@RestController
@RequestMapping("/api/v1/pay")
public class BasicSalesAmazonPaymentTypeController {
    @Autowired
    private BasicSalesAmazonPaymentTypeService typeService;

    @GetMapping("/findByListProperty")
    public ResponseBase findByListProperty(@RequestParam("pageSize") Integer pageSize,
                                           @RequestParam("currentPage") Integer currentPage) {
        PageInfoUtils.setPage(pageSize, currentPage);
        List<BasicSalesAmazonPaymentType> paymentTypeList = typeService.serviceFindByListPayType();
        return PageInfoUtils.returnPage(paymentTypeList, currentPage);
    }
}

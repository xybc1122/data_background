package com.dt.project.controller.basePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.basePublic.BasicSalesAmazonPaymentType;
import com.dt.project.service.basePublicService.BasicSalesAmazonPaymentTypeService;
import com.dt.project.utils.PageInfoUtils;
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
        return PageInfoUtils.returnPage(typeService.serviceFindByListPayType());
    }
}

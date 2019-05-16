package com.dt.project.controller.BasePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.service.BasePublicService.BasicSalesDeliveryTypeService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BasicSalesDeliveryTypeController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/20 13:26
 **/
@RequestMapping("/api/v1/deli")
@RestController
public class BasicSalesDeliveryTypeController {
    @Autowired
    private BasicSalesDeliveryTypeService deliveryTypeService;


    @GetMapping("/findByListDelivery")
    public ResponseBase findByListDelivery(@RequestParam("pageSize") Integer pageSize,
                                           @RequestParam("currentPage") Integer currentPage) {
        PageInfoUtils.setPage(pageSize, currentPage);
        return PageInfoUtils.returnPage(deliveryTypeService.serviceFindByListDeliveryType(), currentPage);
    }


}

package com.dt.project.controller.basePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.basePublicModel.BasicSalesAmazonWarehouse;
import com.dt.project.service.basePublicService.BasicSalesAmazonWarehouseService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BasicSalesAmazonWarehouseController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/20 11:11
 **/
@RequestMapping("/api/v1/amazon/war")
@RestController
public class BasicSalesAmazonWarehouseController {

    @Autowired
    private BasicSalesAmazonWarehouseService amazonWarehouseService;


    @PostMapping("/findByListWarehouse")
    public ResponseBase findByListWarehouse(@RequestBody BasicSalesAmazonWarehouse amazonWarehouse) {
        PageInfoUtils.setPage(amazonWarehouse.getPageSize(), amazonWarehouse.getCurrentPage());
        return PageInfoUtils.returnPage(amazonWarehouseService.serviceFindByListAmazonWarehouse(amazonWarehouse), amazonWarehouse.getCurrentPage());
    }


}

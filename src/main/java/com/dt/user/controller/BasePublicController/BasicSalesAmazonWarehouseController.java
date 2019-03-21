package com.dt.user.controller.BasePublicController;

import com.dt.user.config.ResponseBase;
import com.dt.user.model.BasePublicModel.BasicSalesAmazonType;
import com.dt.user.model.BasePublicModel.BasicSalesAmazonWarehouse;
import com.dt.user.service.BasePublicService.BasicSalesAmazonWarehouseService;
import com.dt.user.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        List<BasicSalesAmazonWarehouse> amazonWarehouseList = amazonWarehouseService.serviceFindByListAmazonWarehouse(amazonWarehouse);
        return PageInfoUtils.returnPage(amazonWarehouseList, amazonWarehouse.getCurrentPage());
    }


}

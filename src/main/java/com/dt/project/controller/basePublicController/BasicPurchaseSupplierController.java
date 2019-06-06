package com.dt.project.controller.basePublicController;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.model.basePublic.BasicPurchaseSupplier;
import com.dt.project.service.basePublicService.BasicPurchaseSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName BasicPurchaseSupplierController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/3 9:09
 **/
@RestController
@RequestMapping("/api/v1/sup")
public class BasicPurchaseSupplierController {
    @Autowired
    private BasicPurchaseSupplierService supplierService;


    /**
     * 查询供应商名字
     *
     * @return
     */
    @PostMapping("/findSupList")
    public ResponseBase findByListSubList(@RequestBody BasicPurchaseSupplier pSupplier) {
        return JsonData.setResultSuccess(supplierService.selectByPurchaseSupplier(pSupplier));
    }


}

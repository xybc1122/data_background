package com.dt.project.controller.purchaseController;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.purchasePo.PurchasePoOrder;
import com.dt.project.service.JavaSqlNameService;
import com.dt.project.service.purchaseService.PurchasePoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName PurchasePoOrderController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/27 10:50
 * 采购订单Controller
 **/
@RestController
@RequestMapping("/api/v1/order")
public class PurchasePoOrderController {

    @Autowired
    private PurchasePoOrderService poOrderService;


    @Autowired
    private JavaSqlNameService nameService;

    /**
     * 查询采购订单信息
     *
     * @return
     */
    @PostMapping("/getPoOrder")
    public ResponseBase getPoOrder(@RequestBody PurchasePoOrder poOrder) {
        //这里放入缓存
        poOrder.setJavaSqlName(nameService.get("poOrder"));
        return poOrderService.serviceSelectByPoOrder(poOrder);
    }

    /**
     * 采购订单信息新增消息
     *
     * @return
     */
    @PostMapping("/savePoOrder")
    public ResponseBase savePoOrder(@RequestBody Map<String, Object> objectMap) {
        poOrderService.serviceSavePoOrder(objectMap);
        return null;
    }

}

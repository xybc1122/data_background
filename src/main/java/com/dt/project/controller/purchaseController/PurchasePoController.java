package com.dt.project.controller.purchaseController;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.purchasePo.PurchaseIcBillStock;
import com.dt.project.model.purchasePo.PurchasePoOrder;
import com.dt.project.model.purchasePo.PurchasePoReceiptNotice;
import com.dt.project.service.JavaSqlNameService;
import com.dt.project.service.purchaseService.PurchaseIcBillStockService;
import com.dt.project.service.purchaseService.PurchasePoOrderService;
import com.dt.project.service.purchaseService.PurchasePoReceiptNoticeService;
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
@RequestMapping("/api/v1/po")
public class PurchasePoController {

    @Autowired
    private PurchasePoOrderService poOrderService;
    @Autowired
    private PurchasePoReceiptNoticeService receiptNoticeService;

    @Autowired
    private JavaSqlNameService nameService;

    @Autowired
    private PurchaseIcBillStockService icBillStockService;

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
     * 新增采购订单
     *
     * @return
     */
    @PostMapping("/savePoOrder")
    public ResponseBase savePoOrder(@RequestBody Map<String, Object> objectMap) {
        return poOrderService.serviceInsertPoOrder(objectMap);
    }


    /**
     * 查询收货订单
     *
     * @return
     */
    @PostMapping("/getReceiptNotice")
    public ResponseBase getReceiptNotice(@RequestBody PurchasePoReceiptNotice receiptNotice) {
        //这里放入缓存
        receiptNotice.setJavaSqlName(nameService.get("pPRNotice"));
        return receiptNoticeService.serviceSelectByPoReceiptNotice(receiptNotice);
    }

    /**
     * 查询外购入库
     *
     * @return
     */
    @PostMapping("/getIcBillStock")
    public ResponseBase getReceiptNotice(@RequestBody PurchaseIcBillStock icBillStock) {
        //这里放入缓存
        icBillStock.setJavaSqlName(nameService.get("icBillStock"));
        return icBillStockService.serviceSelectByIcBillStock(icBillStock);
    }
}

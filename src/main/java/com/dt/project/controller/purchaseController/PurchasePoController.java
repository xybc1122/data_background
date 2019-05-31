package com.dt.project.controller.purchaseController;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.purchasePo.PurchaseIcBillStock;
import com.dt.project.model.purchasePo.PurchasePoOrder;
import com.dt.project.model.purchasePo.PurchasePoReceiptNotice;
import com.dt.project.service.GeneralPurposeService;
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

    @Autowired
    private GeneralPurposeService gPService;


    /**
     * @api {POST} /api/v1/po/getPoOrder 查询采购订单信息
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 查询采购订单信息
     * @apiParamExample {json} 请求样例：
     * {"currentPage":"0",
     * "pageSize":"10",
     * "systemLogStatus":{},
     * "poOrderEntry":{
     * }
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PostMapping("/getPoOrder")
    public ResponseBase getPoOrder(@RequestBody PurchasePoOrder poOrder) {
        //这里放入缓存
        poOrder.setJavaSqlName(nameService.get("poOrder"));
        return poOrderService.serviceSelectByPoOrder(poOrder);
    }


    /**
     * @api {POST} /api/v1/po/savePoOrder 新增采购订单
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 新增采购订单
     * @apiParamExample {json} 请求样例：
     * {
     * "salesShipNotice":{
     * "date":12234,
     * "platform_type_id":10,
     * "delivery_date":13515874497,
     * "arrive_date":898989,
     * "transport_type_id":9,
     * "shop_id":4,
     * "site_id":6,
     * "no":"4"
     * },
     * "salesShipNoticeEntry":[
     * {"entryId":1,"sku_id":1},{"entryId":2,"sku_id":2}
     * ]
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PostMapping("/savePoOrder")
    public ResponseBase savePoOrder(@RequestBody Map<String, Object> objectMap) {
        return poOrderService.serviceInsertPoOrder(objectMap);
    }

    /**
     * 修改采购订单
     *
     * @param objectMap
     * @return
     */
    @PostMapping("/upPoOrder")
    public ResponseBase upPoOrder(@RequestBody Map<String, Object> objectMap) {
        return poOrderService.serviceUpdateByPoOrder(objectMap);
    }

    /**
     * 删除采购订单
     *
     * @return
     */
    @PostMapping("/delPoOrder")
    public ResponseBase delPoOrder(@RequestBody Map<String, Object> objectMap) {
        objectMap.put("table", "`purchase_po_order`");
        objectMap.put("thisId", "`po_id`");
        objectMap.put("childTable", "`purchase_po_order_entry`");
        objectMap.put("childThisId", "`poe_id`");
        return gPService.universalDelete(objectMap);
    }


    /**
     * @api {POST} /api/v1/po/getReceiptNotice 查询收货通知单
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 查询收货通知单
     * @apiParamExample {json} 请求样例：
     * {"currentPage":"0",
     * "pageSize":"10",
     * "purchasePoReceiptNoticeEntry":{
     * }
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PostMapping("/getReceiptNotice")
    public ResponseBase getReceiptNotice(@RequestBody PurchasePoReceiptNotice receiptNotice) {
        //这里放入缓存
        receiptNotice.setJavaSqlName(nameService.get("pPRNotice"));
        return receiptNoticeService.serviceSelectByPoReceiptNotice(receiptNotice);
    }

    /**
     * @api {POST} /api/v1/po/saveReceiptNotice 新增收货通知单
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 新增收货通知单
     * @apiParamExample {json} 请求样例：
     * {"purchasePoReceiptNotice": {
     * "closeDate": 1559232000000,
     * "closeUser": "7",
     * "date": 1557763200000,
     * "deptId": "6",
     * "explanation": "3",
     * "fetchAdd": "2",
     * "no": "1",
     * "remar": "5",
     * "status": "4"
     * },
     * "purchasePoReceiptNoticeEntry": [
     * {
     * "deliveryDate": null,
     * "eRemark": null
     * }, {
     * "deliveryDate": null,
     * "eRemark": null
     * }
     * ]
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PostMapping("/saveReceiptNotice")
    public ResponseBase saveReceiptNotice(@RequestBody Map<String, Object> objectMap) {
        return receiptNoticeService.serviceInsertPoReceiptNotice(objectMap);
    }

    /**
     * @api {POST} /api/v1/po/saveReceiptNotice 修改收货通知单
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 修改收货通知单
     * @apiParamExample {json} 请求样例：
     * {
     * "purchasePoReceiptNotice": {"no": "123", "closeUser": "234",
     * "closeDate": 1559232000000, "rnId": 1, "version": 0,"statusId":1},
     * "purchasePoReceiptNoticeEntry": [ {"version": 0}]
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PostMapping("/upReceiptNotice")
    public ResponseBase upReceiptNotice(@RequestBody Map<String, Object> objectMap) {
        return receiptNoticeService.serviceUpdateByPoReceiptNotice(objectMap);
    }

    /**
     * 删除收货通知单
     *
     * @return
     */
    @PostMapping("/delReceiptNotice")
    public ResponseBase delReceiptNotice(@RequestBody Map<String, Object> objectMap) {
        //这是设置 主表AND ID      还有 子表 AND ID
        objectMap.put("table", "`purchase_po_receipt_notice`");
        objectMap.put("thisId", "`rn_id`");
        objectMap.put("childTable", "`purchase_po_receipt_notice_entry`");
        objectMap.put("childThisId", "`rne_id`");
        return gPService.universalDelete(objectMap);
    }

    /**
     * @api {POST} /api/v1/po/getIcBillStock 查询外购入库
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 查询外购入库
     * @apiParamExample {json} 请求样例：
     * {"currentPage":"0",
     * "pageSize":"10",
     * "purchaseIcBillStockEntry":{
     * }
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PostMapping("/getIcBillStock")
    public ResponseBase getIcBillStock(@RequestBody PurchaseIcBillStock icBillStock) {
        //这里放入缓存
        icBillStock.setJavaSqlName(nameService.get("icBillStock"));
        return icBillStockService.serviceSelectByIcBillStock(icBillStock);
    }

    /**
     * 新增外购入库
     *
     * @return
     */
    @PostMapping("/saveIcBillStock")
    public ResponseBase saveIcBillStock(@RequestBody Map<String, Object> objectMap) {
        return icBillStockService.serviceInsertIcBillStock(objectMap);
    }

    /**
     * 删除外购入库
     *
     * @return
     */
    @PostMapping("/delIcBillStock")
    public ResponseBase delIcBillStock(@RequestBody Map<String, Object> objectMap) {
        objectMap.put("table", "`purchase_ic_bill_stock`");
        objectMap.put("thisId", "`sb_id`");
        objectMap.put("childTable", "`purchase_ic_bill_stock_entry`");
        objectMap.put("childThisId", "`sbe_id`");
        return gPService.universalDelete(objectMap);
    }

    /**
     * 修改入库通知单接口
     *
     * @param objectMap
     * @return
     */
    @PostMapping("/uplIcBillStock")
    public ResponseBase uplIcBillStock(@RequestBody Map<String, Object> objectMap) {
        return null;
    }

}

package com.dt.project.controller.salesAmazonController;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.salesAmazon.SalesShipNotice;
import com.dt.project.service.JavaSqlNameService;
import com.dt.project.service.salesAmazonService.SalesShipNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName SalesShipNoticeController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/10 17:23
 **/
@RestController
@RequestMapping("/api/v1/no")
public class SalesShipNoticeController {
    @Autowired
    private SalesShipNoticeService noticeService;
    @Autowired
    private JavaSqlNameService nameService;

    /**
     * 查询发货通知单信息
     *
     * @return
     */
    @PostMapping("/getNotice")
    public ResponseBase getNotice(@RequestBody SalesShipNotice notice) {
        //这里放入缓存
        notice.setNameList(nameService.get("shipNotice"));
        return noticeService.selectSelectByNotice(notice);
    }


    /**
     * @api {POST} /api/v1/no/saveNotice 新增发货通知单
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 新增发货通知单
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
    @PostMapping("/saveNotice")
    public ResponseBase saveNotice(@RequestBody Map<String, Object> noMap) {
        return noticeService.saveNotice(noMap);
    }

}

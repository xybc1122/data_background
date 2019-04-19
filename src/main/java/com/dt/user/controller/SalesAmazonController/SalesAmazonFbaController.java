package com.dt.user.controller.SalesAmazonController;

import com.dt.user.config.ResponseBase;
import com.dt.user.model.JavaSqlName;
import com.dt.user.model.SalesAmazon.*;
import com.dt.user.service.JavaSqlNameService;
import com.dt.user.service.SalesAmazonService.*;
import com.dt.user.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName SalesAmazonFbaController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/8 13:02
 **/
@RestController
@RequestMapping("/api/v1/fba")
public class SalesAmazonFbaController {
    @Autowired
    private JavaSqlNameService nameService;

    @Autowired
    private SalesAmazonFbaBusinessreportService busService;
    @Autowired
    private SalesAmazonFbaTradeReportService orderRePortService;
    @Autowired
    private SalesAmazonFbaRefundService refundService;
    @Autowired
    private SalesAmazonFbaReceivestockService recService;
    @Autowired
    private SalesAmazonFbaInventoryEndService invService;
    @Autowired
    private SalesAmazonFbaAbandonService abandonService;
    @Autowired
    private SalesAmazonFbaShipNoticeEntryService entryService;

    @Autowired
    private SalesAmazonFbaMonthWarehouseFeeService mWarService;


    /**
     * 查询业务报告信息
     *
     * @param bus
     * @return
     */
    @PostMapping("/getBusInfo")
    public ResponseBase getBusInfo(@RequestBody SalesAmazonFbaBusinessreport bus) {
        PageInfoUtils.setPage(bus.getPageSize(), bus.getCurrentPage());
        return PageInfoUtils.returnPage(busService.serviceFindByListBus(bus), bus.getCurrentPage());
    }

    /**
     * 查询订单报告信息
     *
     * @param report 订单报告
     * @return
     */
    @PostMapping("/getOrderRePortInfo")
    public ResponseBase getBusInfo(@RequestBody SalesAmazonFbaTradeReport report) {
        PageInfoUtils.setPage(report.getPageSize(), report.getCurrentPage());
        return PageInfoUtils.returnPage(orderRePortService.serviceFindByListOrderReport(report), report.getCurrentPage());
    }

    /**
     * 查询退货报告
     *
     * @return
     */
    @PostMapping("/geRefundInfo")
    public ResponseBase getRefundInfo(@RequestBody SalesAmazonFbaRefund refund) {
        PageInfoUtils.setPage(refund.getPageSize(), refund.getCurrentPage());
        return PageInfoUtils.returnPage(refundService.serviceFindByListRefund(refund), refund.getCurrentPage());
    }

    /**
     * 查询接收库存信息
     *
     * @return
     */
    @PostMapping("/getReceiveInfo")
    public ResponseBase getRefundInfo(@RequestBody SalesAmazonFbaReceivestock rec) {
        PageInfoUtils.setPage(rec.getPageSize(), rec.getCurrentPage());
        return PageInfoUtils.returnPage(recService.serviceFindByListRec(rec), rec.getCurrentPage());
    }


    /**
     * 查询期末库存信息
     *
     * @return
     */
    @PostMapping("/getInventoryInfo")
    public ResponseBase getRefundInfo(@RequestBody SalesAmazonFbaInventoryEnd inv) {
        PageInfoUtils.setPage(inv.getPageSize(), inv.getCurrentPage());
        return PageInfoUtils.returnPage(invService.serviceFindByListEnd(inv), inv.getCurrentPage());
    }


    /**
     * 查询FBA遗弃
     *
     * @return
     */
    @PostMapping("/getAbandonInfo")
    public ResponseBase getAbandonInfo(@RequestBody SalesAmazonFbaAbandon abandon) {
        PageInfoUtils.setPage(abandon.getPageSize(), abandon.getCurrentPage());
        return PageInfoUtils.returnPage(abandonService.serviceFindByListAbandon(abandon), abandon.getCurrentPage());
    }


    /**
     * 查询出货通知单
     *
     * @return
     */
    @PostMapping("/getNoticeInfo")
    public ResponseBase getNoticeInfo(@RequestBody SalesAmazonFbaShipNoticeEntry entry) {
        PageInfoUtils.setPage(entry.getPageSize(), entry.getCurrentPage());
        return PageInfoUtils.returnPage(entryService.serviceFindByListAbandon(entry), entry.getCurrentPage());
    }

    /**
     * 查询月度仓库费
     *
     * @return
     */
    @PostMapping("/getMWarInfo")
    public ResponseBase getMWarInfo(@RequestBody SalesAmazonFbaMonthWarehouseFee fee) {
        //这里放入缓存
        List<JavaSqlName> info = nameService.get("monthWarehouseFee");
        fee.setNameList(info);
        PageInfoUtils.setPage(fee.getPageSize(), fee.getCurrentPage());
        return PageInfoUtils.returnPage(mWarService.serviceFindByListMWar(fee), fee.getCurrentPage());
    }

}

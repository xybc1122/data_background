package com.dt.user.controller.SalesAmazonController;

import com.dt.user.config.ResponseBase;
import com.dt.user.model.SalesAmazonAd.SalesAmazonFbaBusinessreport;
import com.dt.user.model.SalesAmazonAd.SalesAmazonFbaTradeReport;
import com.dt.user.service.SalesAmazonService.SalesAmazonFbaBusinessreportService;
import com.dt.user.service.SalesAmazonService.SalesAmazonFbaTradeReportService;
import com.dt.user.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private SalesAmazonFbaBusinessreportService busService;
    @Autowired
    private SalesAmazonFbaTradeReportService orderRePortService;

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
}

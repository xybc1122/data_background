package com.dt.project.controller.salesAmazonController;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.dto.ReviewDto;
import com.dt.project.model.salesAmazon.*;
import com.dt.project.redis.RedisService;
import com.dt.project.service.salesAmazonService.*;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private SalesAmazonFbaRefundService refundService;
    @Autowired
    private SalesAmazonFbaReceivestockService recService;
    @Autowired
    private SalesAmazonFbaInventoryEndService invService;
    @Autowired
    private SalesAmazonFbaAbandonService abandonService;

    @Autowired
    private SalesAmazonFbaMonthWarehouseFeeService mWarService;

    @Autowired
    private SalesAmazonFbaLongWarehousefeeServcie lWarService;
    @Autowired
    private SalesAmazonFbaHandlingFeeService hlingFeeService;
    @Autowired
    private SalesAmazonFbaFeedbackService feedbackService;

    @Autowired
    private SalesAmazonFbaReviewService reviewService;

    @Autowired
    private RedisService redisService;

    /**
     * 查询业务报告信息
     *
     * @param bus
     * @return
     */
    @PostMapping("/getBusInfo")
    public ResponseBase getBusInfo(@RequestBody SalesAmazonFbaBusinessreport bus) {
        PageInfoUtils.setPage(bus.getPageSize(), bus.getCurrentPage());
        return PageInfoUtils.returnPage(busService.serviceFindByListBus(bus));
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
        return PageInfoUtils.returnPage(orderRePortService.serviceFindByListOrderReport(report));
    }

    /**
     * 查询退货报告
     *
     * @return
     */
    @PostMapping("/geRefundInfo")
    public ResponseBase getRefundInfo(@RequestBody SalesAmazonFbaRefund refund) {
        PageInfoUtils.setPage(refund.getPageSize(), refund.getCurrentPage());
        return PageInfoUtils.returnPage(refundService.serviceFindByListRefund(refund));
    }

    /**
     * 查询接收库存信息
     *
     * @return
     */
    @PostMapping("/getReceiveInfo")
    public ResponseBase getRefundInfo(@RequestBody SalesAmazonFbaReceivestock rec) {
        PageInfoUtils.setPage(rec.getPageSize(), rec.getCurrentPage());
        return PageInfoUtils.returnPage(recService.serviceFindByListRec(rec));
    }


    /**
     * 查询期末库存信息
     *
     * @return
     */
    @PostMapping("/getInventoryInfo")
    public ResponseBase getRefundInfo(@RequestBody SalesAmazonFbaInventoryEnd inv) {
        PageInfoUtils.setPage(inv.getPageSize(), inv.getCurrentPage());
        return PageInfoUtils.returnPage(invService.serviceFindByListEnd(inv));
    }


    /**
     * 查询FBA遗弃
     *
     * @return
     */
    @PostMapping("/getAbandonInfo")
    public ResponseBase getAbandonInfo(@RequestBody SalesAmazonFbaAbandon abandon) {
        PageInfoUtils.setPage(abandon.getPageSize(), abandon.getCurrentPage());
        return PageInfoUtils.returnPage(abandonService.serviceFindByListAbandon(abandon));
    }


    /**
     * 查询月度仓库费
     *
     * @return
     */
    @PostMapping("/getMWarInfo")
    public ResponseBase getMWarInfo(@RequestBody SalesAmazonFbaMonthWarehouseFee mFee) {
        PageInfoUtils.setPage(mFee.getPageSize(), mFee.getCurrentPage());
        return PageInfoUtils.returnPage(mWarService.serviceFindByListMWar(mFee));
    }

    /**
     * 查询长期仓储费
     *
     * @return
     */
    @PostMapping("/getLWarInfo")
    public ResponseBase getLWarInfo(@RequestBody SalesAmazonFbaLongWarehouseFee lFee) {
        PageInfoUtils.setPage(lFee.getPageSize(), lFee.getCurrentPage());
        return PageInfoUtils.returnPage(lWarService.serviceSelectByLongWarehouse(lFee));

    }

    /**
     * 查询订单处理费
     *
     * @return
     */
    @PostMapping("/getHlFee")
    public ResponseBase getHlFee(@RequestBody SalesAmazonFbaHandlingFee hlFee) {
        return PageInfoUtils.returnPage(hlingFeeService.serviceSelectByHandLFee(hlFee));
    }

    /**
     * 查询Feedback
     *
     * @return
     */
    @PostMapping("/getFeedback")
    public ResponseBase getFeedback(@RequestBody SalesAmazonFbaFeedback feedback) {
        PageInfoUtils.setPage(feedback.getPageSize(), feedback.getCurrentPage());
        return PageInfoUtils.returnPage(feedbackService.serviceSelectByFeedback(feedback));
    }

    /**
     * 新增Feedback
     *
     * @return
     */
    @PostMapping("/saveFeedback")
    public ResponseBase saveFeedback(@RequestBody SalesAmazonFbaFeedback feedback) {
        return feedbackService.serviceInsert(feedback);
    }

    /**
     * 查询review
     *
     * @return
     */
    @PostMapping("/getReview")
    public ResponseBase getReview(@RequestBody ReviewDto reviewDto) {
        PageInfoUtils.setPage(reviewDto.getPageSize(), reviewDto.getCurrentPage());
        return PageInfoUtils.returnPage(reviewService.serviceSelectByReview(reviewDto));
    }

    /**
     * 新增Review
     *
     * @return
     */
    @PostMapping("/saveReview")
    public ResponseBase getReview(@RequestBody SalesAmazonFbaReview review) {
        return reviewService.serviceInsertReview(review);
    }

    /**
     * 删除 Review
     */
    @GetMapping("/delReview")
    public ResponseBase delReview(@RequestParam("thisIds") String thisIds, @RequestParam("versions") String versions) {
        return reviewService.serviceDelReview(thisIds, versions);
    }

    /**
     * 更新 Review
     */
    @PostMapping("/upReview")
    public ResponseBase upReview(@RequestBody SalesAmazonFbaReview review) {
        return reviewService.serviceUpdateByReview(review);
    }
}

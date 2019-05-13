package com.dt.user.controller.SalesAmazonController;

import com.dt.user.config.ResponseBase;
import com.dt.user.dto.ReviewDto;
import com.dt.user.model.SalesAmazon.*;
import com.dt.user.service.JavaSqlNameService;
import com.dt.user.service.SalesAmazonService.*;
import com.dt.user.utils.PageInfoUtils;
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
    private SalesAmazonFbaMonthWarehouseFeeService mWarService;

    @Autowired
    private SalesAmazonFbaLongWarehousefeeServcie lWarService;
    @Autowired
    private SalesAmazonFbaHandlingFeeService hlingFeeService;
    @Autowired
    private SalesAmazonFbaFeedbackService feedbackService;

    @Autowired
    private SalesAmazonFbaReviewService reviewService;

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
        //这里放入缓存
        nameService.get("abandon", abandon);
        PageInfoUtils.setPage(abandon.getPageSize(), abandon.getCurrentPage());
        return PageInfoUtils.returnPage(abandonService.serviceFindByListAbandon(abandon), abandon.getCurrentPage());
    }


    /**
     * 查询月度仓库费
     *
     * @return
     */
    @PostMapping("/getMWarInfo")
    public ResponseBase getMWarInfo(@RequestBody SalesAmazonFbaMonthWarehouseFee mFee) {
        //这里放入缓存
        nameService.get("monthWarehouseFee", mFee);
        PageInfoUtils.setPage(mFee.getPageSize(), mFee.getCurrentPage());
        return PageInfoUtils.returnPage(mWarService.serviceFindByListMWar(mFee), mFee.getCurrentPage());
    }

    /**
     * 查询长期仓储费
     *
     * @return
     */
    @PostMapping("/getLWarInfo")
    public ResponseBase getLWarInfo(@RequestBody SalesAmazonFbaLongWarehouseFee lFee) {
        //这里放入缓存
        nameService.get("longWarehouseFee", lFee);
        PageInfoUtils.setPage(lFee.getPageSize(), lFee.getCurrentPage());
        return PageInfoUtils.returnPage(lWarService.serviceSelectByLongWarehouse(lFee), lFee.getCurrentPage());

    }

    /**
     * 查询订单处理费
     *
     * @return
     */
    @PostMapping("/getHlFee")
    public ResponseBase getHlFee(@RequestBody SalesAmazonFbaHandlingFee hlFee) {
        //这里放入缓存
        nameService.get("handlingFee", hlFee);
        PageInfoUtils.setPage(hlFee.getPageSize(), hlFee.getCurrentPage());
        return PageInfoUtils.returnPage(hlingFeeService.serviceSelectByHandLFee(hlFee), hlFee.getCurrentPage());
    }

    /**
     * 查询Feedback
     *
     * @return
     */
    @PostMapping("/getFeedback")
    public ResponseBase getFeedback(@RequestBody SalesAmazonFbaFeedback feedback) {
        //这里放入缓存
        nameService.get("feedback", feedback);
        PageInfoUtils.setPage(feedback.getPageSize(), feedback.getCurrentPage());
        return PageInfoUtils.returnPage(feedbackService.serviceSelectByFeedback(feedback), feedback.getCurrentPage());
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
        //这里放入缓存
        nameService.get("review", reviewDto);
        PageInfoUtils.setPage(reviewDto.getPageSize(), reviewDto.getCurrentPage());
        return PageInfoUtils.returnPage(reviewService.serviceSelectByReview(reviewDto), reviewDto.getCurrentPage());
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

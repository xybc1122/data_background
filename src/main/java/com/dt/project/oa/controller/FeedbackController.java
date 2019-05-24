package com.dt.project.oa.controller;

import com.dt.project.config.ResponseBase;
import com.dt.project.oa.model.Feedback;
import com.dt.project.oa.model.MyTask;
import com.dt.project.oa.service.FeedbackImplService;
import com.dt.project.utils.ReqUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName ProAppFormController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/15 15:55
 **/
@RestController
@RequestMapping("/api/v1/fee")
public class FeedbackController {

    @Autowired
    private FeedbackImplService fService;

    /**
     * 开始发起流程
     *
     * @param feedback
     * @return
     */
    @PostMapping("/startFee")
    public ResponseBase startFeedback(@RequestBody Feedback feedback) {
        return fService.startProcess(feedback);
    }

    /**
     * 查看自己正在申请的流程状态
     *
     * @return
     */
    @GetMapping("/selProcess")
    public ResponseBase selProcess(@RequestParam("pageSize") Integer pageSize,
                                   @RequestParam("currentPage") Integer currentPage) {
        return fService.selThisProcess(ReqUtils.getUserName(), pageSize, currentPage);
    }

    /**
     * 查看自己已经审批结束的记录
     *
     * @return
     */
    @GetMapping("/selProcessHistory")
    public ResponseBase selProcessHistory(@RequestParam("pageSize") Integer pageSize,
                                          @RequestParam("currentPage") Integer currentPage) {
        return fService.selThisProcessHistory(ReqUtils.getUserName(), pageSize, currentPage);
    }


    /**
     * 查看正在审核的流程状态
     *
     * @return
     */
    @GetMapping("/selThisAudit")
    public ResponseBase selThisAudit(@RequestParam("pageSize") Integer pageSize,
                                     @RequestParam("currentPage") Integer currentPage, @RequestParam("strQuery") String strQuery) {
        return fService.selThisAudit(ReqUtils.getUserName(), pageSize, currentPage, strQuery);
    }

    /**
     * 具体角色审核流程
     *
     * @param myTask
     * @return
     */
    @PostMapping("/review")
    public ResponseBase review(@RequestBody MyTask myTask) {
        return fService.review(ReqUtils.getUserName(), myTask);
    }

    /**
     * 我的审核记录查看
     *
     * @return
     */
    @GetMapping("/getAuditRecord")
    public ResponseBase getAuditRecord(@RequestParam("pageSize") Integer pageSize,
                                       @RequestParam("currentPage") Integer currentPage) {
        return fService.auditRecord(ReqUtils.getUserName(), pageSize, currentPage);
    }

    /**
     * 撤回
     *
     * @return
     */
    @GetMapping("/getBackApply")
    public ResponseBase getBackApply(@RequestParam("tackId") String tackId) {
        return fService.backApply(ReqUtils.getUserName(), tackId);
    }

}

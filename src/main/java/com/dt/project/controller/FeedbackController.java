package com.dt.project.controller;

import com.dt.project.config.ResponseBase;
import com.dt.project.oa.model.Feedback;
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
     * 查看正在审核的流程状态
     *
     * @return
     */
    @GetMapping("/selThisAudit")
    public ResponseBase selThisAudit(@RequestParam("pageSize") Integer pageSize,
                                     @RequestParam("currentPage") Integer currentPage) {
        return fService.selThisAudit(ReqUtils.getUserName(), pageSize, currentPage);
    }
}

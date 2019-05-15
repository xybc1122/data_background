package com.dt.user.controller;

import com.dt.user.config.ResponseBase;
import com.dt.user.oa.model.Feedback;
import com.dt.user.oa.service.FeedbackImplService;
import com.dt.user.utils.ReqUtils;
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
     * 查看自己的流程状态
     *
     * @return
     */
    @GetMapping("/selProcess")
    public ResponseBase selProcess(@RequestParam("pageSize") Integer pageSize,
                                   @RequestParam("currentPage") Integer currentPage) {
        if (pageSize == null) {
            pageSize = 0;
        }
        if (currentPage == null) {
            currentPage = 5;
        }
        return fService.selThisProcess(ReqUtils.getUserName(), pageSize, currentPage);
    }
}

package com.dt.project.oa.controller;

import com.dt.project.config.ResponseBase;
import com.dt.project.oa.service.ActivitiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName OrderProcessController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/29 15:00
 **/
@RestController
@RequestMapping("/api/v1/oPro")
public class OrderProcessController {
    @Autowired
    private ActivitiService activitiService;

    /**
     * 查看自己正在申请的流程状态
     *
     * @return
     */
    @GetMapping("/selOrderProcess")
    //@RequestParam("pageSize") Integer pageSize,
    //  @RequestParam("currentPage") Integer currentPage
    public ResponseBase selOrderProcess() {
        return activitiService.selThisProcess();
    }

    /**
     * 查看正在审核的流程状态
     *
     * @return
     */
    @GetMapping("/selThisAudit")
    public ResponseBase selThisAudit() {
        return activitiService.selThisAudit();
    }


}

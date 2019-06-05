package com.dt.project.oa.controller;

import com.dt.project.config.ResponseBase;
import com.dt.project.oa.service.ActivitiService;
import com.dt.project.utils.ReqUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName OrderProcessController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/29 15:00
 **/
@RestController
@RequestMapping("/api/v1/act")
public class ActivitiController {

    @Autowired
    private ActivitiService activitiService;

    private final static String PURCHASE_ORDER_KEY = "purchaseOrder";

    /**
     * 开启流程实例
     */
    @PostMapping("/startProcess")
    public ResponseBase startProcess(@RequestBody Map<String, Object> objectMap) {
        return activitiService.startProcess(PURCHASE_ORDER_KEY, ReqUtils.getUserName(), objectMap);
    }

    /**
     * 查看角色组的流程实例
     *
     * @return
     */
    @GetMapping("/selThisGroup")
    public ResponseBase selThisGroup() {
        return activitiService.selThisGroupProcess();
    }

    /**
     * 查看自己的流程
     *
     * @return
     */
    @GetMapping("/selTaskAssignee")
    public ResponseBase selTaskAssignee() {
        return activitiService.selTaskAssignee(ReqUtils.getUserName());
    }

    /**
     * 完成
     *
     * @return
     */
    @PostMapping("/complete")
    public ResponseBase complete(@RequestBody Map<String, Object> objectMap) {
        return activitiService.complete(objectMap);
    }

    /**
     * 签收流程
     *
     * @return
     */
    @GetMapping("/claim")
    public ResponseBase claim(@RequestParam("taskId") String taskId) {
        return activitiService.claim(taskId);
    }

    /**
     * 取消签收
     *
     * @return
     */
    @GetMapping("/unclaim")
    public ResponseBase unclaim(@RequestParam("taskId") String taskId) {
        return activitiService.unclaim(taskId);
    }

    /**
     * 查看当前流程执行状态
     *
     * @return
     */
//    @GetMapping("/selThisGroup")
//    public ResponseBase () {
//        return activitiService.selThisGroupProcess();
//    }
}

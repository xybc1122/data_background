package com.dt.user.oa.impl;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.oa.model.Feedback;
import com.dt.user.oa.service.FeedbackImplService;
import com.dt.user.utils.MD5Util;
import com.dt.user.utils.PageInfoUtils;
import com.dt.user.utils.ReqUtils;
import com.dt.user.utils.UuIDUtils;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;

import java.util.*;

/**
 * @ClassName ProAppFormImplServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/15 15:57
 **/
@Service
public class FeedbackImplServiceImpl implements FeedbackImplService {
    /**
     * 执行管理，包括启动、推进、删除流程实例等操作
     */
    @Autowired
    private RuntimeService runtimeService;
    /**
     * 组织机构管理
     */
    @Autowired
    private IdentityService identityService;
    /**
     * 任务管理
     */
    @Autowired
    private TaskService taskService;
    /**
     * 历史管理(执行完的数据的管理)
     */
    @Autowired
    private HistoryService historyService;

    private static final String FEEDBACK_KEY = "feedbackProcess";

    @Override
    public ResponseBase startProcess(Feedback feedback) {
        identityService.setAuthenticatedUserId(ReqUtils.getUserName());
        // 开始流程
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(FEEDBACK_KEY);

        // 查询当前任务
        Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        // 填写反馈单任务
        taskService.claim(task.getId(), ReqUtils.getUserName());

        Map<String, Object> feedbackMap = new HashMap<>();
        feedbackMap.put("applyUser", ReqUtils.getUserName());
        feedbackMap.put("imageUrl", feedback.getImageUrl());
        feedbackMap.put("reason", feedback.getReason());
        feedbackMap.put("mName", feedback.getmName());
        feedbackMap.put("uuidNumber", UuIDUtils.uuId());
        //完成任务
        taskService.complete(task.getId(), feedbackMap);
        return JsonData.setResultSuccess("发起流程成功");
    }

    @Override
    public ResponseBase selThisProcess(String userName, Integer pageSize, Integer currentPage) {
        //通过userId查看我的个人任务
        List<ProcessInstance> instanceList = runtimeService.createProcessInstanceQuery().startedBy(userName).
                listPage(pageSize, currentPage);
        List<Feedback> feeList = new ArrayList<>();
        for (ProcessInstance instance : instanceList) {
            Feedback fee = getFee(instance);
            feeList.add(fee);
        }
        return JsonData.setResultSuccess("success", feeList);
    }

    private Feedback getFee(ProcessInstance instance) {
        String imageUrl = runtimeService.getVariable(instance.getId(), "imageUrl", String.class);
        String reason = runtimeService.getVariable(instance.getId(), "reason", String.class);
        String mName = runtimeService.getVariable(instance.getId(), "mName", String.class);
        String uuidNumber = runtimeService.getVariable(instance.getId(), "uuidNumber", String.class);
        Feedback feedback = new Feedback();
        feedback.setApplyUser(instance.getStartUserId());
        feedback.setImageUrl(imageUrl);
        feedback.setReason(reason);
        // activiti 6 才有
        Date startTime = instance.getStartTime();
        feedback.setApplyTime(startTime);
        feedback.setmName(mName);
        feedback.setUuidNumber(uuidNumber);
        feedback.setApplyStatus(instance.isEnded() ? "申请结束" : "等待审批");
        return feedback;
    }

}

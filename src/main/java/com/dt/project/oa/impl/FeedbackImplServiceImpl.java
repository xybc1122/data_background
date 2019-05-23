package com.dt.project.oa.impl;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.oa.model.Auditor;
import com.dt.project.oa.model.MyTask;
import com.dt.project.oa.model.Feedback;
import com.dt.project.oa.service.FeedbackImplService;
import com.dt.project.utils.ActivitiUtil;
import com.dt.project.utils.PageBean;
import com.dt.project.utils.ReqUtils;
import com.dt.project.utils.UuIDUtils;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
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

    /**
     * 开始 反馈流程
     *
     * @param feedback
     * @return
     */
    @Override
    public ResponseBase startProcess(Feedback feedback) {

        if (StringUtils.isBlank(feedback.getmName())) {
            return JsonData.setResultError("发起流程失败");
        }
        identityService.setAuthenticatedUserId(ReqUtils.getUserName());
        // 开始流程
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(FEEDBACK_KEY);

        // 查询当前任务
        Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();

        // 签收任务
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

    /**
     * 查看自己反馈流程的信息
     *
     * @param userName
     * @param pageSize
     * @param pageSize
     * @return
     */
    @Override
    public ResponseBase selThisProcess(String userName, Integer pageSize, Integer page) {
        //获得总行数
        long total = runtimeService.createProcessInstanceQuery().startedBy(userName).count();
        //总页数
        long totalPage = PageBean.getPageCount(pageSize, total);
        //获得当前页
        int currentPage = PageBean.currentPage(page);
        //当前页开始记录
        int offset = PageBean.countOffset(pageSize, currentPage);
        //通过userId查看我的个人任务
        List<ProcessInstance> instanceList = runtimeService.createProcessInstanceQuery().startedBy(userName).
                listPage(offset, PageBean.setPSize(pageSize));
        List<Feedback> feeList = new ArrayList<>();
        for (ProcessInstance instance : instanceList) {
            Feedback fee = getFee(instance);
            feeList.add(fee);
        }
        return JsonData.setResultSuccess("success", new PageBean<>(feeList, currentPage, pageSize, total, totalPage));
    }

    @Override
    public ResponseBase selThisProcessHistory(String userName, Integer pageSize, Integer page) {
        //获得总行数
        long total = historyService.createHistoricProcessInstanceQuery().
                processDefinitionKey(FEEDBACK_KEY).startedBy(userName).finished()
                .orderByProcessInstanceEndTime().desc().count();
        //总页数
        long totalPage = PageBean.getPageCount(pageSize, total);
        //获得当前页
        int currentPage = PageBean.currentPage(page);
        //当前页开始记录
        int offset = PageBean.countOffset(pageSize, currentPage);
        List<HistoricProcessInstance> hisProInstance = historyService.createHistoricProcessInstanceQuery()
                .processDefinitionKey(FEEDBACK_KEY).startedBy(userName).finished()
                .orderByProcessInstanceEndTime().desc().listPage(offset, PageBean.setPSize(pageSize));
        List<Feedback> feeList = new ArrayList<>();
        for (HistoricProcessInstance hisInstance : hisProInstance) {
            Feedback feedback = new Feedback();
            feedback.setApplyUser(hisInstance.getStartUserId());
            feedback.setApplyTime(hisInstance.getStartTime());
            feedback.setApplyStatus("申请结束");
            List<HistoricVariableInstance> varInstanceList = historyService.createHistoricVariableInstanceQuery()
                    .processInstanceId(hisInstance.getId()).list();
            feedback.setAuditor(ActivitiUtil.setVars(feedback, varInstanceList));
            feeList.add(feedback);
        }
        return JsonData.setResultSuccess("success", new PageBean<>(feeList, currentPage, pageSize, total, totalPage));
    }


    /**
     * 查询自己审批的流程
     *
     * @param userName
     * @param pageSize
     * @param page
     * @return
     */
    @Override
    public ResponseBase selThisAudit(String userName, Integer pageSize, Integer page, String uuidNumber) {
        //获得当前页
        int currentPage = PageBean.currentPage(page);
        //当前页开始记录
        int offset = PageBean.countOffset(pageSize, currentPage);
        long total;
        List<Task> taskList;
        if (StringUtils.isBlank(uuidNumber)) {
            total = taskService.createTaskQuery().taskCandidateUser(userName).count();
            //根据用户查询任务
            taskList = taskService.createTaskQuery().taskCandidateUser(userName)
                    .orderByTaskCreateTime().desc().listPage(offset, pageSize);
        } else {
            //获得总行数
            total = taskService.createTaskQuery().taskCandidateUser(userName).
                    processVariableValueEquals(uuidNumber).count();
            //根据用户查询任务
            taskList = taskService.createTaskQuery().taskCandidateUser(userName)
                    .orderByTaskCreateTime().desc().processVariableValueEquals(uuidNumber).listPage(offset, pageSize);
        }
        //总页数
        long totalPage = PageBean.getPageCount(pageSize, total);
        List<MyTask> feeTaskList = new ArrayList<>();
        for (Task task : taskList) {
            MyTask feeTask = new MyTask(task.getId(), task.getName(), task.getCreateTime());
            String instanceId = task.getProcessInstanceId();
            ProcessInstance instance = runtimeService.createProcessInstanceQuery().processInstanceId(instanceId).singleResult();
            feeTask.setFeedback(getFee(instance));
            feeTaskList.add(feeTask);
        }
        return JsonData.setResultSuccess("success", new PageBean<>(feeTaskList, currentPage, pageSize, total, totalPage));
    }

    @Override
    public ResponseBase review(String userName, MyTask myTask) {
        String taskId = myTask.getTid();
        String result = myTask.getAuditor().getResult();
        String auditNote = myTask.getAuditor().getAuditNote();
        Map<String, Object> auditorMap = new HashMap<>();
        auditorMap.put("result", result);
        auditorMap.put("auditorName", userName);
        auditorMap.put("auditNote", auditNote);
        auditorMap.put("auditTime", new Date());
        //签收任务
        taskService.claim(taskId, userName);
        //完成流程
        taskService.complete(taskId, auditorMap);
        return JsonData.setResultSuccess("success");
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

package com.dt.project.oa.impl;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.exception.LsException;
import com.dt.project.oa.model.MyTask;
import com.dt.project.oa.model.Feedback;
import com.dt.project.oa.service.FeedbackImplService;
import com.dt.project.utils.ActivitiUtil;
import com.dt.project.utils.PageBean;
import com.dt.project.utils.ReqUtils;
import com.dt.project.utils.UuIDUtils;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.identity.Group;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private ActivitiServiceImpl activitiService;

    /**
     * 开始 反馈流程
     *
     * @param feedback
     * @return
     */
    @Override
    @Transactional
    public ResponseBase startProcess(Feedback feedback) {
        if (StringUtils.isBlank(feedback.getmName())) {
            return JsonData.setResultError("发起流程失败");
        }
        try {
            ProcessInstance processInstance = activitiService.startProcess(FEEDBACK_KEY, ReqUtils.getUserName());
            Map<String, Object> feedbackMap = new HashMap<>();
            feedbackMap.put("applyUser", ReqUtils.getUserName());
            feedbackMap.put("imageUrl", feedback.getImageUrl());
            feedbackMap.put("reason", feedback.getReason());
            feedbackMap.put("mName", feedback.getmName());
            feedbackMap.put("uuidNumber", UuIDUtils.uuId());
            //流程状态
            feedbackMap.put("status", 1);
            Task task = activitiService.getTask(processInstance.getId());
            /**
             * 签收
             */
            activitiService.t().claim(task.getId(), ReqUtils.getUserName());
            //完成任务
            activitiService.t().complete(task.getId(), feedbackMap);
            return JsonData.setResultSuccess("发起流程成功");
        } catch (Exception e) {
            throw new LsException("发起流程失败");
        }
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
        List<ProcessInstance> processInstances = runtimeService.createProcessInstanceQuery().startedBy(userName).
                listPage(offset, pageSize);

        List<Feedback> feeList = new ArrayList<>();
        for (ProcessInstance instance : processInstances) {
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
                .orderByProcessInstanceEndTime().desc().listPage(offset, pageSize);
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
    public ResponseBase selThisAudit(String userName, Integer pageSize, Integer page, String strQuery) {
        //获得当前页
        int currentPage = PageBean.currentPage(page);
        //当前页开始记录
        int offset = PageBean.countOffset(pageSize, currentPage);
        long total;
        long totalPage;
        List<Task> taskList;
        //这里暂时先这样写
        if (StringUtils.isBlank(strQuery)) {
            total = activitiService.t().createTaskQuery().taskCandidateUser(userName).count();
            //根据用户查询任务
            //总页数
            totalPage = PageBean.getPageCount(pageSize, total);
            taskList = activitiService.t().createTaskQuery().taskCandidateUser(userName)
                    .orderByTaskCreateTime().desc().listPage(offset, pageSize);
        } else {
            //获得总行数
            total = activitiService.t().createTaskQuery().taskCandidateUser(userName).
                    processVariableValueEquals(strQuery).count();
            //根据用户查询任务
            totalPage = PageBean.getPageCount(pageSize, total);
            taskList = activitiService.t().createTaskQuery().taskCandidateUser(userName)
                    .orderByTaskCreateTime().desc().processVariableValueEquals(strQuery).listPage(offset, pageSize);
        }

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
    @Transactional
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
        activitiService.t().claim(taskId, userName);
        //完成流程
        activitiService.t().complete(taskId, auditorMap);
        return JsonData.setResultSuccess("success");
    }

    @Override
    public ResponseBase auditRecord(String userName, Integer pageSize, Integer page) {
        //获得当前页
        int currentPage = PageBean.currentPage(page);
        //当前页开始记录
        int offset = PageBean.countOffset(pageSize, currentPage);
        long total = historyService.createHistoricProcessInstanceQuery()
                .processDefinitionKey(FEEDBACK_KEY).involvedUser(userName).finished()
                .orderByProcessInstanceEndTime().desc().count();
        //总页数
        long totalPage = PageBean.getPageCount(pageSize, total);
        List<HistoricProcessInstance> hisProInstance = historyService.createHistoricProcessInstanceQuery()
                .processDefinitionKey(FEEDBACK_KEY).involvedUser(userName).finished()
                .orderByProcessInstanceEndTime().desc().listPage(offset, pageSize);

        //通过user 名去查找角色组信息
        List<Group> groups = activitiService.identity().createGroupQuery().groupMember(userName).list();
        List<String> auditTaskNameList = new ArrayList<>();
        for (Group g : groups) {
            auditTaskNameList.add(g.getName());
        }
        List<Feedback> feeList = new ArrayList<>();
        for (HistoricProcessInstance hisInstance : hisProInstance) {
            List<HistoricTaskInstance> hisTaskInstanceList = historyService.createHistoricTaskInstanceQuery()
                    .processInstanceId(hisInstance.getId()).processFinished()
                    .taskAssignee(userName)
                    .taskNameIn(auditTaskNameList)
                    .orderByHistoricTaskInstanceEndTime().desc().list();
            boolean isMyAudit = false;
            for (HistoricTaskInstance taskInstance : hisTaskInstanceList) {
                if (taskInstance.getAssignee().equals(userName)) {
                    isMyAudit = true;
                }
            }
            if (!isMyAudit) {
                continue;
            }
            Feedback feedback = new Feedback();
            feedback.setApplyUser(hisInstance.getStartUserId());
            feedback.setApplyStatus("申请结束");
            feedback.setApplyTime(hisInstance.getStartTime());
            List<HistoricVariableInstance> varInstanceList = historyService.createHistoricVariableInstanceQuery()
                    .processInstanceId(hisInstance.getId()).list();
            feedback.setAuditor(ActivitiUtil.setVars(feedback, varInstanceList));
            feeList.add(feedback);
        }
        return JsonData.setResultSuccess("success", new PageBean<>(feeList, currentPage, pageSize, total, totalPage));
    }

    @Override
    public ResponseBase backApply(String userName, String taskId) {
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

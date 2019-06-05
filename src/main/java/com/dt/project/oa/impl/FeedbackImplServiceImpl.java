package com.dt.project.oa.impl;

import com.dt.project.oa.service.FlowableService;
import com.dt.project.oa.service.FeedbackImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName ProAppFormImplServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/15 15:57
 **/
@Service
public class FeedbackImplServiceImpl{


    private static final String FEEDBACK_KEY = "feedbackProcess";

    @Autowired
    private FlowableService activitiService;

//    /**
//     * 开始 反馈流程
//     *
//     * @param feedback
//     * @return
//     */
//    @Override
//    @Transactional
//    public ResponseBase startProcess(Feedback feedback) {
//        System.out.println(activitiService.get());
//        if (StringUtils.isBlank(feedback.getmName())) {
//            return JsonData.setResultError("发起流程失败");
//        }
//        try {
//            Map<String, Object> feedbackMap = new HashMap<>();
//            feedbackMap.put("applyUser", ReqUtils.getUserName());
//            feedbackMap.put("imageUrl", feedback.getImageUrl());
//            feedbackMap.put("reason", feedback.getReason());
//            feedbackMap.put("mName", feedback.getmName());
//            feedbackMap.put("uuidNumber", UuIDUtils.uuId());
//            //流程状态
//            feedbackMap.put("status", 1);
//            return activitiService.startProcess(FEEDBACK_KEY, ReqUtils.getUserName(), feedbackMap);
//        } catch (Exception e) {
//            throw new LsException("发起流程失败");
//        }
//    }

//    /**
//     * 查看自己反馈流程的信息
//     *
//     * @param userName
//     * @param pageSize
//     * @param pageSize
//     * @return
//     */
//    @Override
//    public ResponseBase selThisProcess(String userName, Integer pageSize, Integer page) {
//        //获得总行数
//        long total = activitiService.get()
//                .getRuntimeService()
//                .createProcessInstanceQuery()
//                .startedBy(userName)
//                .count();
//        //总页数
//        long totalPage = PageBean.getPageCount(pageSize, total);
//        //获得当前页
//        int currentPage = PageBean.currentPage(page);
//        //当前页开始记录
//        int offset = PageBean.countOffset(pageSize, currentPage);
//
//        //通过userId查看我的个人任务
//        List<ProcessInstance> processInstances = activitiService.get()
//                .getRuntimeService()
//                .createProcessInstanceQuery()
//                .startedBy(userName)
//                .listPage(offset, pageSize);
//
//        List<Feedback> feeList = new ArrayList<>();
//        for (ProcessInstance instance : processInstances) {
//            Feedback fee = getFee(instance);
//            feeList.add(fee);
//        }
//        return JsonData.setResultSuccess("success", new PageBean<>(feeList, currentPage, pageSize, total, totalPage));
//    }

//    @Override
//    public ResponseBase selThisProcessHistory(String userName, Integer pageSize, Integer page) {
//        //获得总行数
//        long total = activitiService.get().getHistoryService()
//                .createHistoricProcessInstanceQuery()
//                .processDefinitionKey(FEEDBACK_KEY)
//                .startedBy(userName).finished()
//                .orderByProcessInstanceEndTime()
//                .desc()
//                .count();
//        //总页数
//        long totalPage = PageBean.getPageCount(pageSize, total);
//        //获得当前页
//        int currentPage = PageBean.currentPage(page);
//        //当前页开始记录
//        int offset = PageBean.countOffset(pageSize, currentPage);
//        List<HistoricProcessInstance> hisProInstance = activitiService.get()
//                .getHistoryService()
//                .createHistoricProcessInstanceQuery()
//                .processDefinitionKey(FEEDBACK_KEY)
//                .startedBy(userName).finished()
//                .orderByProcessInstanceEndTime()
//                .desc()
//                .listPage(offset, pageSize);
//        List<Feedback> feeList = new ArrayList<>();
//        for (HistoricProcessInstance hisInstance : hisProInstance) {
//            Feedback feedback = new Feedback();
//            feedback.setApplyUser(hisInstance.getStartUserId());
//            feedback.setApplyTime(hisInstance.getStartTime());
//            feedback.setApplyStatus("申请结束");
//            List<HistoricVariableInstance> varInstanceList = activitiService.get()
//                    .getHistoryService().createHistoricVariableInstanceQuery()
//                    .processInstanceId(hisInstance.getId()).list();
//            feedback.setAuditor(ActivitiUtil.setVars(feedback, varInstanceList));
//            feeList.add(feedback);
//        }
//        return JsonData.setResultSuccess("success", new PageBean<>(feeList, currentPage, pageSize, total, totalPage));
//    }


//    /**
//     * 查询自己审批的流程
//     *
//     * @param userName
//     * @param pageSize
//     * @param page
//     * @return
//     */
//    @Override
//    public ResponseBase selThisAudit(String userName, Integer pageSize, Integer page, String strQuery) {
//        //获得当前页
//        int currentPage = PageBean.currentPage(page);
//        //当前页开始记录
//        int offset = PageBean.countOffset(pageSize, currentPage);
//        long total;
//        long totalPage;
//        List<Task> taskList;
//        //这里暂时先这样写
//        if (StringUtils.isBlank(strQuery)) {
//            total = activitiService.get().getTaskService().createTaskQuery().taskCandidateUser(userName).count();
//            //根据用户查询任务
//            //总页数
//            totalPage = PageBean.getPageCount(pageSize, total);
//            taskList = activitiService.get().getTaskService().createTaskQuery().taskCandidateUser(userName)
//                    .orderByTaskCreateTime().desc().listPage(offset, pageSize);
//        } else {
//            //获得总行数
//            total = activitiService.get().getTaskService().createTaskQuery().taskCandidateUser(userName).
//                    processVariableValueEquals(strQuery).count();
//            //根据用户查询任务
//            totalPage = PageBean.getPageCount(pageSize, total);
//            taskList = activitiService.get().getTaskService().createTaskQuery().taskCandidateUser(userName)
//                    .orderByTaskCreateTime().desc().processVariableValueEquals(strQuery).listPage(offset, pageSize);
//        }
//
//        List<MyTask> feeTaskList = new ArrayList<>();
//        for (Task task : taskList) {
//            MyTask feeTask = new MyTask(task.getId(), task.getName(), task.getCreateTime());
//            String instanceId = task.getProcessInstanceId();
//            ProcessInstance instance = activitiService.get().getRuntimeService().createProcessInstanceQuery().processInstanceId(instanceId).singleResult();
//            feeTask.setFeedback(getFee(instance));
//            feeTaskList.add(feeTask);
//        }
//        return JsonData.setResultSuccess("success", new PageBean<>(feeTaskList, currentPage, pageSize, total, totalPage));
//    }

//    @Override
//    @Transactional
//    public ResponseBase review(String userName, MyTask myTask) {
//        String taskId = myTask.getTid();
//        String result = myTask.getAuditor().getResult();
//        String auditNote = myTask.getAuditor().getAuditNote();
//        Map<String, Object> auditorMap = new HashMap<>();
//        auditorMap.put("result", result);
//        auditorMap.put("auditorName", userName);
//        auditorMap.put("auditNote", auditNote);
//        auditorMap.put("auditTime", new Date());
//        //签收任务
//        activitiService.get().getTaskService().claim(taskId, userName);
//        //完成流程
//        activitiService.get().getTaskService().complete(taskId, auditorMap);
//        return JsonData.setResultSuccess("success");
//    }
//
//    @Override
//    public ResponseBase auditRecord(String userName, Integer pageSize, Integer page) {
//        //获得当前页
//        int currentPage = PageBean.currentPage(page);
//        //当前页开始记录
//        int offset = PageBean.countOffset(pageSize, currentPage);
//        long total = activitiService.get().getHistoryService().createHistoricProcessInstanceQuery()
//                .processDefinitionKey(FEEDBACK_KEY).involvedUser(userName).finished()
//                .orderByProcessInstanceEndTime().desc().count();
//        //总页数
//        long totalPage = PageBean.getPageCount(pageSize, total);
//        List<HistoricProcessInstance> hisProInstance = activitiService.get().getHistoryService().createHistoricProcessInstanceQuery()
//                .processDefinitionKey(FEEDBACK_KEY).involvedUser(userName).finished()
//                .orderByProcessInstanceEndTime().desc().listPage(offset, pageSize);
//
//        //通过user 名去查找角色组信息
//        List<Group> groups = activitiService.get().getIdentityService().
//                createGroupQuery().groupMember(userName).list();
//        List<String> auditTaskNameList = new ArrayList<>();
//        for (Group g : groups) {
//            auditTaskNameList.add(g.getName());
//        }
//        List<Feedback> feeList = new ArrayList<>();
//        for (HistoricProcessInstance hisInstance : hisProInstance) {
//            List<HistoricTaskInstance> hisTaskInstanceList = activitiService.get().getHistoryService()
//                    .createHistoricTaskInstanceQuery()
//                    .processInstanceId(hisInstance.getId()).processFinished()
//                    .taskAssignee(userName)
//                    .taskNameIn(auditTaskNameList)
//                    .orderByHistoricTaskInstanceEndTime().desc().list();
//            boolean isMyAudit = false;
//            for (HistoricTaskInstance taskInstance : hisTaskInstanceList) {
//                if (taskInstance.getAssignee().equals(userName)) {
//                    isMyAudit = true;
//                }
//            }
//            if (!isMyAudit) {
//                continue;
//            }
//            Feedback feedback = new Feedback();
//            feedback.setApplyUser(hisInstance.getStartUserId());
//            feedback.setApplyStatus("申请结束");
//            feedback.setApplyTime(hisInstance.getStartTime());
//            List<HistoricVariableInstance> varInstanceList = activitiService.get().getHistoryService().createHistoricVariableInstanceQuery()
//                    .processInstanceId(hisInstance.getId()).list();
//            feedback.setAuditor(ActivitiUtil.setVars(feedback, varInstanceList));
//            feeList.add(feedback);
//        }
//        return JsonData.setResultSuccess("success", new PageBean<>(feeList, currentPage, pageSize, total, totalPage));
//    }

//    @Override
//    public ResponseBase backApply(String userName, String taskId) {
//        return JsonData.setResultSuccess("success");
//    }
//

//    private Feedback getFee(ProcessInstance instance) {
//        String imageUrl = activitiService.get().getRuntimeService().getVariable(instance.getId(), "imageUrl", String.class);
//        String reason = activitiService.get().getRuntimeService().getVariable(instance.getId(), "reason", String.class);
//        String mName = activitiService.get().getRuntimeService().getVariable(instance.getId(), "mName", String.class);
//        String uuidNumber = activitiService.get().getRuntimeService().getVariable(instance.getId(), "uuidNumber", String.class);
//        Feedback feedback = new Feedback();
//        feedback.setApplyUser(instance.getStartUserId());
//        feedback.setImageUrl(imageUrl);
//        feedback.setReason(reason);
//        // activiti 6 才有
//        Date startTime = instance.getStartTime();
//        feedback.setApplyTime(startTime);
//        feedback.setmName(mName);
//        feedback.setUuidNumber(uuidNumber);
//        feedback.setApplyStatus(instance.isEnded() ? "申请结束" : "等待审批");
//        return feedback;
//    }

}

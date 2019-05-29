package com.dt.project.oa.impl;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.oa.service.ActivitiService;
import com.dt.project.utils.ReqUtils;
import com.dt.project.utils.UuIDUtils;
import org.activiti.engine.*;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

/**
 * @ClassName activitiServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/24 13:05
 **/
@Service
public class ActivitiServiceImpl implements ActivitiService {
//    /**
//     * 操作流程定义
//     */
//    @Autowired
//    RepositoryService repositoryService;
//    /**
//     * 操作流程实例
//     */
//    @Autowired
//    RuntimeService runtimeService;
//    /**
//     * 操作任务管理
//     */
//    @Autowired
//    private TaskService taskService;
//    /**
//     * 操作用户或组
//     */
//    @Autowired
//    private IdentityService identityService;


    @Autowired
    private ProcessEngine processEngine;


    @Override
    public ProcessEngine get() {
        return processEngine;
    }

    /**
     * 发布规则文件
     *
     * @param fileInputStream 文件流
     * @param fileName        文件名称
     * @return
     */
    @Override
    public ResponseBase deploy(InputStream fileInputStream, String fileName) {
        ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
        //使用deploy方法发布流程
        get().getRepositoryService().createDeployment()
                .addZipInputStream(zipInputStream)
                .name(fileName)
                .deploy();
        return JsonData.setResultSuccess("success");
    }


    @Override
    public ResponseBase startProcess(String instanceKey, String uName, Map<String, Object> objectMap) {
        get().getIdentityService().setAuthenticatedUserId(uName);
        ProcessInstance processInstance = get().getRuntimeService().startProcessInstanceByKey(instanceKey);
        Task task = get()
                .getTaskService()
                .createTaskQuery()
                .processInstanceId(processInstance.getId())
                .singleResult();
        get().getTaskService().claim(task.getId(), ReqUtils.getUserName());
        objectMap.put("applyUser", ReqUtils.getUserName());
        objectMap.put("uuidNumber", UuIDUtils.uuId());
        //完成任务
        get().getTaskService().complete(task.getId(), objectMap);
        return JsonData.setResultSuccess("发起流程成功");
    }

    @Override
    public ResponseBase selThisProcess() {
        //通过userId查看我的个人任务
        List<ProcessInstance> processInstances = get()
                .getRuntimeService()
                .createProcessInstanceQuery().list();
        List<Map<String, Object>> mapList = new ArrayList<>();
        for (ProcessInstance instance : processInstances) {
            Map<String, Object> variables = get().getRuntimeService().getVariables(instance.getId());
            variables.put("ApplyStatus", instance.isEnded() ? "申请结束" : "等待审批");
            mapList.add(variables);
        }
        return JsonData.setResultSuccess(mapList);
    }

    @Override
    public ResponseBase selThisAudit() {
        List<Task> taskList = get().getTaskService().createTaskQuery().taskCandidateUser(ReqUtils.getUserName())
                .orderByTaskCreateTime().desc().list();
        List<Map<String, Object>> mapList = new ArrayList<>();
        for (Task task : taskList) {
            String instanceId = task.getProcessInstanceId();
            ProcessInstance instance = get().getRuntimeService().
                    createProcessInstanceQuery().processInstanceId(instanceId).singleResult();
            Map<String, Object> variables = get().getRuntimeService().getVariables(instance.getId());
            variables.put("tkId", task.getId());
            variables.put("tkName", task.getName());
            variables.put("tkCreateTime", task.getCreateTime());
            mapList.add(variables);
        }
        return JsonData.setResultSuccess(mapList);
    }


}

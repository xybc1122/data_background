package com.dt.project.oa.impl;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.oa.service.FlowableService;
import com.dt.project.utils.ReqUtils;
import org.flowable.common.engine.impl.identity.Authentication;
import org.flowable.engine.IdentityService;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.idm.api.Group;
import org.flowable.task.api.Task;
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
public class FlowableServiceImpl implements FlowableService {
    /**
     * 操作流程定义
     */
    @Autowired
    private RepositoryService repositoryService;
    /**
     * 操作流程实例
     */
    @Autowired
    private RuntimeService runtimeService;
    /**
     * 操作任务管理
     */
    @Autowired
    private TaskService taskService;
    /**
     * 操作用户或组
     */
    @Autowired
    private IdentityService identityService;


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
        repositoryService.createDeployment()
                .addZipInputStream(zipInputStream)
                .name(fileName)
                .deploy();
        return JsonData.setResultSuccess("success");
    }


    @Override
    public ResponseBase startProcess(String instanceKey, String uName, Map<String, Object> objectMap) {
        //流程发起人
        Authentication.setAuthenticatedUserId(uName);
        objectMap.put("applyUser", ReqUtils.getUserName());
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(instanceKey, objectMap);
        Authentication.setAuthenticatedUserId(null);
        return JsonData.setResultSuccess("发起流程成功", processInstance.getId());
    }

//    @Override
//    public ResponseBase selThisProcess() {
//        //通过userId查看我的个人任务
//        List<ProcessInstance> processInstances = get()
//                .getRuntimeService()
//                .createProcessInstanceQuery().list();
//        List<Map<String, Object>> mapList = new ArrayList<>();
//        for (ProcessInstance instance : processInstances) {
//            Map<String, Object> variables = get().getRuntimeService().getVariables(instance.getId());
//            variables.put("ApplyStatus", instance.isEnded() ? "申请结束" : "等待审批");
//            mapList.add(variables);
//        }
//        return JsonData.setResultSuccess(mapList);
//    }


    @Override
    public ResponseBase selThisGroupProcess() {
        List<Task> tasks = taskListGroup(ReqUtils.getUserName());
        List<Map<String, Object>> mapList = new ArrayList<>();
        for (Task task : tasks) {
            mapList.add(getVariables(task));
        }
        return JsonData.setResultSuccess(mapList);
    }

    @Override
    public ResponseBase claim(String taskId) {
        taskService.claim(taskId, ReqUtils.getUserName());
        return JsonData.setResultSuccess("签收成功");
    }

    @Override
    public ResponseBase selTaskAssignee(String uName) {
        List<Task> tasks = taskListAssignee(uName);
        List<Map<String, Object>> mapList = new ArrayList<>();
        for (Task task : tasks) {
            mapList.add(getVariables(task));
        }
        return JsonData.setResultSuccess(mapList);
    }

    /**
     * 完成流程
     *
     * @param objectMap
     * @return
     */
    @Override
    public ResponseBase complete(Map<String, Object> objectMap) {
        String taskId = (String) objectMap.get("taskId");
        taskService.complete(taskId, objectMap);
        return JsonData.setResultSuccess("success");
    }

    @Override
    public ResponseBase unclaim(String taskId) {
        taskService.unclaim(taskId);
        return JsonData.setResultSuccess("success");
    }

    /**
     * 通过 账号 查询 对应的角色组
     *
     * @param uName
     * @return
     */
    public List<String> getGroups(String uName) {
        List<Group> groups = identityService.
                createGroupQuery().groupMember(uName).list();
        System.out.println(groups);
        List<String> candidateGroups = new ArrayList<>();
        for (Group g : groups) {
            candidateGroups.add(g.getName());
        }
        return candidateGroups;
    }

    /**
     * 查询 taskGroup实例
     *
     * @param uName
     * @return
     */
    public List<Task> taskListGroup(String uName) {
        return taskService
                .createTaskQuery()
                .taskCandidateGroupIn(getGroups(uName))
                .list();
    }

    /**
     * 查询 taskAssignee实例
     *
     * @param uName
     * @return
     */
    public List<Task> taskListAssignee(String uName) {
        return taskService
                .createTaskQuery()
                .taskAssignee(uName)
                .list();
    }

    /**
     * 通过task拿数据
     *
     * @param task
     * @return
     */
    public Map<String, Object> getVariables(Task task) {
        Map<String, Object> variables = runtimeService.getVariables(task.getProcessInstanceId());
        variables.put("tkId", task.getId());
        variables.put("tkName", task.getName());
        variables.put("tkCreateTime", task.getCreateTime());
        return variables;
    }

}

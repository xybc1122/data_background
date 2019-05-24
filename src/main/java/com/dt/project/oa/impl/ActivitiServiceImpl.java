package com.dt.project.oa.impl;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.oa.service.ActivitiService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
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

    @Autowired
    RepositoryService repositoryService;

    @Autowired
    RuntimeService runtimeService;
    /**
     * 任务管理
     */
    @Autowired
    private TaskService taskService;
    /**
     * 组织机构管理
     */
    @Autowired
    private IdentityService identityService;

    /**
     * 返回 IdentityService
     *
     * @return
     */
    public IdentityService identity() {
        return identityService;
    }

    /**
     * 返回 TaskService
     *
     * @return
     */
    public TaskService t() {
        return taskService;
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
        repositoryService.createDeployment()
                .addZipInputStream(zipInputStream)
                .name(fileName)
                .deploy();
        return JsonData.setResultSuccess("success");
    }

    @Override
    public ProcessInstance startProcess(String instanceKey, String uName) {
        identityService.setAuthenticatedUserId(uName);
        return runtimeService.startProcessInstanceByKey(instanceKey);
    }


    public Task getTask(String proId) {
        return t().createTaskQuery().processInstanceId(proId).singleResult();

    }
}

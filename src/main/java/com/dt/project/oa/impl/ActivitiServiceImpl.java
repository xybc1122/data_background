package com.dt.project.oa.impl;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.oa.service.ActivitiService;
import org.activiti.engine.*;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
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
    public ProcessInstance startProcess(String instanceKey, String uName) {
        get().getIdentityService().setAuthenticatedUserId(uName);
        return get().getRuntimeService().startProcessInstanceByKey(instanceKey);
    }



}

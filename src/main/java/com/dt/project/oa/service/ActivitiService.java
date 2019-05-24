package com.dt.project.oa.service;

import com.dt.project.config.ResponseBase;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.io.InputStream;
import java.util.Map;

/**
 * @ClassName ActivitiService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/24 13:04
 **/
public interface ActivitiService {

    /**
     * 发布规则
     *
     * @param fileInputStream 文件流
     * @param fileName        文件名称
     * @return
     */
    ResponseBase deploy(InputStream fileInputStream, String fileName);


    /***
     *  开始流程
     * @param instanceKey 流程实例key
     * @param uName 参数
     */
    ProcessInstance startProcess(String instanceKey, String uName);

}

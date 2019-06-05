package com.dt.project.oa.service;

import com.dt.project.config.ResponseBase;
import org.activiti.engine.ProcessEngine;
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
     * 获得流程引擎
     *
     * @return
     */
    ProcessEngine get();

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
    ResponseBase startProcess(String instanceKey, String uName, Map<String, Object> objectMap);


    /**
     * 查看本组的流程
     *
     * @return
     */
    ResponseBase selThisGroupProcess();


    /**
     * 签收流程
     */
    ResponseBase claim(String taskId);

    /**
     * 通过用户名 获取当前流程
     *
     * @return
     */
    ResponseBase selTaskAssignee(String uName);

    /**
     * 完成流程
     *
     * @return
     */
    ResponseBase complete(Map<String, Object> objectMap);

    /**
     * 取消签收
     */
    ResponseBase unclaim(String taskId);
}

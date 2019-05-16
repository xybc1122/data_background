package com.dt.project.oa.service;

import com.dt.project.config.ResponseBase;
import com.dt.project.oa.model.MyTask;
import com.dt.project.oa.model.Feedback;

/**
 * @ClassName FeedbackImplService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/15 15:57
 **/
public interface FeedbackImplService {

    /**
     * 开始流程
     *
     * @param proAppForm
     * @return
     */
    ResponseBase startProcess(Feedback proAppForm);

    /**
     * 通过自己的用户名字 去查看自己的申请流程
     *
     * @param userName
     * @return
     */
    ResponseBase selThisProcess(String userName, Integer pageSize, Integer currentPage);


    /**
     * 查询待我审核的
     *
     * @param userName
     * @return
     */
    ResponseBase selThisAudit(String userName, Integer pageSize, Integer currentPage);


    /**
     * 审核接口
     *
     * @param userName
     * @return
     */
    ResponseBase review(String userName, MyTask feeTask);
}

package com.dt.user.oa.service;

import com.dt.user.config.ResponseBase;
import com.dt.user.oa.model.Feedback;

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
    ResponseBase selThisProcess(String userName,Integer pageSize, Integer currentPage);
}

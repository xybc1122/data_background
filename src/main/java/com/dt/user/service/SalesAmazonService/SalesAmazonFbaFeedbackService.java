package com.dt.user.service.SalesAmazonService;

import com.dt.user.config.ResponseBase;
import com.dt.user.model.SalesAmazon.SalesAmazonFbaFeedback;

import java.util.List;

/**
 * @ClassName SalesAmazonFbaFeedbackService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/22 16:54
 **/
public interface SalesAmazonFbaFeedbackService {


    /**
     * 查找
     *
     * @param record
     * @return
     */
    List<SalesAmazonFbaFeedback> serviceSelectByFeedback(SalesAmazonFbaFeedback record);

    /**
     * 插入数据
     *
     * @param feedback
     * @return
     */
    ResponseBase serviceInsert(SalesAmazonFbaFeedback feedback);
}

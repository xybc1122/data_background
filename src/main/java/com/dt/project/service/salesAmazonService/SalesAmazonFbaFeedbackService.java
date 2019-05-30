package com.dt.project.service.salesAmazonService;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.salesAmazon.SalesAmazonFbaFeedback;

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

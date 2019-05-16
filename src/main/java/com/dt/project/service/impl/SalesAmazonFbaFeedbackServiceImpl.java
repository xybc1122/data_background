package com.dt.project.service.impl;

import com.dt.project.config.ResponseBase;
import com.dt.project.mapper.SalesAmazonMapper.SalesAmazonFbaFeedbackMapper;
import com.dt.project.model.SalesAmazon.SalesAmazonFbaFeedback;
import com.dt.project.service.SalesAmazonService.SalesAmazonFbaFeedbackService;
import com.dt.project.utils.JsonUtils;
import com.dt.project.utils.ReqUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName SalesAmazonFbaFeedbackServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/22 16:54
 **/
@Service
public class SalesAmazonFbaFeedbackServiceImpl implements SalesAmazonFbaFeedbackService {
    @Autowired
    private SalesAmazonFbaFeedbackMapper backMapper;

    @Override
    public List<SalesAmazonFbaFeedback> serviceSelectByFeedback(SalesAmazonFbaFeedback record) {
        return backMapper.selectByFeedback(record);
    }

    @Override
    public ResponseBase serviceInsert(SalesAmazonFbaFeedback feedback) {
        feedback.setCreateDate(new Date().getTime());
        feedback.setCreateUser(ReqUtils.getUserName());
        int result = backMapper.insertFeedback(feedback);
        return JsonUtils.saveMsg(result);
    }
}

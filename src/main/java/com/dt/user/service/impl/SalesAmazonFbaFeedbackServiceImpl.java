package com.dt.user.service.impl;

import com.dt.user.config.ResponseBase;
import com.dt.user.mapper.SalesAmazonMapper.SalesAmazonFbaFeedbackMapper;
import com.dt.user.model.SalesAmazon.SalesAmazonFbaFeedback;
import com.dt.user.service.SalesAmazonService.SalesAmazonFbaFeedbackService;
import com.dt.user.utils.JsonUtils;
import com.dt.user.utils.ReqUtils;
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
        feedback.setCreateIdUser(ReqUtils.getUid());
        int result = backMapper.insertFeedback(feedback);
        return JsonUtils.saveMsg(result);
    }
}

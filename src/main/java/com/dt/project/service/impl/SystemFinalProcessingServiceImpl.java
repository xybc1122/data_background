package com.dt.project.service.impl;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.mapper.SystemMapper.SystemFinalProcessingMapper;
import com.dt.project.service.SystemService.SystemFinalProcessingService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import java.text.SimpleDateFormat;

/**
 * @ClassName SystemFinalProcessingServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/23 9:37
 **/
@Service
public class SystemFinalProcessingServiceImpl implements SystemFinalProcessingService {
    @Autowired
    private SystemFinalProcessingMapper pMapper;

    @Override
    public ResponseBase selectByDateCheckout(Integer menuId) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        String date = pMapper.selectByDateCheckout(menuId);
        if (StringUtils.isNotBlank(date))
            return JsonData.setResultSuccess("success", date + ":" + format.format(new Date()));
        return JsonData.setResultError("无时间数据");
    }
}
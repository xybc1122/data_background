package com.dt.user.service.impl;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.mapper.SystemMapper.SystemFinalProcessingMapper;
import com.dt.user.service.SystemService.SystemFinalProcessingService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        String date = pMapper.selectByDateCheckout(menuId);
        if (StringUtils.isNotBlank(date)) return JsonData.setResultSuccess("",date);
        return JsonData.setResultError("无时间数据");
    }
}

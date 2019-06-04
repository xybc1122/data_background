package com.dt.project.service.impl;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.mapper.basePublicMapper.BasicQualityInspectionMethodMapper;
import com.dt.project.service.basePublicService.BasicQualityInspectionMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName BasicQualityInspectionMethodServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/4 10:44
 **/
@Service
public class BasicQualityInspectionMethodServiceImpl implements BasicQualityInspectionMethodService {
    @Autowired
    private BasicQualityInspectionMethodMapper bQIMMapper;

    @Override
    public ResponseBase serviceSelectByBQIMethod() {
        return JsonData.setResultSuccess(bQIMMapper.selectByBQIMethod());
    }
}

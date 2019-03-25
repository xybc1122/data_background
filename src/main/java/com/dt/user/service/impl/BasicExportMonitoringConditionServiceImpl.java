package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicExportMonitoringConditionMapper;
import com.dt.user.model.BasePublicModel.BasicExportMonitoringCondition;
import com.dt.user.service.BasePublicService.BasicExportMonitoringConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicExportMonitoringConditionServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/25 9:06
 **/
@Service
public class BasicExportMonitoringConditionServiceImpl implements BasicExportMonitoringConditionService {
    @Autowired
    private BasicExportMonitoringConditionMapper conditionMapper;

    @Override
    public List<BasicExportMonitoringCondition> serviceFindByConditionList(BasicExportMonitoringCondition condition) {
        return conditionMapper.findByConditionList(condition);
    }
}

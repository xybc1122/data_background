package com.dt.user.service.BasePublicService;

import com.dt.user.model.BasePublicModel.BasicExportMonitoringCondition;

import java.util.List;

/**
 * @ClassName BasicExportMonitoringConditionService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/25 9:05
 **/
public interface BasicExportMonitoringConditionService {
    /**
     * 查询监管方式
     */
    List<BasicExportMonitoringCondition> serviceFindByConditionList(BasicExportMonitoringCondition condition);
}

package com.dt.user.controller.BasePublicController;

import com.dt.user.config.ResponseBase;
import com.dt.user.model.BasePublicModel.BasicExportMonitoringCondition;
import com.dt.user.service.BasePublicService.BasicExportMonitoringConditionService;
import com.dt.user.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName BasicExportMonitoringConditionController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/25 9:07
 **/
@RestController
@RequestMapping("/api/v1/condition")
public class BasicExportMonitoringConditionController {
    @Autowired
    private BasicExportMonitoringConditionService conditionService;


    @PostMapping("/findMonitoringInfo")
    public ResponseBase findCountryInfo(@RequestBody BasicExportMonitoringCondition condition) {
        PageInfoUtils.setPage(condition.getPageSize(), condition.getCurrentPage());
        return PageInfoUtils.returnPage(conditionService.serviceFindByConditionList(condition), condition.getCurrentPage());
    }

}

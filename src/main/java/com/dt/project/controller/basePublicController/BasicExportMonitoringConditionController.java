package com.dt.project.controller.basePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.basePublic.BasicExportMonitoringCondition;
import com.dt.project.service.basePublicService.BasicExportMonitoringConditionService;
import com.dt.project.utils.PageInfoUtils;
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
        return PageInfoUtils.returnPage(conditionService.serviceFindByConditionList(condition));
    }

}

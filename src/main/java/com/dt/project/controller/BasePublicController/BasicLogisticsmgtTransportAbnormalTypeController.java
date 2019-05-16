package com.dt.project.controller.BasePublicController;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.model.Parent.ParentTree;
import com.dt.project.service.BasePublicService.BasicLogisticsmgtTransportAbnormalTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName BasicLogisticsmgtTransportAbnormalTypeController
 * Description TODO     异常类型 接口
 * @Author 陈恩惠
 * @Date 2019/3/18 15:43
 **/
@RestController
@RequestMapping("/api/v1/abnormal")
public class BasicLogisticsmgtTransportAbnormalTypeController {
    @Autowired
    private BasicLogisticsmgtTransportAbnormalTypeService abnormalTypeService;

    @GetMapping("/findByListAbnormal")
    public ResponseBase findByListAbnormal() {
        List<ParentTree> abnormalTypeList = abnormalTypeService.serviceFindByListAbnormalType();
        return JsonData.setResultSuccess(abnormalTypeList);
    }
}

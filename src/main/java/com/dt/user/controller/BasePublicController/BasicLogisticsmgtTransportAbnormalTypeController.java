package com.dt.user.controller.BasePublicController;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.model.BasePublicModel.BasicLogisticsmgtTransportAbnormalType;
import com.dt.user.service.BasePublicService.BasicLogisticsmgtTransportAbnormalTypeService;
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
        List<BasicLogisticsmgtTransportAbnormalType> abnormalTypeList = abnormalTypeService.serviceFindByListAbnormalType();
        return JsonData.setResultSuccess(abnormalTypeList);
    }
}

package com.dt.user.controller.BasePublicController;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.model.BasePublicModel.BasicLogisticsmgtTransportValuationMethod;
import com.dt.user.service.BasePublicService.BasicLogisticsmgtTransportValuationMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName BasicLogisticsmgtTransportValuationMethodController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/21 17:01
 **/
@RestController
@RequestMapping("/api/v1/valuation")
public class BasicLogisticsmgtTransportValuationMethodController {
    @Autowired
    private BasicLogisticsmgtTransportValuationMethodService methodService;

    @GetMapping("/findByListValuationMethod")
    public ResponseBase findByListValuationMethod() {
        List<BasicLogisticsmgtTransportValuationMethod> methodList = methodService.serviceFindByValuationMethodInfo();
        return JsonData.setResultSuccess(methodList);
    }
}

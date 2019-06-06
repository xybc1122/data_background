package com.dt.project.controller.basePublicController;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.model.parent.ParentTree;
import com.dt.project.service.basePublicService.BasicLogisticsmgtTransportValuationMethodService;
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
        List<ParentTree> methodList = methodService.serviceFindByValuationMethodInfo();
        return JsonData.setResultSuccess(methodList);
    }
}
package com.dt.project.controller.basePublicController;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.service.basePublicService.BasicQualityInspectionMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BasicQualityInspectionMethodController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/4 10:45
 **/
@RestController
@RequestMapping("/api/v1/qim")
public class BasicQualityInspectionMethodController {

    @Autowired
    private BasicQualityInspectionMethodService bQIMService;


    @GetMapping("/findByListQIMethod")
    public ResponseBase findByListQIMethod() {
        return JsonData.setResultSuccess(bQIMService.serviceSelectByBQIMethod());
    }

}

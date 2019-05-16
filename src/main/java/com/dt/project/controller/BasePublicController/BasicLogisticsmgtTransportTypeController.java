package com.dt.project.controller.BasePublicController;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.model.Parent.ParentTree;
import com.dt.project.service.BasePublicService.BasicLogisticsmgtTransportTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName BasicLogisticsmgtTransportTypeController
 * Description TODO 运输类型接口
 * @Author 陈恩惠
 * @Date 2019/3/18 14:14
 **/
@RestController
@RequestMapping("/api/v1/type")
public class BasicLogisticsmgtTransportTypeController {
    @Autowired
    private BasicLogisticsmgtTransportTypeService typeService;


    @GetMapping("/findByListType")
    public ResponseBase findByListType() {
        List<ParentTree> basicPublicSiteList = typeService.serviceFindByTypeInfo();
        return JsonData.setResultSuccess(basicPublicSiteList);
    }
}
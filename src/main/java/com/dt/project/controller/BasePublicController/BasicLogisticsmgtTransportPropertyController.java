package com.dt.project.controller.basePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.service.basePublicService.BasicLogisticsmgtTransportPropertyService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BasicLogisticsmgtTransportPropertyController
 * Description TODO    运输性质 接口
 * @Author 陈恩惠
 * @Date 2019/3/18 13:55
 **/
@RestController
@RequestMapping("/api/v1/property")
public class BasicLogisticsmgtTransportPropertyController {
    @Autowired
    private BasicLogisticsmgtTransportPropertyService propertyService;

    @GetMapping("/findByListProperty")
    public ResponseBase findByListProperty(@RequestParam("pageSize") Integer pageSize,
                                           @RequestParam("currentPage") Integer currentPage) {
        PageInfoUtils.setPage(pageSize, currentPage);
        return PageInfoUtils.returnPage(propertyService.findByListProperty(), currentPage);
    }


}

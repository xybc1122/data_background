package com.dt.user.controller.BasePublicController;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.dto.TaxrateDto;
import com.dt.user.model.BasePublicModel.BasicLogisticsmgtTransportProperty;
import com.dt.user.service.BasePublicService.BasicLogisticsmgtTransportPropertyService;
import com.dt.user.utils.PageInfoUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

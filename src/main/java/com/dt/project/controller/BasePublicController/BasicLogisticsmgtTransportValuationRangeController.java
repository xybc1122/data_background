package com.dt.project.controller.basePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.service.basePublicService.BasicLogisticsmgtTransportValuationRangeService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BasicLogisticsmgtTransportValuationRangeController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 9:42
 **/
@RestController
@RequestMapping("/api/v1/range")
public class BasicLogisticsmgtTransportValuationRangeController {
    @Autowired
    private BasicLogisticsmgtTransportValuationRangeService rangeService;


    @GetMapping("/findByListRange")
    public ResponseBase findByListRange(@RequestParam("pageSize") Integer pageSize,
                                        @RequestParam("currentPage") Integer currentPage) {
        PageInfoUtils.setPage(pageSize, currentPage);
        return PageInfoUtils.returnPage(rangeService.serviceFindByListValuationRange());
    }


}

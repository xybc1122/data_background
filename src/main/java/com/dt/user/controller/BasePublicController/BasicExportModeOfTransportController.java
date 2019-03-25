package com.dt.user.controller.BasePublicController;

import com.dt.user.config.ResponseBase;
import com.dt.user.service.BasePublicService.BasicExportModeOfTransportService;
import com.dt.user.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BasicExportModeOfTransportController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/25 9:40
 **/
@RestController
@RequestMapping("/api/v1/mode")
public class BasicExportModeOfTransportController {

    @Autowired
    private BasicExportModeOfTransportService transportService;


    @GetMapping("/findByListModeOfTransport")
    public ResponseBase findByListModeOfTransport(@RequestParam("pageSize") Integer pageSize,
                                                  @RequestParam("currentPage") Integer currentPage) {
        PageInfoUtils.setPage(pageSize, currentPage);
        return PageInfoUtils.returnPage(transportService.serviceFindByModeOfInfo(), currentPage);
    }


}

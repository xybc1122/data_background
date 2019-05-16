package com.dt.project.controller.BasePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.service.BasePublicService.BasicExportWayOfClosingService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BasicExportWayOfClosingController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/25 10:33
 **/
@RestController
@RequestMapping("/api/v1/closing")
public class BasicExportWayOfClosingController {
    @Autowired
    private BasicExportWayOfClosingService closingService;

    @GetMapping("/findByListWayOfClosing")
    public ResponseBase findByListModeOfTransport(@RequestParam("pageSize") Integer pageSize,
                                                  @RequestParam("currentPage") Integer currentPage) {
        PageInfoUtils.setPage(pageSize, currentPage);
        return PageInfoUtils.returnPage(closingService.serviceFindByWayOfInfo(), currentPage);
    }

}

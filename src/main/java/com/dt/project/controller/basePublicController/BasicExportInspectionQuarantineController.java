package com.dt.project.controller.basePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.service.basePublicService.BasicExportInspectionQuarantineService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BasicExportInspectionQuarantineController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/25 10:06
 **/
@RestController
@RequestMapping("/api/v1/inspection")
public class BasicExportInspectionQuarantineController {

    @Autowired
    private BasicExportInspectionQuarantineService quarantineService;

    @GetMapping("/findByListQuarantine")
    public ResponseBase findByListModeOfTransport(@RequestParam("pageSize") Integer pageSize,
                                                  @RequestParam("currentPage") Integer currentPage) {
        PageInfoUtils.setPage(pageSize, currentPage);
        return PageInfoUtils.returnPage(quarantineService.serviceFindByQuarantineInfo());
    }


}

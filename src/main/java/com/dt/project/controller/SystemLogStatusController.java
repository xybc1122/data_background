package com.dt.project.controller;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.service.SystemLogStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SystemLogStatusController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/11 13:32
 **/
@RestController
@RequestMapping("/api/v1/log")
public class SystemLogStatusController {
    @Autowired
    private SystemLogStatusService statusService;

    @GetMapping("/getLogStatus")
    public ResponseBase getLogStatus(@RequestParam("statusId") String statusId) {

        return JsonData.setResultSuccess(statusService.serviceFindSysStatusInfo(Long.parseLong(statusId)));
    }


}

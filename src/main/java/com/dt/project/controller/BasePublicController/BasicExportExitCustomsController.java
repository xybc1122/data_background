package com.dt.project.controller.BasePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.BasePublicModel.BasicExportExitCustoms;
import com.dt.project.service.BasePublicService.BasicExportExitCustomsService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BasicExportExitCustomsController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/25 10:55
 **/
@RestController
@RequestMapping("/api/v1/customs")
public class BasicExportExitCustomsController {

    @Autowired
    private BasicExportExitCustomsService customsService;

    @PostMapping("/findExitCustomsInfo")
    public ResponseBase findCountryInfo(@RequestBody BasicExportExitCustoms customs) {
        PageInfoUtils.setPage(customs.getPageSize(), customs.getCurrentPage());
        return PageInfoUtils.returnPage(customsService.serviceFindByExitCustomsList(customs), customs.getCurrentPage());
    }
}

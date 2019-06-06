package com.dt.project.controller.basePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.basePublic.BasicExportHsCode;
import com.dt.project.service.basePublicService.BasicExportHsCodeService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @ClassName BasicExportHsCodeController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 11:17
 **/
@RestController
@RequestMapping("/api/v1/code")
public class BasicExportHsCodeController {

    @Autowired
    private BasicExportHsCodeService hsCodeService;


    @PostMapping("/findHsCodeInfo")
    public ResponseBase findHsCodeInfo(@RequestBody BasicExportHsCode hsCode) {
        PageInfoUtils.setPage(hsCode.getPageSize(), hsCode.getCurrentPage());
        return PageInfoUtils.returnPage(hsCodeService.serviceFindByListHsCode(hsCode));
    }
}

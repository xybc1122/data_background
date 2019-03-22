package com.dt.user.controller.BasePublicController;

import com.dt.user.config.ResponseBase;
import com.dt.user.dto.CountryDto;
import com.dt.user.model.BasePublicModel.BasicExportHsCode;
import com.dt.user.service.BasePublicService.BasicExportHsCodeService;
import com.dt.user.utils.PageInfoUtils;
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
        return PageInfoUtils.returnPage(hsCodeService.serviceFindByListHsCode(hsCode), hsCode.getCurrentPage());
    }
}

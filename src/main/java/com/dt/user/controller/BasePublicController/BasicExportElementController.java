package com.dt.user.controller.BasePublicController;

import com.dt.user.config.ResponseBase;
import com.dt.user.model.BasePublicModel.BasicExportElement;
import com.dt.user.model.BasePublicModel.BasicExportHsCode;
import com.dt.user.service.BasePublicService.BasicExportElementService;
import com.dt.user.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BasicExportElementController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 13:05
 **/
@RestController
@RequestMapping("/api/v1/ele")
public class BasicExportElementController {
    @Autowired
    private BasicExportElementService elementService;

    @PostMapping("/findElementInfo")
    public ResponseBase findElementInfo(@RequestBody BasicExportElement element) {
        PageInfoUtils.setPage(element.getPageSize(), element.getCurrentPage());
        return PageInfoUtils.returnPage(elementService.serviceFindByListElement(element), element.getCurrentPage());
    }
}

package com.dt.project.controller.BasePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.service.BasePublicService.BasicExportDeclareTypeService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BasicExportDeclareTypeController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 13:19
 **/
@RestController
@RequestMapping("/api/v1/declare")
public class BasicExportDeclareTypeController {
    @Autowired
    private BasicExportDeclareTypeService typeService;

    @GetMapping("/findByListDeclareType")
    public ResponseBase findByListDeclareType(@RequestParam("pageSize") Integer pageSize,
                                              @RequestParam("currentPage") Integer currentPage) {
        PageInfoUtils.setPage(pageSize, currentPage);
        return PageInfoUtils.returnPage(typeService.serviceFindByListDeclare(), currentPage);
    }
}

package com.dt.user.controller.BasePublicController;

import com.dt.user.config.ResponseBase;
import com.dt.user.service.BasePublicService.BasicExportGrosscustomsTypeService;
import com.dt.user.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BasicExportGrosscustomsTypeController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 13:25
 **/
@RestController
@RequestMapping("/api/v1/gro")
public class BasicExportGrosscustomsTypeController {
    @Autowired
    private BasicExportGrosscustomsTypeService typeService;

    @GetMapping("/findByListGrosscustoms")
    public ResponseBase findByListGrosscustoms(@RequestParam("pageSize") Integer pageSize,
                                               @RequestParam("currentPage") Integer currentPage) {
        PageInfoUtils.setPage(pageSize, currentPage);
        return PageInfoUtils.returnPage(typeService.serviceFindByListGrosscustoms(), currentPage);
    }
}

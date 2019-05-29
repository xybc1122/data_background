package com.dt.project.controller.basePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.service.basePublicService.BasicExportPackingTypeService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BasicExportPackingTypeController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/25 8:49
 **/
@RestController
@RequestMapping("/api/v1/packing")
public class BasicExportPackingTypeController {
    @Autowired
    private BasicExportPackingTypeService packingTypeService;

    @GetMapping("/findByListPackingType")
    public ResponseBase findByListPackingType(@RequestParam("pageSize") Integer pageSize,
                                              @RequestParam("currentPage") Integer currentPage) {
        PageInfoUtils.setPage(pageSize, currentPage);
        return PageInfoUtils.returnPage(packingTypeService.serviceFindByPackingTypeInfo(), currentPage);
    }
}

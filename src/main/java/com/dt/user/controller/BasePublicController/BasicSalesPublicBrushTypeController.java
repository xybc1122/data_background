package com.dt.user.controller.BasePublicController;

import com.dt.user.config.ResponseBase;
import com.dt.user.model.BasePublicModel.BasicSalesDeliveryType;
import com.dt.user.model.BasePublicModel.BasicSalesPublicBrushType;
import com.dt.user.service.BasePublicService.BasicSalesPublicBrushTypeService;
import com.dt.user.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName BasicSalesPublicBrushTypeController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/21 16:01
 **/
@RestController
@RequestMapping("/api/v1/brush")
public class BasicSalesPublicBrushTypeController {
    @Autowired
    private BasicSalesPublicBrushTypeService brushTypeService;


    @GetMapping("/findByListBrush")
    public ResponseBase findByListBrush(@RequestParam("pageSize") Integer pageSize,
                                        @RequestParam("currentPage") Integer currentPage) {
        PageInfoUtils.setPage(pageSize, currentPage);
        List<BasicSalesPublicBrushType> brushTypes = brushTypeService.serviceFindByBrushTypeInfo();
        return PageInfoUtils.returnPage(brushTypes, currentPage);
    }


}

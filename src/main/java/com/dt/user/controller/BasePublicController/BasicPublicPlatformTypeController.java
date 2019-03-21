package com.dt.user.controller.BasePublicController;

import com.dt.user.config.ResponseBase;
import com.dt.user.model.BasePublicModel.BasicPublicPlatformType;
import com.dt.user.model.BasePublicModel.BasicSalesPublicStarlevel;
import com.dt.user.service.BasePublicService.BasicPublicPlatformTypeService;
import com.dt.user.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName BasicPublicPlatformTypeController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/21 16:28
 **/
@RequestMapping("/api/v1/plat")
@RestController
public class BasicPublicPlatformTypeController {
    @Autowired
    private BasicPublicPlatformTypeService platformTypeService;


    @GetMapping("/findByListPlatform")
    public ResponseBase findByListPlatform(@RequestParam("pageSize") Integer pageSize,
                                           @RequestParam("currentPage") Integer currentPage) {
        PageInfoUtils.setPage(pageSize, currentPage);
        List<BasicPublicPlatformType> platformTypeList = platformTypeService.serviceFindByListPlatform();
        return PageInfoUtils.returnPage(platformTypeList, currentPage);
    }


}

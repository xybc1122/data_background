package com.dt.project.controller.basePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.service.basePublicService.BasicPublicPlatformTypeService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        return PageInfoUtils.returnPage(platformTypeService.serviceFindByListPlatform());
    }


}

package com.dt.project.controller.basePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.service.basePublicService.BasicSalesPublicStarlevelService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BasicSalesPublicStarlevelController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/20 13:38
 **/
@RequestMapping("/api/v1/star")
@RestController
public class BasicSalesPublicStarlevelController {
    @Autowired
    private BasicSalesPublicStarlevelService starlevelService;

    @GetMapping("/findByListStarLevel")
    public ResponseBase findByListStarLevel(@RequestParam("pageSize") Integer pageSize,
                                            @RequestParam("currentPage") Integer currentPage) {
        PageInfoUtils.setPage(pageSize, currentPage);
        return PageInfoUtils.returnPage(starlevelService.serviceFindByListStarlevel(), currentPage);
    }
}

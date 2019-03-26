package com.dt.user.controller.BasePublicController;

import com.dt.user.config.ResponseBase;
import com.dt.user.service.BasePublicService.BasicHrNationService;
import com.dt.user.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BasicHrNationController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/26 13:57
 **/
@RestController
@RequestMapping("/api/v1/nation")
public class BasicHrNationController {
    @Autowired
    private BasicHrNationService nationService;

    @GetMapping("/findByListNationInfo")
    public ResponseBase findByListNation(@RequestParam("pageSize") Integer pageSize,
                                         @RequestParam("currentPage") Integer currentPage) {
        PageInfoUtils.setPage(pageSize, currentPage);
        return PageInfoUtils.returnPage(nationService.serviceFindByListHrNation(), currentPage);
    }


}

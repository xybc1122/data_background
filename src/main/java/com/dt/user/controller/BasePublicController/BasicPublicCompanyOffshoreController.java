package com.dt.user.controller.BasePublicController;

import com.dt.user.config.ResponseBase;
import com.dt.user.service.BasePublicService.BasicPublicCompanyOffshoreService;
import com.dt.user.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BasicPublicCompanyOffshoreController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/26 14:16
 **/
@RestController
@RequestMapping("/api/v1/Offshore")
public class BasicPublicCompanyOffshoreController {
    @Autowired
    private BasicPublicCompanyOffshoreService offshoreService;



    @GetMapping("/findByListCompanyOffshore")
    public ResponseBase findByListCompanyOffshore(@RequestParam("pageSize") Integer pageSize,
                                         @RequestParam("currentPage") Integer currentPage) {
        PageInfoUtils.setPage(pageSize, currentPage);
        return PageInfoUtils.returnPage(offshoreService.serviceFindByListOffshore(), currentPage);
    }


}

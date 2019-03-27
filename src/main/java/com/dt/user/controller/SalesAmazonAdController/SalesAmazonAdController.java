package com.dt.user.controller.SalesAmazonAdController;

import com.dt.user.config.ResponseBase;
import com.dt.user.model.SalesAmazonAd.SalesAmazonAdCpr;
import com.dt.user.service.SalesAmazonAdService.SalesAmazonAdCprService;
import com.dt.user.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SalesAmazonAdCprController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/26 16:42
 **/
@RestController
@RequestMapping("/api/v1/ad")
public class SalesAmazonAdController {
    @Autowired
    private SalesAmazonAdCprService cprService;

    @PostMapping("/getCprInfo")
    public ResponseBase getCprInfo(@RequestBody SalesAmazonAdCpr adCpr) {
        PageInfoUtils.setPage(adCpr.getPageSize(), adCpr.getCurrentPage());
        return PageInfoUtils.returnPage(cprService.serviceFindByListCpr(adCpr), adCpr.getCurrentPage());
    }


}

package com.dt.user.controller.SalesAmazonAdController;

import com.dt.user.config.ResponseBase;
import com.dt.user.model.SalesAmazonAd.SalesAmazonAdCpr;
import com.dt.user.model.SalesAmazonAd.SalesAmazonAdHl;
import com.dt.user.model.SalesAmazonAd.SalesAmazonAdOar;
import com.dt.user.model.SalesAmazonAd.SalesAmazonAdStr;
import com.dt.user.service.SalesAmazonAdService.SalesAmazonAHlService;
import com.dt.user.service.SalesAmazonAdService.SalesAmazonAdCprService;
import com.dt.user.service.SalesAmazonAdService.SalesAmazonAdOarService;
import com.dt.user.service.SalesAmazonAdService.SalesAmazonAdStrService;
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

    @Autowired
    private SalesAmazonAdStrService strService;

    @Autowired
    private SalesAmazonAdOarService oarService;

    @Autowired
    private SalesAmazonAHlService hlService;

    @PostMapping("/getCprInfo")
    public ResponseBase getCprInfo(@RequestBody SalesAmazonAdCpr adCpr) {
        PageInfoUtils.setPage(adCpr.getPageSize(), adCpr.getCurrentPage());
        return PageInfoUtils.returnPage(cprService.serviceFindByListCpr(adCpr), adCpr.getCurrentPage());
    }

    @PostMapping("/getStrInfo")
    public ResponseBase getStrInfo(@RequestBody SalesAmazonAdStr str) {
        PageInfoUtils.setPage(str.getPageSize(), str.getCurrentPage());
        return PageInfoUtils.returnPage(strService.serviceFindByListStr(str), str.getCurrentPage());
    }

    @PostMapping("/getOarInfo")
    public ResponseBase geOarInfo(@RequestBody SalesAmazonAdOar oar) {
        PageInfoUtils.setPage(oar.getPageSize(), oar.getCurrentPage());
        return PageInfoUtils.returnPage(oarService.serviceFindByListOar(oar), oar.getCurrentPage());
    }


    @PostMapping("/getHlInfo")
    public ResponseBase geHlInfo(@RequestBody SalesAmazonAdHl hl) {
        PageInfoUtils.setPage(hl.getPageSize(), hl.getCurrentPage());
        return PageInfoUtils.returnPage(hlService.serviceFindByListHl(hl), hl.getCurrentPage());
    }
}

package com.dt.user.controller.SalesAmazonController;

import com.dt.user.config.ResponseBase;
import com.dt.user.model.SalesAmazon.SalesAmazonAdCpr;
import com.dt.user.model.SalesAmazon.SalesAmazonAdHl;
import com.dt.user.model.SalesAmazon.SalesAmazonAdOar;
import com.dt.user.model.SalesAmazon.SalesAmazonAdStr;
import com.dt.user.service.SalesAmazonService.SalesAmazonAHlService;
import com.dt.user.service.SalesAmazonService.SalesAmazonAdCprService;
import com.dt.user.service.SalesAmazonService.SalesAmazonAdOarService;
import com.dt.user.service.SalesAmazonService.SalesAmazonAdStrService;
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

    /**
     * 查询cpr信息
     * @param adCpr
     * @return
     */
    @PostMapping("/getCprInfo")
    public ResponseBase getCprInfo(@RequestBody SalesAmazonAdCpr adCpr) {
        PageInfoUtils.setPage(adCpr.getPageSize(), adCpr.getCurrentPage());
        return PageInfoUtils.returnPage(cprService.serviceFindByListCpr(adCpr), adCpr.getCurrentPage());
    }

    /**
     * 查询str信息
     * @param str
     * @return
     */
    @PostMapping("/getStrInfo")
    public ResponseBase getStrInfo(@RequestBody SalesAmazonAdStr str) {
        PageInfoUtils.setPage(str.getPageSize(), str.getCurrentPage());
        return PageInfoUtils.returnPage(strService.serviceFindByListStr(str), str.getCurrentPage());
    }

    /**
     * 查询oar信息
     * @param oar
     * @return
     */
    @PostMapping("/getOarInfo")
    public ResponseBase geOarInfo(@RequestBody SalesAmazonAdOar oar) {
        PageInfoUtils.setPage(oar.getPageSize(), oar.getCurrentPage());
        return PageInfoUtils.returnPage(oarService.serviceFindByListOar(oar), oar.getCurrentPage());
    }

    /**
     * 查询Hl信息
     * @param hl
     * @return
     */
    @PostMapping("/getHlInfo")
    public ResponseBase geHlInfo(@RequestBody SalesAmazonAdHl hl) {
        PageInfoUtils.setPage(hl.getPageSize(), hl.getCurrentPage());
        return PageInfoUtils.returnPage(hlService.serviceFindByListHl(hl), hl.getCurrentPage());
    }

}

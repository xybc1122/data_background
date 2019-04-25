package com.dt.user.controller.BasePublicController;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.dto.SiteDto;
import com.dt.user.model.BasePublicModel.BasicPublicSite;
import com.dt.user.service.BasePublicService.BasicPublicSiteService;
import com.dt.user.utils.PageInfoUtils;
import com.dt.user.utils.ReqUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/site")
public class BasicPublicSiteController {

    @Autowired
    private BasicPublicSiteService siteService;

    /**
     * 获得所有站点的信息
     *
     * @return
     */
    @PostMapping("/findByListSite")
    public ResponseBase findByListSite(@RequestBody SiteDto siteDto) {
        PageInfoUtils.setPage(siteDto.getPageSize(), siteDto.getCurrentPage());
        return PageInfoUtils.returnPage(siteService.findBySiteList(siteDto), siteDto.getCurrentPage());
    }

    /**
     * 通过店铺id获得所有站点信息
     *
     * @return
     */
    @GetMapping("/getByShopIdListSite")
    public ResponseBase getByShopIdListSite(@RequestParam("sid") String sid) {
        List<BasicPublicSite> shopIdSiteList = siteService.serviceSelectSiteInfo(Integer.parseInt(sid), ReqUtils.getRoleId());
        return JsonData.setResultSuccess(shopIdSiteList);
    }

}

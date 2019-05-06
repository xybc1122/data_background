package com.dt.user.controller.BasePublicController;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.dto.SiteDto;
import com.dt.user.model.BasePublicModel.BasicPublicSite;
import com.dt.user.service.BasePublicService.BasicPublicSiteService;
import com.dt.user.utils.PageInfoUtils;
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
     * 通过区域角色id 获得站点信息
     *
     * @return
     */
    @GetMapping("/getByShopIdListSite")
    public ResponseBase getByShopIdListSite(@RequestParam("arId") String arId) {
        List<BasicPublicSite> shopIdSiteList = siteService.serviceSelectSiteInfo(Integer.parseInt(arId));
        return JsonData.setResultSuccess(shopIdSiteList);
    }


    /**
     * 通过角色 id 获得所有的站点信息
     *
     * @return
     */
    @GetMapping("/getSelectSiteRole")
    public ResponseBase getSelectSiteRole() {
        return JsonData.setResultSuccess(siteService.serviceSelectSiteRole());
    }
}

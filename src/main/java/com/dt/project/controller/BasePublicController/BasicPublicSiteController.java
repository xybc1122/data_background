package com.dt.project.controller.basePublicController;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.model.dto.SiteDto;
import com.dt.project.service.basePublicService.BasicPublicSiteService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ResponseBase getByShopIdListSite(@RequestParam("arIds") String arIds) {
        return JsonData.setResultSuccess(siteService.serviceSelectSiteInfo(arIds));
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

package com.dt.user.service.BasePublicService;

import com.dt.user.dto.SiteDto;
import com.dt.user.model.BasePublicModel.BasicPublicSite;

import java.util.List;

public interface BasicPublicSiteService {


    /**
     * 查询所有站点信息
     *
     * @return
     */
    List<SiteDto> findBySiteList(SiteDto siteDto);


    /**
     * 通过区域角色id 查询站点
     */
    List<BasicPublicSite> serviceSelectSiteInfo(Integer arId);


    /**
     * 洲 业务
     * 通过url 去查询site ID
     */
    Integer serviceGetUrlSiteId(String url);

    /**
     * 洲 业务
     * 通过country /sName 国家名 去查询site ID
     *
     * @param country
     * @return
     */
    Integer serviceGetSiteId(String country, String sName);


    /**
     * 通过币别 currency 去查询site ID
     *
     * @param currency
     * @return
     */
    Integer getCurrencySiteId(String currency);


    /**
     * admin配置 通过 aid 查询站点
     *
     * @param aid
     * @return
     */
    List<BasicPublicSite> selectAidSiteAdmin(Integer aid);

}

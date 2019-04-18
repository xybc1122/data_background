package com.dt.user.service.impl;

import com.dt.user.dto.SiteDto;
import com.dt.user.mapper.BasePublicMapper.BasicPublicSiteMapper;
import com.dt.user.model.BasePublicModel.BasicPublicSite;
import com.dt.user.service.BasePublicService.BasicPublicSiteService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicPublicSiteServiceImpl implements BasicPublicSiteService {

    @Autowired
    private BasicPublicSiteMapper siteMapper;

    @Override
    public List<SiteDto> findBySiteList(SiteDto siteDto) {
        return siteMapper.findBySiteList(siteDto);
    }

    @Override
    public List<BasicPublicSite> getShopIdTakeSiteList(Long sId) {
        return siteMapper.getShopIdTakeSiteList(sId);
    }

    @Override
    public Integer serviceGetUrlSiteId(String url) {
        return siteMapper.getUrlSiteId(url);
    }

    @Override
    public Integer serviceGetSiteId(String country, String sName) {
        return siteMapper.getSId(country, sName);
    }
}

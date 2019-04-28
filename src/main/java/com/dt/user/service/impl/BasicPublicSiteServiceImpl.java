package com.dt.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dt.user.dto.SiteDto;
import com.dt.user.mapper.BasePublicMapper.BasicPublicSiteMapper;
import com.dt.user.model.BasePublicModel.BasicPublicSite;
import com.dt.user.service.BasePublicService.BasicPublicSiteService;
import com.dt.user.service.RedisService;
import com.dt.user.toos.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicPublicSiteServiceImpl implements BasicPublicSiteService {

    @Autowired
    private BasicPublicSiteMapper siteMapper;
    @Autowired
    private RedisService redisService;

    @Override
    public List<SiteDto> findBySiteList(SiteDto siteDto) {
        return siteMapper.findBySiteList(siteDto);
    }

    @Override
    public List<BasicPublicSite> serviceSelectSiteInfo(Integer arId) {
        return siteMapper.selectSiteInfo(arId);
    }

    @Override
    public Integer serviceGetUrlSiteId(String url) {
        return siteMapper.getUrlSiteId(url);
    }

    @Override
    public Integer serviceGetSiteId(String country, String sName) {
        return siteMapper.getSId(country, sName);
    }

    @Override
    public Integer getCurrencySiteId(String currency) {
        return siteMapper.getCurrencySiteId(currency);
    }

    @Override
    public List<BasicPublicSite> selectAidSiteAdmin(Integer aid) {
        String sitesRedis = redisService.getStringKey(Constants.SITE_INFO + aid);
        if (StringUtils.isBlank(sitesRedis)) {
            List<BasicPublicSite> sitesDb = siteMapper.selectAidSite(aid);
            if (sitesDb != null && sitesDb.size() > 0) {
                //刷如缓存
                redisService.setString(Constants.SITE_INFO + aid, JSONObject.toJSONString(sitesDb));
                return sitesDb;
            }
        }
        return JSONObject.parseArray(sitesRedis, BasicPublicSite.class);
    }

    @Override
    public Integer selectAidAndSite(Integer aid) {
        return siteMapper.selectAidAndSite(aid);
    }
}

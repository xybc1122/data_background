package com.dt.user.service.impl;

import com.dt.user.config.ResponseBase;
import com.dt.user.mapper.BasePublicMapper.BasicPublicShopSiteMapper;
import com.dt.user.model.BasePublicModel.BasicPublicShopSite;
import com.dt.user.service.BasePublicService.BasicPublicShopSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName BasicPublicShopSiteServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/24 15:50
 **/
@Service
public class BasicPublicShopSiteServiceImpl implements BasicPublicShopSiteService {
    @Autowired
    private BasicPublicShopSiteMapper shopSiteMapper;

    @Override
    public ResponseBase serviceInsertShopSite(BasicPublicShopSite shopSite) {


        return null;
    }
}

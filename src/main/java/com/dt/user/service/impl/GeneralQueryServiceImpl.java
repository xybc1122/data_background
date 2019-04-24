package com.dt.user.service.impl;


import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.exception.LsException;
import com.dt.user.mapper.GeneralQueryMapper;
import com.dt.user.model.BasePublicModel.*;
import com.dt.user.model.System.SystemShopRole;
import com.dt.user.service.BasePublicService.BasicPublicProductsService;
import com.dt.user.service.GeneralQueryService;
import com.dt.user.toos.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisServer;
import org.springframework.stereotype.Service;

/**
 * @ClassName GeneralQueryServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/11 11:18
 **/
@Service
public class GeneralQueryServiceImpl implements GeneralQueryService {
    
    @Autowired
    private RedisServer redisServer;

    @Override
    public void statusIdExist(String key) {
        //先去缓存查一下是否真的为null
        String statusIdSql = redisServer.get(Constants.STATUS_ID + key);
        //如果 = null 说明里面确实是空的
        if (StringUtils.isNotBlank(statusIdSql)) {
            throw new LsException("statusId参数为空");
        }
    }
}


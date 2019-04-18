package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicPublicAmazonTypeMapper;
import com.dt.user.service.BasePublicService.BasicPublicAmazonTypeService;
import com.dt.user.service.RedisService;
import com.dt.user.toos.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName BasicPublicAmazonTypeServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/18 11:16
 **/
@Service
public class BasicPublicAmazonTypeServiceImpl implements BasicPublicAmazonTypeService {
    @Autowired
    private BasicPublicAmazonTypeMapper typeMapper;

    @Override
    public String getTypeName(Integer seId, String type) {
        String typeNameDb = typeMapper.getTypeName(seId, type);
        //如果db不 = null
        if (StringUtils.isNotBlank(typeNameDb)) {
            return typeNameDb;
        }
        return null;
    }
}

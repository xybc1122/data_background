package com.dt.project.service.impl;

import com.dt.project.mapper.basePublicMapper.BasicPublicAmazonTypeMapper;
import com.dt.project.service.basePublicService.BasicPublicAmazonTypeService;
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

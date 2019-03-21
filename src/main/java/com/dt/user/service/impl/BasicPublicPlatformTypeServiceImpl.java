package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicPublicPlatformTypeMapper;
import com.dt.user.model.BasePublicModel.BasicPublicPlatformType;
import com.dt.user.service.BasePublicService.BasicPublicPlatformTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicPublicPlatformTypeServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/21 16:27
 **/
@Service
public class BasicPublicPlatformTypeServiceImpl implements BasicPublicPlatformTypeService {
    @Autowired
    private BasicPublicPlatformTypeMapper platformTypeMapper;

    @Override
    public List<BasicPublicPlatformType> serviceFindByListPlatform() {
        return platformTypeMapper.findByListPlatform();
    }
}

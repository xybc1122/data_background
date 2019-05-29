package com.dt.project.service.impl;

import com.dt.project.mapper.basePublicMapper.BasicPublicPlatformTypeMapper;
import com.dt.project.model.basePublicModel.BasicPublicPlatformType;
import com.dt.project.service.basePublicService.BasicPublicPlatformTypeService;
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

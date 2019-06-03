package com.dt.project.service.impl;

import com.dt.project.mapper.basePublicMapper.BasicSalesAmazonTypeMapper;
import com.dt.project.model.basePublic.BasicSalesAmazonType;
import com.dt.project.service.basePublicService.BasicSalesAmazonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicSalesAmazonTypeServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/20 10:43
 **/
@Service
public class BasicSalesAmazonTypeServiceImpl implements BasicSalesAmazonTypeService {
    @Autowired
    private BasicSalesAmazonTypeMapper amazonTypeMapper;

    @Override
    public List<BasicSalesAmazonType> serviceFindByListAmazonType(BasicSalesAmazonType amazonType) {
        return amazonTypeMapper.findByListAmazonType(amazonType);
    }
}

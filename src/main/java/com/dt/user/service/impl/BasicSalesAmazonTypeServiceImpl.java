package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicSalesAmazonTypeMapper;
import com.dt.user.model.BasePublicModel.BasicSalesAmazonType;
import com.dt.user.service.BasePublicService.BasicSalesAmazonTypeService;
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

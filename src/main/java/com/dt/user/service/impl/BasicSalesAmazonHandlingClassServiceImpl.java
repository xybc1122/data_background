package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicSalesAmazonHandlingClassMapper;
import com.dt.user.model.BasePublicModel.BasicSalesAmazonHandlingClass;
import com.dt.user.service.BasePublicService.BasicSalesAmazonHandlingClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicSalesAmazonHandlingClassServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 16:35
 **/
@Service
public class BasicSalesAmazonHandlingClassServiceImpl implements BasicSalesAmazonHandlingClassService {
    @Autowired
    private BasicSalesAmazonHandlingClassMapper handlingClassMapper;

    @Override
    public List<BasicSalesAmazonHandlingClass> serviceFindByListClass(BasicSalesAmazonHandlingClass handlingClass) {
        return handlingClassMapper.findByListClass(handlingClass);
    }
}

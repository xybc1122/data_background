package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicSalesAmazonDescriptionMapper;
import com.dt.user.model.BasePublicModel.BasicSalesAmazonDescription;
import com.dt.user.service.BasePublicService.BasicSalesAmazonDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicSalesAmazonDescriptionServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 15:52
 **/
@Service
public class BasicSalesAmazonDescriptionServiceImpl implements BasicSalesAmazonDescriptionService {
    @Autowired
    private BasicSalesAmazonDescriptionMapper descriptionMapper;

    @Override
    public List<BasicSalesAmazonDescription> serviceGetDescription(BasicSalesAmazonDescription description) {
        return descriptionMapper.getDescription(description);
    }
}

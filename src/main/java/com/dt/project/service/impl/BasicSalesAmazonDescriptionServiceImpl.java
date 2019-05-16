package com.dt.project.service.impl;

import com.dt.project.mapper.BasePublicMapper.BasicSalesAmazonDescriptionMapper;
import com.dt.project.model.BasePublicModel.BasicSalesAmazonDescription;
import com.dt.project.service.BasePublicService.BasicSalesAmazonDescriptionService;
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

package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicSalesAmazonPaymentTypeMapper;
import com.dt.user.model.BasePublicModel.BasicSalesAmazonPaymentType;
import com.dt.user.service.BasePublicService.BasicSalesAmazonPaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicSalesAmazonPaymentTypeServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 16:11
 **/
@Service
public class BasicSalesAmazonPaymentTypeServiceImpl implements BasicSalesAmazonPaymentTypeService {
    @Autowired
    private BasicSalesAmazonPaymentTypeMapper paymentTypeMapper;

    @Override
    public List<BasicSalesAmazonPaymentType> serviceFindByListPayType() {
        return paymentTypeMapper.findByListPayType();
    }
}

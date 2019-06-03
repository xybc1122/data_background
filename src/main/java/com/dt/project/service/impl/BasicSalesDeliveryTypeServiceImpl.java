package com.dt.project.service.impl;

import com.dt.project.mapper.basePublicMapper.BasicSalesDeliveryTypeMapper;
import com.dt.project.model.basePublic.BasicSalesDeliveryType;
import com.dt.project.service.basePublicService.BasicSalesDeliveryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicSalesDeliveryTypeServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/20 13:26
 **/
@Service
public class BasicSalesDeliveryTypeServiceImpl implements BasicSalesDeliveryTypeService {
    @Autowired
    private BasicSalesDeliveryTypeMapper deliveryTypeMapper;

    @Override
    public List<BasicSalesDeliveryType> serviceFindByListDeliveryType() {
        return deliveryTypeMapper.findByListDeliveryType();
    }
}

package com.dt.project.service.impl;

import com.dt.project.mapper.basePublicMapper.BasicPurchasePriceMapper;
import com.dt.project.model.basePublicModel.BasicPurchasePrice;
import com.dt.project.service.basePublicService.BasicPurchasePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicPurchasePriceServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 14:32
 **/
@Service
public class BasicPurchasePriceServiceImpl implements BasicPurchasePriceService {

    @Autowired
    private BasicPurchasePriceMapper priceMapper;

    @Override
    public List<BasicPurchasePrice> serviceFindByListPrice(BasicPurchasePrice price) {
        return priceMapper.findByListPrice(price);
    }
}

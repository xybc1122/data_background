package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicPurchasePriceMapper;
import com.dt.user.model.BasePublicModel.BasicPurchasePrice;
import com.dt.user.service.BasePublicService.BasicPurchasePriceService;
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

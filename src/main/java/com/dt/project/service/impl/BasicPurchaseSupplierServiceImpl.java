package com.dt.project.service.impl;

import com.dt.project.mapper.basePublicMapper.BasicPurchaseSupplierMapper;
import com.dt.project.model.basePublic.BasicPurchaseSupplier;
import com.dt.project.redis.RedisService;
import com.dt.project.service.basePublicService.BasicPurchaseSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicPurchaseSupplierServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/3 9:08
 **/
@Service
public class BasicPurchaseSupplierServiceImpl implements BasicPurchaseSupplierService {
    @Autowired
    private BasicPurchaseSupplierMapper pSuppMapper;


    @Autowired
    private RedisService redisService;

    @Override
    public List<BasicPurchaseSupplier> selectByPurchaseSupplier(BasicPurchaseSupplier pSupplier) {
        pSupplier.setJsonArray(redisService.getRedisJson("pSupp", BasicPurchaseSupplier.class));
        return pSuppMapper.selectByPurchaseSupplier(pSupplier);
    }
}

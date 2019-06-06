package com.dt.project.service.impl;

import com.dt.project.mapper.salesAmazonMapper.SalesAmazonFbaAbandonMapper;
import com.dt.project.model.salesAmazon.SalesAmazonFbaAbandon;
import com.dt.project.redis.RedisService;
import com.dt.project.service.salesAmazonService.SalesAmazonFbaAbandonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SalesAmazonFbaAbandonServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/9 13:25
 **/
@Service
public class SalesAmazonFbaAbandonServiceImpl implements SalesAmazonFbaAbandonService {
    @Autowired
    private SalesAmazonFbaAbandonMapper abandonMapper;
    @Autowired
    private RedisService redisService;

    @Override
    public int serviceSetSalesAmazonAbandonList(List<SalesAmazonFbaAbandon> abandonList) {
        return abandonMapper.setSalesAmazonAbandonList(abandonList);
    }

    @Override
    public List<SalesAmazonFbaAbandon> serviceFindByListAbandon(SalesAmazonFbaAbandon abandon) {
        abandon.setJsonArr(redisService.getRedisJson("abandon",SalesAmazonFbaAbandon.class));
        return abandonMapper.findByListAbandon(abandon);
    }
}

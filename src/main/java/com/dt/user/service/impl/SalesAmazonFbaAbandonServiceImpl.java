package com.dt.user.service.impl;

import com.dt.user.mapper.SalesAmazonMapper.SalesAmazonFbaAbandonMapper;
import com.dt.user.model.SalesAmazon.SalesAmazonFbaAbandon;
import com.dt.user.service.SalesAmazonService.SalesAmazonFbaAbandonService;
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

    @Override
    public List<SalesAmazonFbaAbandon> serviceFindByListAbandon(SalesAmazonFbaAbandon abandon) {
        return abandonMapper.findByListAbandon(abandon);
    }
}

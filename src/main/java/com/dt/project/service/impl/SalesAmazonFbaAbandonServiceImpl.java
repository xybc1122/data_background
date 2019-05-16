package com.dt.project.service.impl;

import com.dt.project.mapper.SalesAmazonMapper.SalesAmazonFbaAbandonMapper;
import com.dt.project.model.SalesAmazon.SalesAmazonFbaAbandon;
import com.dt.project.service.SalesAmazonService.SalesAmazonFbaAbandonService;
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
    public int serviceSetSalesAmazonAbandonList(List<SalesAmazonFbaAbandon> abandonList) {
        return abandonMapper.setSalesAmazonAbandonList(abandonList);
    }

    @Override
    public List<SalesAmazonFbaAbandon> serviceFindByListAbandon(SalesAmazonFbaAbandon abandon) {
        return abandonMapper.findByListAbandon(abandon);
    }
}

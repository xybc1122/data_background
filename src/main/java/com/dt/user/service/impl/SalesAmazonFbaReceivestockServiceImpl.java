package com.dt.user.service.impl;

import com.dt.user.mapper.SalesAmazonMapper.SalesAmazonFbaReceivestockMapper;
import com.dt.user.model.SalesAmazon.SalesAmazonFbaReceivestock;
import com.dt.user.service.SalesAmazonService.SalesAmazonFbaReceivestockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesAmazonFbaReceivestockServiceImpl implements SalesAmazonFbaReceivestockService {
    @Autowired
    private SalesAmazonFbaReceivestockMapper sfrMapper;


    @Override
    public int addSalesAmazonAdReceivestockList(List<SalesAmazonFbaReceivestock> receivesList) {
        return sfrMapper.addSalesAmazonAdReceiveStockList(receivesList);
    }

    @Override
    public List<SalesAmazonFbaReceivestock> serviceFindByListRec(SalesAmazonFbaReceivestock rec) {
        return sfrMapper.findByListRec(rec);
    }
}

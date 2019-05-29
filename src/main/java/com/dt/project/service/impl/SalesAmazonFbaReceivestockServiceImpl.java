package com.dt.project.service.impl;

import com.dt.project.mapper.salesAmazonMapper.SalesAmazonFbaReceivestockMapper;
import com.dt.project.model.salesAmazon.SalesAmazonFbaReceivestock;
import com.dt.project.service.salesAmazonService.SalesAmazonFbaReceivestockService;
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

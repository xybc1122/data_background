package com.dt.user.service.impl;

import com.dt.user.mapper.SalesAmazonMapper.SalesAmazonFbaInventoryEndMapper;
import com.dt.user.model.SalesAmazon.SalesAmazonFbaInventoryEnd;
import com.dt.user.service.SalesAmazonService.SalesAmazonFbaInventoryEndService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesAmazonFbaInventoryEndServiceImpl implements SalesAmazonFbaInventoryEndService {
    @Autowired
    private SalesAmazonFbaInventoryEndMapper endMapper;

    @Override
    public int addSalesAmazonAdInventoryEndList(List<SalesAmazonFbaInventoryEnd> endList) {
        return endMapper.addSalesAmazonAdInventoryEndList(endList);
    }

    @Override
    public List<SalesAmazonFbaInventoryEnd> serviceFindByListEnd(SalesAmazonFbaInventoryEnd end) {
        return endMapper.findByListEnd(end);
    }
}

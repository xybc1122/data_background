package com.dt.project.service.impl;

import com.dt.project.mapper.SalesAmazonMapper.SalesAmazonFbaInventoryEndMapper;
import com.dt.project.model.SalesAmazon.SalesAmazonFbaInventoryEnd;
import com.dt.project.service.SalesAmazonService.SalesAmazonFbaInventoryEndService;
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

package com.dt.project.service.impl;

import com.dt.project.mapper.SalesAmazonMapper.SalesAmazonAdCprMapper;
import com.dt.project.model.SalesAmazon.SalesAmazonAdCpr;
import com.dt.project.service.SalesAmazonService.SalesAmazonAdCprService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesAmazonAdCprServiceImpl implements SalesAmazonAdCprService {
    @Autowired
    private SalesAmazonAdCprMapper adCprMapper;

    @Override
    public int saveSalesAmazonAdCprList(List<SalesAmazonAdCpr> cprList) {
        return adCprMapper.setSalesAmazonAdCprList(cprList);
    }

    @Override
    public List<SalesAmazonAdCpr> serviceFindByListCpr(SalesAmazonAdCpr cpr) {
        return adCprMapper.findByListCpr(cpr);
    }
}

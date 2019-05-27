package com.dt.project.service.impl;

import com.dt.project.mapper.salesAmazonMapper.SalesAmazonAdStrMapper;
import com.dt.project.model.salesAmazon.SalesAmazonAdStr;
import com.dt.project.service.salesAmazonService.SalesAmazonAdStrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesAmazonAdStrServiceImpl implements SalesAmazonAdStrService {
    @Autowired
    private SalesAmazonAdStrMapper strMapper;

    @Override
    public int saveSalesAmazonAdStrList(List<SalesAmazonAdStr> strList) {
        return strMapper.setSalesAmazonAdStrList(strList);
    }

    @Override
    public List<SalesAmazonAdStr> serviceFindByListStr(SalesAmazonAdStr str) {
        return strMapper.findByListStr(str);
    }
}

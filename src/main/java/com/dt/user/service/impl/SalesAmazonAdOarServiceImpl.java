package com.dt.user.service.impl;

import com.dt.user.mapper.SalesAmazonMapper.SalesAmazonAdOarMapper;
import com.dt.user.model.SalesAmazon.SalesAmazonAdOar;
import com.dt.user.service.SalesAmazonService.SalesAmazonAdOarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesAmazonAdOarServiceImpl implements SalesAmazonAdOarService {
    @Autowired
    private SalesAmazonAdOarMapper oarMapper;

    @Override
    public int AddSalesAmazonAdOarList(List<SalesAmazonAdOar> oarList) {
        return oarMapper.AddSalesAmazonAdOarList(oarList);
    }

    @Override
    public List<SalesAmazonAdOar> serviceFindByListOar(SalesAmazonAdOar oar) {
        return oarMapper.findByListOar(oar);
    }
}

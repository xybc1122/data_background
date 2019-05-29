package com.dt.project.service.impl;

import com.dt.project.mapper.salesAmazonMapper.SalesAmazonAdOarMapper;
import com.dt.project.model.salesAmazon.SalesAmazonAdOar;
import com.dt.project.service.salesAmazonService.SalesAmazonAdOarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesAmazonAdOarServiceImpl implements SalesAmazonAdOarService {
    @Autowired
    private SalesAmazonAdOarMapper oarMapper;

    @Override
    public int saveSalesAmazonAdOarList(List<SalesAmazonAdOar> oarList) {
        return oarMapper.setSalesAmazonAdOarList(oarList);
    }

    @Override
    public List<SalesAmazonAdOar> serviceFindByListOar(SalesAmazonAdOar oar) {
        return oarMapper.findByListOar(oar);
    }
}

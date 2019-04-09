package com.dt.user.service.impl;

import com.dt.user.mapper.SalesAmazonMapper.SalesAmazonFbaBusinessreportMapper;
import com.dt.user.model.SalesAmazon.SalesAmazonFbaBusinessreport;
import com.dt.user.service.SalesAmazonService.SalesAmazonFbaBusinessreportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesAmazonFbaBusinessreportServiceImpl implements SalesAmazonFbaBusinessreportService {
    @Autowired
    private SalesAmazonFbaBusinessreportMapper busMapper;

    @Override
    public int addSalesAmazonAdBusList(List<SalesAmazonFbaBusinessreport> hlList) {
        return busMapper.addSalesAmazonAdHlList(hlList);
    }

    @Override
    public List<SalesAmazonFbaBusinessreport> serviceFindByListBus(SalesAmazonFbaBusinessreport rePort) {
        return busMapper.findByListBus(rePort);
    }
}

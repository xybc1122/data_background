package com.dt.project.service.impl;

import com.dt.project.mapper.salesAmazonMapper.SalesAmazonFbaBusinessreportMapper;
import com.dt.project.model.salesAmazon.SalesAmazonFbaBusinessreport;
import com.dt.project.service.salesAmazonService.SalesAmazonFbaBusinessreportService;
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

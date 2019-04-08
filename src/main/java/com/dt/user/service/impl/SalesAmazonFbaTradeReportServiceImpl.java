package com.dt.user.service.impl;

import com.dt.user.mapper.SalesAmazonMapper.SalesAmazonFbaTradeReportMapper;
import com.dt.user.model.SalesAmazonAd.SalesAmazonFbaTradeReport;
import com.dt.user.service.SalesAmazonService.SalesAmazonFbaTradeReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesAmazonFbaTradeReportServiceImpl implements SalesAmazonFbaTradeReportService {

    @Autowired
    private SalesAmazonFbaTradeReportMapper tradeReportMapper;

    @Override
    public int AddSalesAmazonAdTrdList(List<SalesAmazonFbaTradeReport> trdList) {
        return tradeReportMapper.AddSalesAmazonAdTrdList(trdList);
    }

    @Override
    public SalesAmazonFbaTradeReport getReport(Integer sId, String oId) {
        return tradeReportMapper.getReport(sId, oId);
    }

    @Override
    public List<SalesAmazonFbaTradeReport> serviceFindByListOrderReport(SalesAmazonFbaTradeReport report) {
        return tradeReportMapper.findByListOrderReport(report);
    }
}

package com.dt.project.service.impl;

import com.dt.project.mapper.salesAmazonMapper.SalesAmazonFbaRefundMapper;
import com.dt.project.model.salesAmazon.SalesAmazonFbaRefund;
import com.dt.project.service.salesAmazonService.SalesAmazonFbaRefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesAmazonFbaRefundServiceImpl implements SalesAmazonFbaRefundService {
    @Autowired
    private SalesAmazonFbaRefundMapper refundMapper;

    @Override
    public int serviceAddSalesAmazonAdRefundList(List<SalesAmazonFbaRefund> refundList) {
        return refundMapper.addSalesAmazonAdRefundList(refundList);
    }

    @Override
    public List<SalesAmazonFbaRefund> serviceFindByListRefund(SalesAmazonFbaRefund report) {
        return refundMapper.findByListRefund(report);
    }
}

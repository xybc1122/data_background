package com.dt.user.service.impl;

import com.dt.user.mapper.SalesAmazonMapper.SalesAmazonFbaRefundMapper;
import com.dt.user.model.SalesAmazon.SalesAmazonFbaRefund;
import com.dt.user.service.SalesAmazonService.SalesAmazonFbaRefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesAmazonFbaRefundServiceImpl implements SalesAmazonFbaRefundService {
    @Autowired
    private SalesAmazonFbaRefundMapper refundMapper;

    @Override
    public int AddSalesAmazonAdRefundList(List<SalesAmazonFbaRefund> refundList) {
        return refundMapper.AddSalesAmazonAdRefundList(refundList);
    }

    @Override
    public List<SalesAmazonFbaRefund> serviceFindByListRefund(SalesAmazonFbaRefund report) {
        return refundMapper.findByListRefund(report);
    }
}

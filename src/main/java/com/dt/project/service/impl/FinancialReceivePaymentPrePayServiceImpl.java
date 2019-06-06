package com.dt.project.service.impl;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.mapper.financialImportMapper.FinancialReceivePaymentPrePayMapper;
import com.dt.project.model.financial.FinancialReceivePaymentPrePay;
import com.dt.project.redis.RedisService;
import com.dt.project.service.FinancialReceivePaymentPrePayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName FinancialReceivePaymentPrePayServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/4 12:47
 **/
@Service
public class FinancialReceivePaymentPrePayServiceImpl implements FinancialReceivePaymentPrePayService {
    @Autowired
    private FinancialReceivePaymentPrePayMapper frppPayMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public ResponseBase serviceSelectByFRPaymentPrePay(FinancialReceivePaymentPrePay record) {
        return JsonData.setResultSuccess(frppPayMapper.selectByFRPaymentPrePay(record));
    }
}

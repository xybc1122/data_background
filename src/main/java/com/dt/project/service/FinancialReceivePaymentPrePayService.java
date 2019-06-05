package com.dt.project.service;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.financial.FinancialReceivePaymentPrePay;

/**
 * @ClassName FinancialReceivePaymentPrePayService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/4 12:46
 **/
public interface FinancialReceivePaymentPrePayService {


    /**
     * 查询预付单号
     *
     * @param record
     * @return
     */

    ResponseBase serviceSelectByFRPaymentPrePay(FinancialReceivePaymentPrePay record);
}

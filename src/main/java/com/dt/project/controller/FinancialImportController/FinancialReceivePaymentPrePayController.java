package com.dt.project.controller.financialImportController;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.FinancialReceivePaymentPrePay;
import com.dt.project.service.FinancialReceivePaymentPrePayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName FinancialReceivePaymentPrePayController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/4 12:48
 **/
@RestController
@RequestMapping("/api/v1/rpp")
public class FinancialReceivePaymentPrePayController {
    @Autowired
    private FinancialReceivePaymentPrePayService rppService;

    /**
     * 查询预付单号
     *
     * @return
     */
    @PostMapping("/getRPPay")
    public ResponseBase getRPPay(@RequestBody FinancialReceivePaymentPrePay rpp) {
        return rppService.serviceSelectByFRPaymentPrePay(rpp);
    }


}

package com.dt.user.controller.FinancialImportController;

import com.dt.user.config.ResponseBase;
import com.dt.user.model.FinancialSalesBalance;
import com.dt.user.service.FinancialImportService.FinancialSalesBalanceService;
import com.dt.user.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName FinancialSalesBalanceController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/4 11:20
 **/
@RestController
@RequestMapping("/api/v1/fsb")
public class FinancialSalesBalanceController {
    @Autowired
    private FinancialSalesBalanceService fsbService;

    /**
     * 查询财务结算报告
     *
     * @param fsb
     * @return
     */
    @PostMapping("/getFsbInfo")
    public ResponseBase geFsbInfo(@RequestBody FinancialSalesBalance fsb) {
        PageInfoUtils.setPage(fsb.getPageSize(), fsb.getCurrentPage());
        return PageInfoUtils.returnPage(fsbService.serviceFindByListFbs(fsb), fsb.getCurrentPage());
    }

}

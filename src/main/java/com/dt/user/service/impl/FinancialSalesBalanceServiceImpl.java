package com.dt.user.service.impl;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.mapper.FinancialImportMapper.FinancialSalesBalanceMapper;
import com.dt.user.model.BasePublicModel.BasicPublicArea;
import com.dt.user.model.FinancialSalesBalance;
import com.dt.user.service.BasePublicService.BasicPublicAreaService;
import com.dt.user.service.FinancialImportService.FinancialSalesBalanceService;
import com.dt.user.utils.PageInfoUtils;
import com.dt.user.utils.ReqUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FinancialSalesBalanceServiceImpl implements FinancialSalesBalanceService {

    @Autowired
    private FinancialSalesBalanceMapper fsbMapper;

    @Autowired
    private BasicPublicAreaService areaService;


    @Override
    public int addInfo(List<FinancialSalesBalance> fsbList, Integer tbId) {
        return fsbMapper.addInfo(fsbList, tbId);
    }

    @Override
    public ResponseBase serviceFindByListFbs(FinancialSalesBalance salesBalance) {
        PageInfoUtils.setPage(salesBalance.getPageSize(), salesBalance.getCurrentPage());
        //获得财务结算报告所有信息
        List<FinancialSalesBalance> fsbList = fsbMapper.findByListFbs(salesBalance);

        for (FinancialSalesBalance fsb : fsbList) {

        }
        return PageInfoUtils.returnPage(fsbList, salesBalance.getCurrentPage());
    }
}

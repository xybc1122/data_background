package com.dt.user.service.impl;

import com.dt.user.mapper.FinancialImportMapper.FinancialSalesBalanceMapper;
import com.dt.user.model.FinancialSalesBalance;
import com.dt.user.service.FinancialImportService.FinancialSalesBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialSalesBalanceServiceImpl implements FinancialSalesBalanceService {

    @Autowired
    private FinancialSalesBalanceMapper fsbMapper;

    @Override
    public int addInfo(List<FinancialSalesBalance> fsbList, Integer tbId) {
        return fsbMapper.addInfo(fsbList,tbId);
    }

    @Override
    public List<FinancialSalesBalance> serviceFindByListFbs(FinancialSalesBalance fsb) {
        return fsbMapper.findByListFbs(fsb);
    }
}

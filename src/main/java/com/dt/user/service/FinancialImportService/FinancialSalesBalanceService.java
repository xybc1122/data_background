package com.dt.user.service.FinancialImportService;

import com.dt.user.model.FinancialSalesBalance;

import java.util.List;

public interface FinancialSalesBalanceService {

    /**
     * 财务存入信息
     *
     * @param fsbList
     * @param tbId
     * @return
     */
    int addInfo(List<FinancialSalesBalance> fsbList, Integer tbId);

    /**
     * 查询财务导入数据
     *
     * @param fsb
     * @return
     */
    List<FinancialSalesBalance> serviceFindByListFbs(FinancialSalesBalance fsb);

}

package com.dt.project.mapper.financialImportMapper;

import com.dt.project.model.financial.FinancialSalesBalance;
import com.dt.project.provider.FinancialSalesBalanceProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface FinancialSalesBalanceMapper {
    /**
     * 插入财务数据
     *
     * @return
     */
    @InsertProvider(type = FinancialSalesBalanceProvider.class, method = "addInfo")
    int addInfo(@Param("fsbList") List<FinancialSalesBalance> fsbList, @Param("tbId") Integer menuId);


    /**
     * 查询财务 数据
     */
    @SelectProvider(type = FinancialSalesBalanceProvider.class, method = "getFbsInfo")
    List<FinancialSalesBalance> findByListFbs(FinancialSalesBalance fsb);


}

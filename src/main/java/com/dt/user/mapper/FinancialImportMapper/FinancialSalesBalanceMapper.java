package com.dt.user.mapper.FinancialImportMapper;

import com.dt.user.model.FinancialSalesBalance;
import com.dt.user.provider.FinancialSalesBalanceProvider;
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

package com.dt.project.service.salesAmazonService;

import com.dt.project.model.salesAmazon.SalesAmazonFbaMonthWarehouseFee;

import java.util.List;

/**
 * @ClassName SalesAmazonFbaMonthWarehouseFeeService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/17 10:28
 **/
public interface SalesAmazonFbaMonthWarehouseFeeService {

    /**
     * 存入月度仓储费用
     *
     * @return
     */
    int serviceSaveAmazonMonthWar(List<SalesAmazonFbaMonthWarehouseFee> mWarList);


    /**
     * 查询月度仓库费用数据
     */
    List<SalesAmazonFbaMonthWarehouseFee> serviceFindByListMWar(SalesAmazonFbaMonthWarehouseFee mWar);
}

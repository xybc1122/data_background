package com.dt.user.service.SalesAmazonService;

import com.dt.user.model.SalesAmazon.SalesAmazonFbaMonthWarehouseFee;

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
}

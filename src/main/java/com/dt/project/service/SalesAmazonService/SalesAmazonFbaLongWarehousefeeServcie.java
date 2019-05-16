package com.dt.project.service.SalesAmazonService;

import com.dt.project.model.SalesAmazon.SalesAmazonFbaLongWarehouseFee;

import java.util.List;

/**
 * @ClassName SalesAmazonFbaLongWarehousefeeServcie
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/9 15:54
 **/
public interface SalesAmazonFbaLongWarehousefeeServcie {

    /**
     * 新增数据
     *
     * @param longWarList
     * @return
     */
    int serviceSetAmazonLongWar(List<SalesAmazonFbaLongWarehouseFee> longWarList);


    /**
     * 查询场地仓库费
     *
     * @param fee
     * @return
     */
    List<SalesAmazonFbaLongWarehouseFee> serviceSelectByLongWarehouse(SalesAmazonFbaLongWarehouseFee fee);
}

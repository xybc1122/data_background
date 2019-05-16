package com.dt.project.service.SalesAmazonService;

import com.dt.project.model.SalesAmazon.SalesAmazonFbaHandlingFee;

import java.util.List;

/**
 * @ClassName SalesAmazonFbaHandlingFeeService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/18 9:20
 **/
public interface SalesAmazonFbaHandlingFeeService {


    /**
     * 存入订单处理费
     *
     * @return
     */
    int serviceSaveAmazonHandLFee(List<SalesAmazonFbaHandlingFee> hLFeeList);

    /**
     * 查询是否有文件在里面
     */
    String serviceGetExists(SalesAmazonFbaHandlingFee fee);

    /**
     * 查询订单处理费
     * @param hFee
     * @return
     */
    List<SalesAmazonFbaHandlingFee> serviceSelectByHandLFee(SalesAmazonFbaHandlingFee hFee);
}

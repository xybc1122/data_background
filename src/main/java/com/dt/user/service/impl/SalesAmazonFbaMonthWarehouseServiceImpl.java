package com.dt.user.service.impl;

import com.dt.user.mapper.SalesAmazonMapper.SalesAmazonFbaMonthWarehouseMapper;
import com.dt.user.service.SalesAmazonService.SalesAmazonFbaMonthWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SalesAmazonFbaMonthWarehouseServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/9 15:43
 **/
@Service
public class SalesAmazonFbaMonthWarehouseServiceImpl implements SalesAmazonFbaMonthWarehouseService {
    @Autowired
    private SalesAmazonFbaMonthWarehouseMapper monthWarehouseMapper;

}

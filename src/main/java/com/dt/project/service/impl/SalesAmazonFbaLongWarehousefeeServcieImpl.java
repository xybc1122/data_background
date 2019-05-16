package com.dt.project.service.impl;

import com.dt.project.mapper.SalesAmazonMapper.SalesAmazonFbaLongWarehousefeeMapper;
import com.dt.project.model.SalesAmazon.SalesAmazonFbaLongWarehouseFee;
import com.dt.project.service.SalesAmazonService.SalesAmazonFbaLongWarehousefeeServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SalesAmazonFbaLongWarehousefeeServcieImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/9 15:54
 **/
@Service
public class SalesAmazonFbaLongWarehousefeeServcieImpl implements SalesAmazonFbaLongWarehousefeeServcie {


    @Autowired
    private SalesAmazonFbaLongWarehousefeeMapper lWarMapper;


    @Override
    public int serviceSetAmazonLongWar(List<SalesAmazonFbaLongWarehouseFee> longWarList) {
        return lWarMapper.saveAmazonLongWar(longWarList);
    }

    @Override
    public List<SalesAmazonFbaLongWarehouseFee> serviceSelectByLongWarehouse(SalesAmazonFbaLongWarehouseFee fee) {
        return lWarMapper.selectByLongWarehouse(fee);
    }
}

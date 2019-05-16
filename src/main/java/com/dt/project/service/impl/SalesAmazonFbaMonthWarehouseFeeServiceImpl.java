package com.dt.project.service.impl;

import com.dt.project.mapper.SalesAmazonMapper.SalesAmazonFbaMonthWarehouseFeeMapper;
import com.dt.project.model.SalesAmazon.SalesAmazonFbaMonthWarehouseFee;
import com.dt.project.service.SalesAmazonService.SalesAmazonFbaMonthWarehouseFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SalesAmazonFbaMonthWarehouseFeeServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/17 10:28
 **/
@Service
public class SalesAmazonFbaMonthWarehouseFeeServiceImpl implements SalesAmazonFbaMonthWarehouseFeeService {
    @Autowired
    private SalesAmazonFbaMonthWarehouseFeeMapper feeMapper;


    @Override
    public int serviceSaveAmazonMonthWar(List<SalesAmazonFbaMonthWarehouseFee> mWarList) {
        return feeMapper.saveAmazonMonthWar(mWarList);
    }

    @Override
    public List<SalesAmazonFbaMonthWarehouseFee> serviceFindByListMWar(SalesAmazonFbaMonthWarehouseFee mWar) {
     return feeMapper.findByListMWar(mWar);
    }
}

package com.dt.project.service.impl;

import com.dt.project.mapper.salesAmazonMapper.SalesAmazonFbaHandlingFeeMapper;
import com.dt.project.model.salesAmazon.SalesAmazonFbaHandlingFee;
import com.dt.project.redis.RedisService;
import com.dt.project.service.salesAmazonService.SalesAmazonFbaHandlingFeeService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SalesAmazonFbaHandlingFeeServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/18 9:20
 **/
@Service
public class SalesAmazonFbaHandlingFeeServiceImpl implements SalesAmazonFbaHandlingFeeService {
    @Autowired
    private SalesAmazonFbaHandlingFeeMapper hFMapper;
    @Autowired
    private RedisService redisService;

    @Override
    public int serviceSaveAmazonHandLFee(List<SalesAmazonFbaHandlingFee> hLFeeList) {
        return hFMapper.saveAmazonHandLFee(hLFeeList);
    }

    @Override
    public String serviceGetExists(SalesAmazonFbaHandlingFee fee) {
        Long hdId = hFMapper.getExists(fee);
        if (hdId == null) {
            return "ok";
        }
        return null;
    }

    @Override
    public List<SalesAmazonFbaHandlingFee> serviceSelectByHandLFee(SalesAmazonFbaHandlingFee hFee) {
        PageInfoUtils.setPage(hFee.getPageSize(), hFee.getCurrentPage());
        return hFMapper.selectByHandLFee(hFee);
    }
}

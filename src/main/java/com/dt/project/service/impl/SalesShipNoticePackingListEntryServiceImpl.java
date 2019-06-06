package com.dt.project.service.impl;

import com.dt.project.mapper.salesAmazonMapper.SalesShipNoticePackingListEntryMapper;
import com.dt.project.model.salesAmazon.SalesShipNoticePackingListEntry;
import com.dt.project.redis.RedisService;
import com.dt.project.service.salesAmazonService.SalesShipNoticePackingListEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SalesShipNoticePackingListEntryServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/13 15:32
 **/
@Service
public class SalesShipNoticePackingListEntryServiceImpl implements SalesShipNoticePackingListEntryService {
    @Autowired
    private SalesShipNoticePackingListEntryMapper pLEMapper;
    @Autowired
    private RedisService redisService;

    @Override
    public List<SalesShipNoticePackingListEntry> serviceSelectPackingListEntry(SalesShipNoticePackingListEntry pLEntry) {
        //这里放入缓存
        pLEntry.setJsonArray(redisService.getRedisJson("",SalesShipNoticePackingListEntry.class));
        return pLEMapper.selectPackingListEntry(pLEntry);
    }
}

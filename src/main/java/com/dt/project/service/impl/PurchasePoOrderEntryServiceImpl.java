package com.dt.project.service.impl;

import com.dt.project.mapper.purchaseMapper.PurchasePoOrderEntryMapper;
import com.dt.project.model.purchasePo.PurchasePoOrderEntry;
import com.dt.project.redis.RedisService;
import com.dt.project.service.purchaseService.PurchasePoOrderEntryService;
import com.dt.project.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName PurchasePoOrderEntryServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/27 10:25
 **/
@Service
public class PurchasePoOrderEntryServiceImpl implements PurchasePoOrderEntryService {
    @Autowired
    private PurchasePoOrderEntryMapper poOrderEntryMapper;
    @Autowired
    private RedisService redisService;

    @Override
    public List<PurchasePoOrderEntry> serviceSelectByPoOrderEntry(PurchasePoOrderEntry record) {
        record.setJsonArray(redisService.getRedisJson("pPOE",PurchasePoOrderEntry.class));
        return poOrderEntryMapper.selectByPoOrderEntry(record);
    }

    @Override
    public int serviceInsertPoOrderEntry(List<PurchasePoOrderEntry> record) {
        int i = poOrderEntryMapper.insertPoOrderEntry(record);
        JsonUtils.saveResult(i);
        return i;
    }

    @Override
    public int serviceUpdateByPoOrderEntry(PurchasePoOrderEntry record) {
        int i = poOrderEntryMapper.updateByPoOrderEntry(record);
        JsonUtils.saveResult(i);
        return i;
    }
}

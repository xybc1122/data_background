package com.dt.user.service.impl;

import com.dt.user.mapper.SalesAmazonMapper.SalesAmazonFbaShipNoticeEntryMapper;
import com.dt.user.model.SalesAmazon.SalesAmazonFbaShipNoticeEntry;
import com.dt.user.service.SalesAmazonService.SalesAmazonFbaShipNoticeEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SalesAmazonFbaShipNoticeEntryServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/9 13:54
 **/
@Service
public class SalesAmazonFbaShipNoticeEntryServiceImpl implements SalesAmazonFbaShipNoticeEntryService {
    @Autowired
    private SalesAmazonFbaShipNoticeEntryMapper entryMapper;

    @Override
    public List<SalesAmazonFbaShipNoticeEntry> serviceFindByListAbandon(SalesAmazonFbaShipNoticeEntry entry) {
        return entryMapper.findByListAbandon(entry);
    }
}

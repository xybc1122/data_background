package com.dt.user.service.impl;

import com.dt.user.mapper.SalesAmazonMapper.SalesAmazonAHlMapper;
import com.dt.user.model.SalesAmazon.SalesAmazonAdHl;
import com.dt.user.service.SalesAmazonService.SalesAmazonAHlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesAmazonAHlServiceImpl implements SalesAmazonAHlService {
    @Autowired
    private SalesAmazonAHlMapper aHlMapper;

    @Override
    public int saveSalesAmazonAdHlList(List<SalesAmazonAdHl> hlList) {
        return aHlMapper.setSalesAmazonAdHlList(hlList);
    }

    @Override
    public List<SalesAmazonAdHl> serviceFindByListHl(SalesAmazonAdHl hl) {
        return aHlMapper.findByListHl(hl);
    }
}

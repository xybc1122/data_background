package com.dt.project.service.impl;

import com.dt.project.mapper.salesAmazonMapper.SalesAmazonAHlMapper;
import com.dt.project.model.salesAmazon.SalesAmazonAdHl;
import com.dt.project.service.salesAmazonService.SalesAmazonAHlService;
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

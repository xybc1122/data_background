package com.dt.user.service.impl;

import com.dt.user.dto.SkuDto;
import com.dt.user.mapper.BasePublicMapper.BasicPublicSkuMapper;
import com.dt.user.service.BasePublicService.BasicPublicSkuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicSalesSkuServiceImpl implements BasicPublicSkuService {
    @Autowired
    private BasicPublicSkuMapper skuMapper;

    @Override
    public List<SkuDto> serviceFindByListSku(SkuDto skuDto) {
        return skuMapper.findByListSku(skuDto);
    }


    @Override
    public Long selSkuId(Integer sId, Integer siteId, String skuName) {
        if (StringUtils.isEmpty(skuName)) {
            return 0L;
        }
        Long skuId = skuMapper.getSkuId(sId, siteId, skuName);
        if (skuId != null) {
            return skuId;
        }
        return null;
    }

    @Override
    public Long getAsinSkuId(Integer sId, Integer siteId, String sAsin) {
        if (StringUtils.isEmpty(sAsin)) {
            return 0L;
        }
        Long skuId = skuMapper.getAsinSkuId(sId, siteId, sAsin);
        if (skuId != null) {
            return skuId;
        }
        return null;
    }
}

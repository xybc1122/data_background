package com.dt.project.service.impl;

import com.dt.project.model.dto.SkuDto;
import com.dt.project.mapper.basePublicMapper.BasicPublicSkuMapper;
import com.dt.project.model.basePublicModel.BasicPublicSku;
import com.dt.project.service.basePublicService.BasicPublicSkuService;
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
        //结算报告没有SKU的设置0
        if (StringUtils.isEmpty(skuName)) {
            return null;
        }
        Long skuIdDb = skuMapper.getSkuId(sId, siteId, skuName);
        if (skuIdDb != null) {
            return skuIdDb;
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

    @Override
    public List<BasicPublicSku> serviceGetListKu(Integer sId, Integer siteId,String kuName) {
        return skuMapper.getListKu(sId, siteId,kuName);
    }

    @Override
    public List<BasicPublicSku> serviceSelAllSku() {
        return skuMapper.selAllSku();
    }
}

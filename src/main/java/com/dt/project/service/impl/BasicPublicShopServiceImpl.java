package com.dt.project.service.impl;

import com.dt.project.model.dto.ShopDto;
import com.dt.project.mapper.basePublicMapper.BasicPublicShopMapper;
import com.dt.project.model.basePublicModel.BasicPublicShop;
import com.dt.project.service.basePublicService.BasicPublicShopService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicPublicShopServiceImpl implements BasicPublicShopService {
    @Autowired
    private BasicPublicShopMapper shopMapper;

    @Override
    public List<ShopDto> findByListShop() {

        return shopMapper.findByListShop();
    }

    @Override
    public List<BasicPublicShop> getByListShopName(String rId) {
        return shopMapper.selectShopInfo(rId);
    }

    @Override
    public Integer getSId(String shopName) {
        if (StringUtils.isBlank(shopName)) {
            return null;
        }
        return shopMapper.getSId(shopName);
    }
}

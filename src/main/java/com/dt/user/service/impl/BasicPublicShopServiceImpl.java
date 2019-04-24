package com.dt.user.service.impl;

import com.dt.user.dto.ShopDto;
import com.dt.user.mapper.BasePublicMapper.BasicPublicShopMapper;
import com.dt.user.model.BasePublicModel.BasicPublicShop;
import com.dt.user.service.BasePublicService.BasicPublicShopService;
import com.dt.user.utils.ReqUtils;
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
    public List<BasicPublicShop> getByListShopName() {
        return shopMapper.getByListShopName(ReqUtils.getRoleId());
    }

    @Override
    public Integer getSId(String shopName) {
        if (StringUtils.isBlank(shopName)) {
            return null;
        }
        return shopMapper.getSId(shopName);
    }
}

package com.dt.user.service.impl;

import com.dt.user.mapper.GeneralQueryMapper;
import com.dt.user.model.BasePublicModel.BasicPublicWarehouse;
import com.dt.user.service.GeneralQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName GeneralQueryServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/11 11:18
 **/
@Service
public class GeneralQueryServiceImpl implements GeneralQueryService {
    @Autowired
    private GeneralQueryMapper queryMapper;

    @Override
    public Long serviceGetStatusId(Object obj) {
        if (obj instanceof BasicPublicWarehouse) {
            BasicPublicWarehouse war = (BasicPublicWarehouse) obj;
            return queryMapper.getStatusId("warehouse_id", war.getTreeId().longValue(), "basic_public_warehouse");
        }
        return null;
    }
}

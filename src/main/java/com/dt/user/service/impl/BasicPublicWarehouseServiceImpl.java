package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicPublicWarehouseMapper;
import com.dt.user.model.BasePublicModel.BasicPublicWarehouse;
import com.dt.user.model.ParentTree;
import com.dt.user.service.BasePublicService.BasicPublicWarehouseService;
import com.dt.user.store.TreeStructureStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasicPublicWarehouseServiceImpl implements BasicPublicWarehouseService {
    @Autowired
    private BasicPublicWarehouseMapper warehouseMapper;

    @Override
    public List<ParentTree> findByWarehouseInfo() {
        return TreeStructureStore.getTree(warehouseMapper.findByWarehouseInfo());
    }

}

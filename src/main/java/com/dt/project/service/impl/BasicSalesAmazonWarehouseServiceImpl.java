package com.dt.project.service.impl;

import com.dt.project.mapper.basePublicMapper.BasicSalesAmazonWarehouseMapper;
import com.dt.project.model.basePublic.BasicSalesAmazonWarehouse;
import com.dt.project.service.basePublicService.BasicSalesAmazonWarehouseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicSalesAmazonWarehouseServiceImpl implements BasicSalesAmazonWarehouseService {
    @Autowired
    private BasicSalesAmazonWarehouseMapper warehouseMapper;

    @Override
    public BasicSalesAmazonWarehouse getWarehouse(String fc) {
        if (StringUtils.isEmpty(fc)) {
            return null;
        }
        BasicSalesAmazonWarehouse warehouse = warehouseMapper.getWarehouse(fc);
        if (warehouse == null || warehouse.getSiteId() == null || warehouse.getAmazonWarehouseId() == null) {
            return null;
        }
        return warehouse;
    }

    @Override
    public List<BasicSalesAmazonWarehouse> serviceFindByListAmazonWarehouse(BasicSalesAmazonWarehouse warehouse) {
        return warehouseMapper.findByListAmazonWarehouse(warehouse);
    }
}

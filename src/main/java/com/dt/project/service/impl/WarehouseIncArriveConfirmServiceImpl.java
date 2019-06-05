package com.dt.project.service.impl;

import com.dt.project.config.ResponseBase;
import com.dt.project.mapper.warehouseMapper.WarehouseIncArriveConfirmMapper;
import com.dt.project.model.warehouse.WarehouseIncArriveConfirm;
import com.dt.project.service.warehouseService.WarehouseIncArriveConfirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName WarehouseIncArriveConfirmServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/5 17:45
 **/
@Service
public class WarehouseIncArriveConfirmServiceImpl implements WarehouseIncArriveConfirmService {
    @Autowired
    private WarehouseIncArriveConfirmMapper wiaCMapper;

    @Override
    public ResponseBase serviceSelectByWarIncArrive(Map<String, Object> objectMap) {
        wiaCMapper.selectByWarIncArrive(null);
        return null;
    }
}

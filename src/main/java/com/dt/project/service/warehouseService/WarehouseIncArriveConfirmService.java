package com.dt.project.service.warehouseService;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.warehouse.WarehouseIncArriveConfirm;

import java.util.Map;

/**
 * @ClassName WarehouseIncArriveConfirmService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/5 17:44
 **/
public interface WarehouseIncArriveConfirmService {


    /**
     * 查询到货确认
     *
     * @param objectMap
     * @return
     */
    ResponseBase serviceSelectByWarIncArrive(Map<String, Object> objectMap);
}

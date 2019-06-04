package com.dt.project.service.basePublicService;

import com.dt.project.config.ResponseBase;

/**
 * @ClassName BasicPublicWarehousePositionService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/4 9:16
 **/
public interface BasicPublicWarehousePositionService {


    /**
     * 查询仓补树形结构
     *
     * @return
     */
    ResponseBase serviceSelByWarehousePosition(String positionId);
}

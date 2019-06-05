package com.dt.project.controller.warehouseController;

import com.dt.project.config.ResponseBase;
import com.dt.project.service.warehouseService.WarehouseIncArriveConfirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName WarehouseIncArriveConfirmController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/5 17:46
 **/
@RequestMapping("/api/v1/wiac")
@RestController
public class WarehouseIncArriveConfirmController {

    @Autowired
    private WarehouseIncArriveConfirmService wIACService;


    /**
     * 查询到货确认
     *
     * @param objectMap
     * @return
     */

    @PostMapping("/getWIACList")
    public ResponseBase getWIACList(@RequestBody Map<String, Object> objectMap) {

        return wIACService.serviceSelectByWarIncArrive(objectMap);
    }
}

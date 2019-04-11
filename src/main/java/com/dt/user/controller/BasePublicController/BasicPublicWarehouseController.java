package com.dt.user.controller.BasePublicController;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.model.BasePublicModel.BasicPublicWarehouse;
import com.dt.user.model.ParentTree;
import com.dt.user.service.BasePublicService.BasicPublicWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/war")
public class BasicPublicWarehouseController {
    @Autowired
    private BasicPublicWarehouseService warehouseService;

    @GetMapping("/findByListWar")
    public ResponseBase findByListWar() {
        List<ParentTree> basicPublicSiteList = warehouseService.findByWarehouseInfo();
        return JsonData.setResultSuccess(basicPublicSiteList);
    }

    @PostMapping("/upWar")
    public ResponseBase upWarInfo(@RequestBody BasicPublicWarehouse warehouse) {
        return warehouseService.serviceUpWarehouses(warehouse);
    }

    @PostMapping("/delWar")
    public ResponseBase upWarInfo(@RequestBody Map<String, String> warMp) {
        return warehouseService.serviceDelWarehouses(warMp);
    }

    @PostMapping("/saveWar")
    public ResponseBase saveWarInfo(@RequestBody BasicPublicWarehouse warehouse) {
        return warehouseService.serviceSaveWarehouses(warehouse);
    }
}

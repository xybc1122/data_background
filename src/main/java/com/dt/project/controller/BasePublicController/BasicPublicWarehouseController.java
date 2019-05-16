package com.dt.project.controller.BasePublicController;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.model.BasePublicModel.BasicPublicWarehouse;
import com.dt.project.model.Parent.ParentTree;
import com.dt.project.service.BasePublicService.BasicPublicWarehouseService;
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
    public ResponseBase delWarInfo(@RequestBody Map<String, String> warMp) {
        return warehouseService.serviceDelWarehouses(warMp);
    }

    @PostMapping("/saveWar")
    public ResponseBase saveWarInfo(@RequestBody BasicPublicWarehouse warehouse) {
        return warehouseService.serviceSaveWarehouses(warehouse);
    }
}

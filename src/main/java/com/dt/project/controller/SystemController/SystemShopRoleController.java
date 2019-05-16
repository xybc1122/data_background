package com.dt.project.controller.SystemController;

import com.dt.project.config.ResponseBase;
import com.dt.project.service.SystemService.SystemShopRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName SystemShopRoleController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/24 13:54
 **/
@RestController
@RequestMapping("/api/v1/sr")
public class SystemShopRoleController {
    @Autowired
    private SystemShopRoleService shopRoleService;


    /**
     * 配置店铺角色权限
     *
     * @param sRMap
     * @return
     */
    @PostMapping("/saveShopRole")
    public ResponseBase setShopRole(@RequestBody Map<String, Object> sRMap) {
        return shopRoleService.serviceInsertShopRole(sRMap);
    }
}

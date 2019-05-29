package com.dt.project.service.systemService;

import com.dt.project.config.ResponseBase;

import java.util.Map;

/**
 * @ClassName SystemShopRoleService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/24 13:32
 **/
public interface SystemShopRoleService {


    /**
     * 添加店铺角色数据
     *
     * @param sRMap
     * @return
     */
    ResponseBase serviceInsertShopRole(Map<String, Object> sRMap);

}

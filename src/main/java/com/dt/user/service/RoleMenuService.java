package com.dt.user.service;

import com.dt.user.config.ResponseBase;
import java.util.List;
import java.util.Map;

public interface RoleMenuService {


    /**
     * 通过角色id来查询拥有的菜单
     **/
    List<String> gerRoleMenus(Integer rid);

    /**
     * 添加角色菜单/删除角色菜单
     *
     * @return
     */
    ResponseBase addAndDelMenu(Map<String, Object> menuMap);


}

package com.dt.project.service;

import com.dt.project.model.Menu;
import com.dt.project.model.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuService {

    /**
     * 查找用户所拥有的所有菜单
     */
    List<Menu> queryMenuList(UserInfo userInfo);


    /**
     * 通过角色查询菜单
     *
     * @param roleId
     * @return
     */
    List<Menu> findQueryByRoleId(@Param("roleId") Long roleId);


    /**
     * 新增菜单
     *
     * @param menu
     * @return
     */
    int addMenu(List<Menu> menu);

    /**
     * 菜单更新
     */
    int upMenu(Menu menu);
}


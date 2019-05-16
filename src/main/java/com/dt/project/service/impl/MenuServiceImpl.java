package com.dt.project.service.impl;

import com.dt.project.mapper.MenuMapper;
import com.dt.project.model.Menu;
import com.dt.project.model.UserInfo;
import com.dt.project.service.MenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;


    @Override
    public List<Menu> queryMenuList(UserInfo userInfo) {
        List<Menu> rootMenu = menuMapper.queryMenuList(userInfo);
        return getMenuList(rootMenu);
    }

    @Override
    public List<Menu> findQueryByRoleId(Long roleId) {
        List<Menu> rootMenu = menuMapper.findQueryByRoleId(roleId);
        return getMenuList(rootMenu);
    }


    @Override
    public int addMenu(List<Menu> menu) {
        return menuMapper.addMenu(menu);
    }

    @Override
    public int upMenu(Menu menu) {
        return menuMapper.upMenu(menu);
    }


    private List<Menu> getMenuList(List<Menu> rootMenu) {
        List<Menu> menuList = new ArrayList<>();
        List<Menu> childMenuList = new ArrayList<>();
        //先找到所有一级菜单
        if (rootMenu != null && rootMenu.size() > 0) {
            for (Menu aRootMenu : rootMenu) {
                //如果==0代表父菜单
                if (aRootMenu.getParentId() != null) {
                    if (aRootMenu.getParentId() == 0) {
                        menuList.add(aRootMenu);
                    } else {
                        childMenuList.add(aRootMenu);
                    }
                }
            }
            // 为一级菜单设置子菜单 getChild是递归调用的
            for (Menu menu : menuList) {
                menu.setChildMenus(getChild(menu.getMenuId(), childMenuList));
            }
        }
        return menuList;
    }

    //递归查找子菜单
    private List<Menu> getChild(Long menuId, List<Menu> childMenuList) {
        // 子菜单
        List<Menu> childList = new ArrayList<>();
        if (childMenuList != null && childMenuList.size() > 0) {
            for (Menu menu : childMenuList) {
                // 遍历所有节点，将子菜单getParentId与传过来的父menuId比较
                if (menu.getParentId().equals(menuId)) {
                    //如果是true 就添加到父菜单下面
                    childList.add(menu);
                }
            }
        }
        // 把子菜单的子菜单再循环一遍
        for (Menu childMenu : childList) {
            // 没有url子菜单还有子菜单
            if (StringUtils.isBlank(childMenu.getUrl())) {
                // 递归
                childMenu.setChildMenus(getChild(childMenu.getMenuId(), childMenuList));
            }
        }
        // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }
}

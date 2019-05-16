package com.dt.project.dto;


import java.util.List;
import java.util.Map;

public class MenuDto{

    /**
     * 存储List对象数组
     */
    List<Map<String,Object>> menuList;

    public List<Map<String, Object>> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Map<String, Object>> menuList) {
        this.menuList = menuList;
    }
}

package com.dt.project.service;

import com.dt.project.config.ResponseBase;

import java.util.Map;

public interface HeadMenuService {

    /**
     * 新增菜单关联数据
     */
    ResponseBase addHeadMenu(Map<String, Object> mhMap);

    /**
     * 删除菜单关联
     */
    ResponseBase delHeadMenu(Map<String, Object> mhMap);
}

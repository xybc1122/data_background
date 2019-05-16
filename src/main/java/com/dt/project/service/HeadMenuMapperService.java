package com.dt.project.service;

import com.dt.project.model.TbHeadMenu;

public interface HeadMenuMapperService {

    /**
     * 新增菜单关联数据
     */
    int addHeadMenu(TbHeadMenu tbHeadMenu);

    /**
     * 删除菜单关联
     */
    int delHeadMenu(TbHeadMenu tbHeadMenu);
}

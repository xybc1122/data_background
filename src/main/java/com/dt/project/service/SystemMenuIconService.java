package com.dt.project.service;

import com.dt.project.model.SystemMenuIcon;

import java.util.List;

/**
 * @ClassName SystemMenuIconService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/4 14:35
 **/
public interface SystemMenuIconService {

    /**
     * 获得所有icon
     *
     * @return
     */
    List<SystemMenuIcon> getIconList();

}

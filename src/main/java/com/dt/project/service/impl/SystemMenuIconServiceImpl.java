package com.dt.project.service.impl;

import com.dt.project.mapper.SystemMapper.SystemMenuIconMapper;
import com.dt.project.model.SystemMenuIcon;
import com.dt.project.service.SystemMenuIconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SystemMenuIconServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/4 14:35
 **/
@Service
public class SystemMenuIconServiceImpl implements SystemMenuIconService {
    @Autowired
    private SystemMenuIconMapper iconMapper;

    @Override
    public List<SystemMenuIcon> getIconList() {
        return iconMapper.getIconList();
    }
}

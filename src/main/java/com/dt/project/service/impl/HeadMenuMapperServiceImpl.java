package com.dt.project.service.impl;

import com.dt.project.mapper.HeadMenuMapper;
import com.dt.project.model.TbHeadMenu;
import com.dt.project.service.HeadMenuMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeadMenuMapperServiceImpl implements HeadMenuMapperService {

    @Autowired
    private HeadMenuMapper headMenuMapper;

    @Override
    public int addHeadMenu(TbHeadMenu tbHeadMenu) {
        return headMenuMapper.addHeadMenu(tbHeadMenu);
    }

    @Override
    public int delHeadMenu(TbHeadMenu tbHeadMenu) {
        return headMenuMapper.delHeadMenu(tbHeadMenu);
    }
}

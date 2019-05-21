package com.dt.project.service.impl;

import com.dt.project.exception.LsException;
import com.dt.project.mapper.HeadMenuMapper;
import com.dt.project.model.TbHeadMenu;
import com.dt.project.service.HeadMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HeadMenuMapperServiceImpl implements HeadMenuService {

    @Autowired
    private HeadMenuMapper headMenuMapper;

    @Override
    @Transactional
    public int addHeadMenu(TbHeadMenu tbHeadMenu) {
        int result = headMenuMapper.addHeadMenu(tbHeadMenu);
        if (result == 0) {
            throw new LsException("新增失败");
        }
        return result;
    }

    @Override
    @Transactional
    public int delHeadMenu(TbHeadMenu tbHeadMenu) {
        int result = headMenuMapper.delHeadMenu(tbHeadMenu);
        if (result == 0) {
            throw new LsException("删除失败");
        }
        return result;
    }
}

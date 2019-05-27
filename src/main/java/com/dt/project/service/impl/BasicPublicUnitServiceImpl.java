package com.dt.project.service.impl;

import com.dt.project.mapper.basePublicMapper.BasicPublicUnitMapper;
import com.dt.project.model.parent.ParentTree;
import com.dt.project.service.basePublicService.BasicPublicUnitService;
import com.dt.project.store.TreeStructureStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicPublicUnitServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/21 9:12
 **/
@Service
public class BasicPublicUnitServiceImpl implements BasicPublicUnitService {
    @Autowired
    private BasicPublicUnitMapper unitMapper;


    @Override
    public List<ParentTree> serviceFindByListUnit() {
        return TreeStructureStore.getTree(unitMapper.findByListUnit());
    }
}

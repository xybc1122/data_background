package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicPublicUnitMapper;
import com.dt.user.model.Parent.ParentTree;
import com.dt.user.service.BasePublicService.BasicPublicUnitService;
import com.dt.user.store.TreeStructureStore;
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

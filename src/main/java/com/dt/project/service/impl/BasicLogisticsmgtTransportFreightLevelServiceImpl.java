package com.dt.project.service.impl;

import com.dt.project.mapper.BasePublicMapper.BasicLogisticsmgtTransportFreightLevelMapper;
import com.dt.project.model.Parent.ParentTree;
import com.dt.project.service.BasePublicService.BasicLogisticsmgtTransportFreightLevelService;
import com.dt.project.store.TreeStructureStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicLogisticsmgtTransportFreightLevelServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/21 16:43
 **/
@Service
public class BasicLogisticsmgtTransportFreightLevelServiceImpl implements BasicLogisticsmgtTransportFreightLevelService {
    @Autowired
    private BasicLogisticsmgtTransportFreightLevelMapper levelMapper;


    @Override
    public List<ParentTree> serviceFindByFreightLevelInfo() {
        return TreeStructureStore.getTree(levelMapper.findByFreightLevelInfo());
    }
}

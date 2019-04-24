package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicLogisticsmgtTransportTypeMapper;
import com.dt.user.model.Parent.ParentTree;
import com.dt.user.service.BasePublicService.BasicLogisticsmgtTransportTypeService;
import com.dt.user.store.TreeStructureStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BasicLogisticsmgtTransportTypeServiceImpl implements BasicLogisticsmgtTransportTypeService {
    @Autowired
    private BasicLogisticsmgtTransportTypeMapper typeMapper;

    @Override
    public List<ParentTree> serviceFindByTypeInfo() {
        return TreeStructureStore.getTree(typeMapper.findByTypeInfo());

    }
}

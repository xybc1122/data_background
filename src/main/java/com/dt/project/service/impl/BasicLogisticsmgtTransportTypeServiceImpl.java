package com.dt.project.service.impl;

import com.dt.project.mapper.basePublicMapper.BasicLogisticsmgtTransportTypeMapper;
import com.dt.project.model.parent.ParentTree;
import com.dt.project.service.basePublicService.BasicLogisticsmgtTransportTypeService;
import com.dt.project.store.TreeStructureStore;
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

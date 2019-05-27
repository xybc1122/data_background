package com.dt.project.service.impl;

import com.dt.project.mapper.basePublicMapper.BasicLogisticsmgtTransportAbnormalTypeMapper;
import com.dt.project.model.parent.ParentTree;
import com.dt.project.service.basePublicService.BasicLogisticsmgtTransportAbnormalTypeService;
import com.dt.project.store.TreeStructureStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BasicLogisticsmgtTransportAbnormalTypeServiceImpl implements BasicLogisticsmgtTransportAbnormalTypeService {
    @Autowired
    private BasicLogisticsmgtTransportAbnormalTypeMapper abnormalTypeMapper;

    @Override
    public List<ParentTree> serviceFindByListAbnormalType() {
        return TreeStructureStore.getTree(abnormalTypeMapper.findByListAbnormalType());
    }

}

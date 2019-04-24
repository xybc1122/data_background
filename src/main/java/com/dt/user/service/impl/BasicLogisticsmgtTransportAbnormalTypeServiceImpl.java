package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicLogisticsmgtTransportAbnormalTypeMapper;
import com.dt.user.model.Parent.ParentTree;
import com.dt.user.service.BasePublicService.BasicLogisticsmgtTransportAbnormalTypeService;
import com.dt.user.store.TreeStructureStore;
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

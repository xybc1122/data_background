package com.dt.project.service.impl;

import com.dt.project.mapper.BasePublicMapper.BasicLogisticsmgtTransportValuationMethodMapper;
import com.dt.project.model.Parent.ParentTree;
import com.dt.project.service.BasePublicService.BasicLogisticsmgtTransportValuationMethodService;
import com.dt.project.store.TreeStructureStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicLogisticsmgtTransportValuationMethodServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/21 16:56
 **/
@Service
public class BasicLogisticsmgtTransportValuationMethodServiceImpl implements BasicLogisticsmgtTransportValuationMethodService {
    @Autowired
    private BasicLogisticsmgtTransportValuationMethodMapper valuationMethodMapper;

    @Override
    public List<ParentTree> serviceFindByValuationMethodInfo() {
        return TreeStructureStore.getTree(valuationMethodMapper.findByValuationMethodInfo());
    }
}

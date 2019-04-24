package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicLogisticsmgtTransportValuationMethodMapper;
import com.dt.user.model.Parent.ParentTree;
import com.dt.user.service.BasePublicService.BasicLogisticsmgtTransportValuationMethodService;
import com.dt.user.store.TreeStructureStore;
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

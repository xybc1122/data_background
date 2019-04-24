package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicLogisticsmgtTransportFreightLevelMapper;
import com.dt.user.model.Parent.ParentTree;
import com.dt.user.service.BasePublicService.BasicLogisticsmgtTransportFreightLevelService;
import com.dt.user.store.TreeStructureStore;
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

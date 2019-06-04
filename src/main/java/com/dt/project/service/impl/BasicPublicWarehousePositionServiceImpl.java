package com.dt.project.service.impl;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.mapper.basePublicMapper.BasicPublicWarehousePositionMapper;
import com.dt.project.model.parent.ParentTree;
import com.dt.project.service.basePublicService.BasicPublicWarehousePositionService;
import com.dt.project.store.TreeStructureStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BasicPublicWarehousePositionServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/4 9:17
 **/
@Service
public class BasicPublicWarehousePositionServiceImpl implements BasicPublicWarehousePositionService {
    @Autowired
    private BasicPublicWarehousePositionMapper bPWPMapper;


    @Override
    public ResponseBase serviceSelByWarehousePosition(String positionId) {
        List<ParentTree> treeList = TreeStructureStore.getTree(bPWPMapper.selectByWarehousePosition());
        if (positionId == null) {
            return JsonData.setResultSuccess(treeList);
        }
        List<ParentTree> parentTrees = new ArrayList<>();
        for (ParentTree tree : treeList) {
            if (tree.getTreeId().equals(Integer.parseInt(positionId))) {
                parentTrees.add(tree);
                break;
            }
        }
        return JsonData.setResultSuccess(parentTrees);
    }


}

package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicPublicWarehouseMapper;
import com.dt.user.model.BasePublicModel.BasicPublicWarehouse;
import com.dt.user.service.BasePublicService.BasicPublicWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasicPublicWarehouseServiceImpl implements BasicPublicWarehouseService {
    @Autowired
    private BasicPublicWarehouseMapper warehouseMapper;

    @Override
    public List<BasicPublicWarehouse> findByWarehouseInfo() {
        //一级目录
        List<BasicPublicWarehouse> firstArrList = new ArrayList<>();
        //子目录
        List<BasicPublicWarehouse> childArrList = new ArrayList<>();
        //数据库查询出来的数据
        List<BasicPublicWarehouse> result = warehouseMapper.findByWarehouseInfo();
        if (result != null && result.size() > 0) {
            for (BasicPublicWarehouse obj : result) {
                if (obj.getParentId() != null) {
                    //如果是父目录
                    if (obj.getParent()) {
                        firstArrList.add(obj);
                    } else {
                        childArrList.add(obj);
                    }
                }
            }
            // 为一级目录设置子目录 getChild是递归调用的
            if (firstArrList.size() > 0) {
                for (BasicPublicWarehouse firs : firstArrList) {
                    firs.setChildNode(getChild(firs.getWarehouseId(), childArrList));
                }
            }
        }
        return firstArrList;
    }

    private List<BasicPublicWarehouse> getChild(Integer id, List<BasicPublicWarehouse> childNodeList) {
        // 子菜单
        List<BasicPublicWarehouse> childList = new ArrayList<>();
        // 遍历childNodeList，找出所有的根节点和非根节点
        if (childNodeList != null && childNodeList.size() > 0) {
            for (BasicPublicWarehouse v : childNodeList) {
                //如果子跟父ID相同 就设置进去
                if (id.equals(v.getParentId())) {
                    childList.add(v);
                }
            }
        }
        //查询子节点
        if (childList.size() > 0) {
            for (BasicPublicWarehouse childV : childList) {
                childV.setChildNode(getChild(childV.getWarehouseId(), childList));
            }
        }
        return childList;
    }
}

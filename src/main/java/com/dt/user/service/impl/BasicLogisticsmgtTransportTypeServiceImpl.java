package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicLogisticsmgtTransportTypeMapper;
import com.dt.user.model.BasePublicModel.BasicLogisticsmgtTransportType;
import com.dt.user.service.BasePublicService.BasicLogisticsmgtTransportTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasicLogisticsmgtTransportTypeServiceImpl implements BasicLogisticsmgtTransportTypeService {
    @Autowired
    private BasicLogisticsmgtTransportTypeMapper typeMapper;

    @Override
    public List<BasicLogisticsmgtTransportType> findByTypeInfo() {
        //一级目录
        List<BasicLogisticsmgtTransportType> typeList = new ArrayList<>();
        //子目录
        List<BasicLogisticsmgtTransportType> childList = new ArrayList<>();
        //数据库查询出来的数据
        List<BasicLogisticsmgtTransportType> transportTypes = typeMapper.findByTypeInfo();
        if (transportTypes != null && transportTypes.size() > 0) {
            for (BasicLogisticsmgtTransportType transportType : transportTypes) {
                //如果是父目录
                if (transportType.getParentId() != null) {
                    if (transportType.getParent()) {
                        typeList.add(transportType);
                    } else {
                        childList.add(transportType);
                    }

                }
            }
            // 为一级目录设置子目录 getChild是递归调用的
            if (typeList.size() > 0) {
                for (BasicLogisticsmgtTransportType type : typeList) {
                    type.setChildTransportType(getChild(type.getTransportTypeId(), childList));
                }
            }
        }
        return typeList;
    }

    private List<BasicLogisticsmgtTransportType> getChild(Integer transportTypeId, List<BasicLogisticsmgtTransportType> childTypeList) {
        // 子菜单
        List<BasicLogisticsmgtTransportType> childList = new ArrayList<>();
        // 遍历childTypeList，找出所有的根节点和非根节点
        if (childTypeList != null && childTypeList.size() > 0) {
            for (BasicLogisticsmgtTransportType transportType : childTypeList) {
                //如果子跟父ID相同 就设置进去
                if (transportTypeId.equals(transportType.getParentId())) {
                    childList.add(transportType);
                }
            }
        }
        //查询子节点
        if (childList.size() > 0) {
            for (BasicLogisticsmgtTransportType type : childList) {
                type.setChildTransportType(getChild(type.getTransportTypeId(), childList));
            }
        }
        return childList;
    }
}

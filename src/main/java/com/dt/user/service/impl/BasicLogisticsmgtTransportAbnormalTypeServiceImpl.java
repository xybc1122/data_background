package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicLogisticsmgtTransportAbnormalTypeMapper;
import com.dt.user.model.BasePublicModel.BasicLogisticsmgtTransportAbnormalType;
import com.dt.user.model.BasePublicModel.BasicLogisticsmgtTransportType;
import com.dt.user.service.BasePublicService.BasicLogisticsmgtTransportAbnormalTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasicLogisticsmgtTransportAbnormalTypeServiceImpl implements BasicLogisticsmgtTransportAbnormalTypeService {
    @Autowired
    private BasicLogisticsmgtTransportAbnormalTypeMapper abnormalTypeMapper;

    @Override
    public List<BasicLogisticsmgtTransportAbnormalType> serviceFindByListAbnormalType() {
        //一级目录
        List<BasicLogisticsmgtTransportAbnormalType> abnormalTypeList = new ArrayList<>();
        //子目录
        List<BasicLogisticsmgtTransportAbnormalType> childList = new ArrayList<>();
        //数据库查询出来的数据
        List<BasicLogisticsmgtTransportAbnormalType> transportTypes =  abnormalTypeMapper.findByListAbnormalType();
        if (transportTypes != null && transportTypes.size() > 0) {
            for (BasicLogisticsmgtTransportAbnormalType abnormalType : transportTypes) {
                //如果是父目录
                if (abnormalType.getParentId() != null) {
                    if (abnormalType.getParent()) {
                        abnormalTypeList.add(abnormalType);
                    } else {
                        childList.add(abnormalType);
                    }

                }
            }
            // 为一级目录设置子目录 getChild是递归调用的
            if (abnormalTypeList.size() > 0) {
                for (BasicLogisticsmgtTransportAbnormalType type : abnormalTypeList) {
                    type.setChildNode(getChild(type.getTransportAbnormalTypeId(), childList));
                }
            }
        }
        return abnormalTypeList;
    }

    private List<BasicLogisticsmgtTransportAbnormalType> getChild(Integer abnormalTypeId, List<BasicLogisticsmgtTransportAbnormalType> childTypeList) {
        // 子菜单
        List<BasicLogisticsmgtTransportAbnormalType> childList = new ArrayList<>();
        // 遍历childTypeList，找出所有的根节点和非根节点
        if (childTypeList != null && childTypeList.size() > 0) {
            for (BasicLogisticsmgtTransportAbnormalType abnormalType : childTypeList) {
                //如果子跟父ID相同 就设置进去
                if (abnormalTypeId.equals(abnormalType.getParentId())) {
                    childList.add(abnormalType);
                }
            }
        }
        //查询子节点
        if (childList.size() > 0) {
            for (BasicLogisticsmgtTransportAbnormalType type : childList) {
                type.setChildNode(getChild(type.getTransportAbnormalTypeId(), childList));
            }
        }
        return childList;
    }

}

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
    public List<BasicLogisticsmgtTransportType> serviceFindByTypeInfo() {
        //一级目录
        List<BasicLogisticsmgtTransportType> firstArrList = new ArrayList<>();
        //子目录
        List<BasicLogisticsmgtTransportType> childArrList = new ArrayList<>();
        //数据库查询出来的数据
        List<BasicLogisticsmgtTransportType> result = typeMapper.findByTypeInfo();
        if (result != null && result.size() > 0) {
            for (BasicLogisticsmgtTransportType obj : result) {
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
                for (BasicLogisticsmgtTransportType firs : firstArrList) {
                    firs.setChildNode(getChild(firs.getTransportTypeId(), childArrList));
                }
            }
        }
        return firstArrList;
    }

    private List<BasicLogisticsmgtTransportType> getChild(Integer id, List<BasicLogisticsmgtTransportType> childNodeList) {
        // 子菜单
        List<BasicLogisticsmgtTransportType> childList = new ArrayList<>();
        // 遍历childNodeList，找出所有的根节点和非根节点
        if (childNodeList != null && childNodeList.size() > 0) {
            for (BasicLogisticsmgtTransportType v : childNodeList) {
                //如果子跟父ID相同 就设置进去
                if (id.equals(v.getParentId())) {
                    childList.add(v);
                }
            }
        }
        //查询子节点
        if (childList.size() > 0) {
            for (BasicLogisticsmgtTransportType childV : childList) {
                childV.setChildNode(getChild(childV.getTransportTypeId(), childList));
            }
        }
        return childList;
    }
}

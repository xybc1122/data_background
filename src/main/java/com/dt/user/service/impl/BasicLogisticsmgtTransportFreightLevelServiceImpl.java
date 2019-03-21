package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicLogisticsmgtTransportFreightLevelMapper;
import com.dt.user.model.BasePublicModel.BasicLogisticsmgtTransportFreightLevel;
import com.dt.user.service.BasePublicService.BasicLogisticsmgtTransportFreightLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<BasicLogisticsmgtTransportFreightLevel> serviceFindByFreightLevelInfo() {
        //一级目录
        List<BasicLogisticsmgtTransportFreightLevel> firstArrList = new ArrayList<>();
        //子目录
        List<BasicLogisticsmgtTransportFreightLevel> childArrList = new ArrayList<>();
        //数据库查询出来的数据
        List<BasicLogisticsmgtTransportFreightLevel> result = levelMapper.findByFreightLevelInfo();
        if (result != null && result.size() > 0) {
            for (BasicLogisticsmgtTransportFreightLevel obj : result) {
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
                for (BasicLogisticsmgtTransportFreightLevel firs : firstArrList) {
                    firs.setChildNode(getChild(firs.getTransportFreightLevelId(), childArrList));
                }
            }
        }
        return firstArrList;
    }

    private List<BasicLogisticsmgtTransportFreightLevel> getChild(Integer id, List<BasicLogisticsmgtTransportFreightLevel> childNodeList) {
        // 子菜单
        List<BasicLogisticsmgtTransportFreightLevel> childList = new ArrayList<>();
        // 遍历childNodeList，找出所有的根节点和非根节点
        if (childNodeList != null && childNodeList.size() > 0) {
            for (BasicLogisticsmgtTransportFreightLevel v : childNodeList) {
                //如果子跟父ID相同 就设置进去
                if (id.equals(v.getParentId())) {
                    childList.add(v);
                }
            }
        }
        //查询子节点
        if (childList.size() > 0) {
            for (BasicLogisticsmgtTransportFreightLevel childV : childList) {
                childV.setChildNode(getChild(childV.getTransportFreightLevelId(), childList));
            }
        }
        return childList;
    }
}

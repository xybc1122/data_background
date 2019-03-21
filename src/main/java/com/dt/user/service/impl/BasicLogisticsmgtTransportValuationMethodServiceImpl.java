package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicLogisticsmgtTransportValuationMethodMapper;
import com.dt.user.model.BasePublicModel.BasicLogisticsmgtTransportValuationMethod;
import com.dt.user.service.BasePublicService.BasicLogisticsmgtTransportValuationMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<BasicLogisticsmgtTransportValuationMethod> serviceFindByValuationMethodInfo() {
        //一级目录
        List<BasicLogisticsmgtTransportValuationMethod> firstArrList = new ArrayList<>();
        //子目录
        List<BasicLogisticsmgtTransportValuationMethod> childArrList = new ArrayList<>();
        //数据库查询出来的数据
        List<BasicLogisticsmgtTransportValuationMethod> result = valuationMethodMapper.findByValuationMethodInfo();
        if (result != null && result.size() > 0) {
            for (BasicLogisticsmgtTransportValuationMethod obj : result) {
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
                for (BasicLogisticsmgtTransportValuationMethod firs : firstArrList) {
                    firs.setChildNode(getChild(firs.getTransportValuationMethodId(), childArrList));
                }
            }
        }
        return firstArrList;
    }

    private List<BasicLogisticsmgtTransportValuationMethod> getChild(Integer id, List<BasicLogisticsmgtTransportValuationMethod> childNodeList) {
        // 子菜单
        List<BasicLogisticsmgtTransportValuationMethod> childList = new ArrayList<>();
        // 遍历childNodeList，找出所有的根节点和非根节点
        if (childNodeList != null && childNodeList.size() > 0) {
            for (BasicLogisticsmgtTransportValuationMethod v : childNodeList) {
                //如果子跟父ID相同 就设置进去
                if (id.equals(v.getParentId())) {
                    childList.add(v);
                }
            }
        }
        //查询子节点
        if (childList.size() > 0) {
            for (BasicLogisticsmgtTransportValuationMethod childV : childList) {
                childV.setChildNode(getChild(childV.getTransportValuationMethodId(), childList));
            }
        }
        return childList;
    }
}

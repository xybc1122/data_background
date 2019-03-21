package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicPublicUnitMapper;
import com.dt.user.model.BasePublicModel.BasicPublicUnit;
import com.dt.user.service.BasePublicService.BasicPublicUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BasicPublicUnitServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/21 9:12
 **/
@Service
public class BasicPublicUnitServiceImpl implements BasicPublicUnitService {
    @Autowired
    private BasicPublicUnitMapper unitMapper;


    @Override
    public List<BasicPublicUnit> serviceFindByListUnit() {
        //一级目录
        List<BasicPublicUnit> firstArrList = new ArrayList<>();
        //子目录
        List<BasicPublicUnit> childArrList = new ArrayList<>();

        List<BasicPublicUnit> result = unitMapper.findByListUnit();

        if (result != null && result.size() > 0) {
            for (BasicPublicUnit obj : result) {
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
                for (BasicPublicUnit firs : firstArrList) {
                    firs.setChildNode(getChild(firs.getUnitId(), childArrList));
                }
            }
        }
        return firstArrList;
    }

    private List<BasicPublicUnit> getChild(Integer id, List<BasicPublicUnit> childNodeList) {
        // 子菜单
        List<BasicPublicUnit> childList = new ArrayList<>();
        // 遍历childNodeList，找出所有的根节点和非根节点
        if (childNodeList != null && childNodeList.size() > 0) {
            for (BasicPublicUnit v : childNodeList) {
                //如果子跟父ID相同 就设置进去
                if (id.equals(v.getParentId())) {
                    childList.add(v);
                }
            }
        }
        //查询子节点
        if (childList.size() > 0) {
            for (BasicPublicUnit childV : childList) {
                childV.setChildNode(getChild(childV.getUnitId(), childList));
            }
        }
        return childList;
    }
}

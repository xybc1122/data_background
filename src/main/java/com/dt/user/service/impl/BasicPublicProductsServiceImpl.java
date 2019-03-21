package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicPublicProductsMapper;
import com.dt.user.model.BasePublicModel.BasicPublicProducts;
import com.dt.user.service.BasePublicService.BasicPublicProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasicPublicProductsServiceImpl implements BasicPublicProductsService {
    @Autowired
    private BasicPublicProductsMapper productsMapper;

    @Override
    public List<BasicPublicProducts> findByProductsInfo() {
        //一级目录
        List<BasicPublicProducts> firstArrList = new ArrayList<>();
        //子目录
        List<BasicPublicProducts> childArrList = new ArrayList<>();
        //数据库查询出来的数据
        List<BasicPublicProducts> result = productsMapper.findByProductsInfo();
        if (result != null && result.size() > 0) {
            for (BasicPublicProducts obj : result) {
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
                for (BasicPublicProducts firs : firstArrList) {
                    firs.setChildNode(getChild(firs.getProductsId(), childArrList));
                }
            }
        }
        return firstArrList;

    }
    private List<BasicPublicProducts> getChild(Integer id, List<BasicPublicProducts> childNodeList) {
        // 子菜单
        List<BasicPublicProducts> childList = new ArrayList<>();
        // 遍历childNodeList，找出所有的根节点和非根节点
        if (childNodeList != null && childNodeList.size() > 0) {
            for (BasicPublicProducts v : childNodeList) {
                //如果子跟父ID相同 就设置进去
                if (id.equals(v.getParentId())) {
                    childList.add(v);
                }
            }
        }
        //查询子节点
        if (childList.size() > 0) {
            for (BasicPublicProducts childV : childList) {
                childV.setChildNode(getChild(childV.getProductsId(), childList));
            }
        }
        return childList;
    }
}

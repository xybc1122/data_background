package com.dt.user.store;


import com.dt.user.model.ParentTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TreeStructureStore
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/26 10:12
 **/
public class TreeStructureStore {

    /**
     * 树形数据转换
     * @param result
     * @return
     */
    public static List<ParentTree> getTree(List<ParentTree> result) {
        //一级目录
        List<ParentTree> firstArrList = new ArrayList<>();
        //子目录
        List<ParentTree> childArrList = new ArrayList<>();
        if (result != null && result.size() > 0) {
            for (ParentTree obj : result) {
                if (obj.getParentId() != null) {
                    //是否为父目录
                    if (obj.getParentNodeIs() != null) {
                        //如果是父目录
                        if (obj.getParentNodeIs()) {
                            firstArrList.add(obj);
                        } else {
                            childArrList.add(obj);
                        }
                    }
                }
            }
            // 为一级目录设置子目录 getChild是递归调用的
            if (firstArrList.size() > 0) {
                for (ParentTree firs : firstArrList) {
                    firs.setChildNode(getChild(firs.getTreeId(), childArrList));
                }
            }
        }
        return firstArrList;

    }

    private static List<ParentTree> getChild(Integer id, List<ParentTree> childNodeList) {
        // 子菜单
        List<ParentTree> childList = new ArrayList<>();
        // 遍历childNodeList，找出所有的根节点和非根节点
        if (childNodeList != null && childNodeList.size() > 0) {
            for (ParentTree v : childNodeList) {
                //如果子跟父ID相同 就设置进去
                if (id.equals(v.getParentId())) {
                    childList.add(v);
                }
            }
        }
        //查询子节点
        if (childList.size() > 0) {
            for (ParentTree childV : childList) {
                childV.setChildNode(getChild(childV.getTreeId(), childList));
            }
        }
        return childList;
    }
}

package com.dt.user.model;

import java.util.List;

/**
 * @ClassName ParentTree
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/26 10:47
 **/
public class ParentTree {
    /**
     * 编号
     */
    private Integer number;
    /**
     * 子节点
     */
    private List<ParentTree> childNode;
    /**
     * 父ID
     */
    private Integer parentId;
    /**
     * 请求路径
     */
    private String path;
    /**
     * 是否为父类
     */
    private Boolean isParent;
    /**
     * 树ID
     */
    private Integer treeId;


    private String treeName;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getTreeId() {
        return treeId;
    }

    public void setTreeId(Integer treeId) {
        this.treeId = treeId;
    }

    public String getTreeName() {
        return treeName;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }

    public List<ParentTree> getChildNode() {
        return childNode;
    }

    public void setChildNode(List<ParentTree> childNode) {
        this.childNode = childNode;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Boolean getParent() {
        return isParent;
    }

    public void setParent(Boolean parent) {
        isParent = parent;
    }
}

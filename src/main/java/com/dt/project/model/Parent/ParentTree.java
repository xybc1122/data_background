package com.dt.project.model.Parent;

import com.dt.project.model.SystemLogStatus;

import java.util.List;

/**
 * 树形结构父类
 *
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
    private Boolean parentNodeIs;
    /**
     * 树ID
     */
    private Integer treeId;

    /**
     * 树节点ID
     */
    private String treeName;
    /**
     * 是否删除
     */
    private Integer delOrNot;
    /**
     * 版本标识
     */
    private Integer version;
    /**
     * 状态ID
     */
    private Long statusId;


    //状态对象
    private SystemLogStatus systemLogStatus;

    public SystemLogStatus getSystemLogStatus() {
        return systemLogStatus;
    }

    public void setSystemLogStatus(SystemLogStatus systemLogStatus) {
        this.systemLogStatus = systemLogStatus;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getDelOrNot() {
        return delOrNot;
    }

    public void setDelOrNot(Integer delOrNot) {
        this.delOrNot = delOrNot;
    }

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

    public Boolean getParentNodeIs() {
        return parentNodeIs;
    }

    public void setParentNodeIs(Boolean parentNodeIs) {
        this.parentNodeIs = parentNodeIs;
    }
}

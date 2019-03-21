package com.dt.user.model.BasePublicModel;

import com.dt.user.model.ParentSysTemLog;
import com.dt.user.model.SystemLogStatus;

import java.util.List;

/**
 * 产品类目
 */
public class BasicPublicProducts extends ParentSysTemLog {

    private Integer productsId;
    private Integer number;
    private String productsName;
    private Integer parentId;
    private String productsPath;
    private Boolean isParent;

    // 子目录
    private List<BasicPublicProducts> childNode;

    public Integer getProductsId() {
        return productsId;
    }

    public void setProductsId(Integer productsId) {
        this.productsId = productsId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getProductsName() {
        return productsName;
    }

    public void setProductsName(String productsName) {
        this.productsName = productsName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getProductsPath() {
        return productsPath;
    }

    public void setProductsPath(String productsPath) {
        this.productsPath = productsPath;
    }

    public Boolean getParent() {
        return isParent;
    }

    public void setParent(Boolean parent) {
        isParent = parent;
    }

    public List<BasicPublicProducts> getChildNode() {
        return childNode;
    }

    public void setChildNode(List<BasicPublicProducts> childNode) {
        this.childNode = childNode;
    }
}

package com.dt.user.model.BasePublicModel;

import com.dt.user.model.ParentSysTemLog;

import java.util.List;

/**
 * 仓库
 */
public class BasicPublicWarehouse extends ParentSysTemLog {

    private Integer warehouseId;
    private Integer number;
    private String warehouseName;
    private String warehouseAddress;
    private Boolean isParent;
    private Integer parentId;
    // 子目录
    private List<BasicPublicWarehouse> childNode;

    public List<BasicPublicWarehouse> getChildNode() {
        return childNode;
    }

    public void setChildNode(List<BasicPublicWarehouse> childNode) {
        this.childNode = childNode;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }


    public Boolean getParent() {
        return isParent;
    }

    public void setParent(Boolean parent) {
        isParent = parent;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}

package com.dt.project.model.basePublic;

import com.dt.project.model.parent.ParentTree;

/**
 * 仓库
 */
public class BasicPublicWarehouse extends ParentTree {
    /**
     * 仓库地址
     */
    private String warehouseAddress;

    /**
     * 仓位ID
     */
    private Long positionId;

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }
}

package com.dt.user.model.BasePublicModel;

import com.dt.user.model.ParentTree;

/**
 * 仓库
 */
public class BasicPublicWarehouse extends ParentTree {

    private Integer number;
    private String warehouseAddress;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }
}

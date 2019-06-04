package com.dt.project.model.basePublic;

import com.dt.project.model.parent.ParentTree;

/**
 * 仓位
 */
public class BasicPublicWarehousePosition extends ParentTree {


    /**
     * 仓位地址
     */
    private String positionAddress;


    public String getPositionAddress() {
        return positionAddress;
    }

    public void setPositionAddress(String positionAddress) {
        this.positionAddress = positionAddress;
    }
}
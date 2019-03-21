package com.dt.user.model.BasePublicModel;

import com.dt.user.model.ParentSysTemLog;

/**
 * 刷单类型
 */
public class BasicSalesPublicBrushType extends ParentSysTemLog {

    private Integer brushTypeId;
    private Integer number;
    private String brushTypeName;

    public Integer getBrushTypeId() {
        return brushTypeId;
    }

    public void setBrushTypeId(Integer brushTypeId) {
        this.brushTypeId = brushTypeId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getBrushTypeName() {
        return brushTypeName;
    }

    public void setBrushTypeName(String brushTypeName) {
        this.brushTypeName = brushTypeName;
    }
}

package com.dt.project.model.BasePublicModel;

import com.dt.project.model.Parent.ParentSysTemLog;

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

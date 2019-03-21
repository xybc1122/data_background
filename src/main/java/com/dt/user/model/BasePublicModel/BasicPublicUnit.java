package com.dt.user.model.BasePublicModel;

import com.dt.user.model.ParentSysTemLog;

import java.util.List;

/**
 * 计量单位
 */
public class BasicPublicUnit extends ParentSysTemLog {

    private Integer unitId;
    private Integer number;
    private String unitName;
    private Integer parentId;
    private String unitNameEng;
    private String unitNameEngS;
    private String unitShortNameEng;
    private Boolean isParent;
    private List<BasicPublicUnit> ChildNode;

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getUnitNameEng() {
        return unitNameEng;
    }

    public void setUnitNameEng(String unitNameEng) {
        this.unitNameEng = unitNameEng;
    }

    public String getUnitNameEngS() {
        return unitNameEngS;
    }

    public void setUnitNameEngS(String unitNameEngS) {
        this.unitNameEngS = unitNameEngS;
    }

    public String getUnitShortNameEng() {
        return unitShortNameEng;
    }

    public void setUnitShortNameEng(String unitShortNameEng) {
        this.unitShortNameEng = unitShortNameEng;
    }

    public Boolean getParent() {
        return isParent;
    }

    public void setParent(Boolean parent) {
        isParent = parent;
    }

    public List<BasicPublicUnit> getChildNode() {
        return ChildNode;
    }

    public void setChildNode(List<BasicPublicUnit> childNode) {
        ChildNode = childNode;
    }
}

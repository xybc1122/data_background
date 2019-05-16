package com.dt.project.model.BasePublicModel;

import com.dt.project.model.Parent.ParentTree;

/**
 * 计量单位
 */
public class BasicPublicUnit extends ParentTree {

    private String unitNameEng;
    private String unitNameEngS;
    private String unitShortNameEng;

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
}

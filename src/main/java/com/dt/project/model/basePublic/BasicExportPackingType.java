package com.dt.project.model.basePublic;

import com.dt.project.model.parent.ParentSysTemLog;

/**
 * 包装种类
 */
public class BasicExportPackingType extends ParentSysTemLog {

    private Integer packingTypeId;
    private String cNumber;
    private String packingTypeName;

    public Integer getPackingTypeId() {
        return packingTypeId;
    }

    public void setPackingTypeId(Integer packingTypeId) {
        this.packingTypeId = packingTypeId;
    }

    public String getcNumber() {
        return cNumber;
    }

    public void setcNumber(String cNumber) {
        this.cNumber = cNumber;
    }

    public String getPackingTypeName() {
        return packingTypeName;
    }

    public void setPackingTypeName(String packingTypeName) {
        this.packingTypeName = packingTypeName;
    }
}

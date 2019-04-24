package com.dt.user.model.BasePublicModel;

import com.dt.user.model.Parent.ParentSysTemLog;

/**
 * 清关类型
 */
public class BasicExportGrosscustomsType extends ParentSysTemLog {

    private Integer grosscustomsTypeId;
    private Integer number;
    private String grosscustomsTypeName;

    public Integer getGrosscustomsTypeId() {
        return grosscustomsTypeId;
    }

    public void setGrosscustomsTypeId(Integer grosscustomsTypeId) {
        this.grosscustomsTypeId = grosscustomsTypeId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getGrosscustomsTypeName() {
        return grosscustomsTypeName;
    }

    public void setGrosscustomsTypeName(String grosscustomsTypeName) {
        this.grosscustomsTypeName = grosscustomsTypeName;
    }
}

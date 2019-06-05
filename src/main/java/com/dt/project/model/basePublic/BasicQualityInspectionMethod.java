package com.dt.project.model.basePublic;

import com.dt.project.model.parent.ParentSysTemLog;

/**
 * 检验方式
 */
public class BasicQualityInspectionMethod extends ParentSysTemLog {

    private Integer inspectionMethodId;

    private String number;

    private String inspectionQuarantineName;

    public Integer getInspectionMethodId() {
        return inspectionMethodId;
    }

    public void setInspectionMethodId(Integer inspectionMethodId) {
        this.inspectionMethodId = inspectionMethodId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getInspectionQuarantineName() {
        return inspectionQuarantineName;
    }

    public void setInspectionQuarantineName(String inspectionQuarantineName) {
        this.inspectionQuarantineName = inspectionQuarantineName;
    }
}
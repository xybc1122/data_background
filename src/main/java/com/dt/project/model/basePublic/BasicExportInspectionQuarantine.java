package com.dt.project.model.basePublic;


import com.dt.project.model.parent.ParentSysTemLog;

/**
 * 检验检疫类别
 */
public class BasicExportInspectionQuarantine extends ParentSysTemLog {

    private Integer inspectionQuarantineId;
    private String cNumber;
    private String inspectionQuarantineName;

    public Integer getInspectionQuarantineId() {
        return inspectionQuarantineId;
    }

    public void setInspectionQuarantineId(Integer inspectionQuarantineId) {
        this.inspectionQuarantineId = inspectionQuarantineId;
    }

    public String getcNumber() {
        return cNumber;
    }

    public void setcNumber(String cNumber) {
        this.cNumber = cNumber;
    }

    public String getInspectionQuarantineName() {
        return inspectionQuarantineName;
    }

    public void setInspectionQuarantineName(String inspectionQuarantineName) {
        this.inspectionQuarantineName = inspectionQuarantineName;
    }
}

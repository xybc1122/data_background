package com.dt.project.model.basePublic;


import com.dt.project.model.parent.ParentSysTemLog;

/**
 * 监管类型
 */
public class BasicExportMonitoringCondition extends ParentSysTemLog {

    private Integer monitoringConditionId;
    private String cNumber;
    private String monitoringConditionName;

    public Integer getMonitoringConditionId() {
        return monitoringConditionId;
    }

    public void setMonitoringConditionId(Integer monitoringConditionId) {
        this.monitoringConditionId = monitoringConditionId;
    }

    public String getcNumber() {
        return cNumber;
    }

    public void setcNumber(String cNumber) {
        this.cNumber = cNumber;
    }

    public String getMonitoringConditionName() {
        return monitoringConditionName;
    }

    public void setMonitoringConditionName(String monitoringConditionName) {
        this.monitoringConditionName = monitoringConditionName;
    }
}

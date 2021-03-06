package com.dt.project.model.basePublic;


import com.dt.project.model.parent.ParentSysTemLog;

/**
 * 离职类型
 */
public class BasicHrLeaveType extends ParentSysTemLog {

    private Integer leaveTypeId;
    private Integer number;
    private String leaveTypeName;

    public Integer getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(Integer leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getLeaveTypeName() {
        return leaveTypeName;
    }

    public void setLeaveTypeName(String leaveTypeName) {
        this.leaveTypeName = leaveTypeName;
    }
}

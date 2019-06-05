package com.dt.project.model.warehouse;

import com.dt.project.model.parent.ParentSysTemLog;

/**
 * 到货确认
 */
public class WarehouseIncArriveConfirm extends ParentSysTemLog {
    private Long acId;

    private Long date;

    private String no;

    private String explanation;

    private Integer deptId;

    private Integer empId;

    private Integer mangerId;

    private Boolean children;

    private Integer closed;

    private String closeUser;

    private Long closeDate;

    private Integer orderConfirm;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 业务员名称
     */
    private String empName;
    /**
     * 主管名称
     */
    private String mangerName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getMangerName() {
        return mangerName;
    }

    public void setMangerName(String mangerName) {
        this.mangerName = mangerName;
    }

    public Long getAcId() {
        return acId;
    }

    public void setAcId(Long acId) {
        this.acId = acId;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation == null ? null : explanation.trim();
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getMangerId() {
        return mangerId;
    }

    public void setMangerId(Integer mangerId) {
        this.mangerId = mangerId;
    }

    public Boolean getChildren() {
        return children;
    }

    public void setChildren(Boolean children) {
        this.children = children;
    }

    public Integer getClosed() {
        return closed;
    }

    public void setClosed(Integer closed) {
        this.closed = closed;
    }

    public String getCloseUser() {
        return closeUser;
    }

    public void setCloseUser(String closeUser) {
        this.closeUser = closeUser == null ? null : closeUser.trim();
    }

    public Long getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Long closeDate) {
        this.closeDate = closeDate;
    }

    public Integer getOrderConfirm() {
        return orderConfirm;
    }

    public void setOrderConfirm(Integer orderConfirm) {
        this.orderConfirm = orderConfirm;
    }
}
package com.dt.user.model;

import java.io.Serializable;
import java.util.List;

/**
 * 状态记录表
 */
public class SystemLogStatus implements Serializable {

    private Long statusId;
    private String remark;
    private Integer status;
    private Long createDate;
    private String createUser;
    private Long modifyDate;
    private String modifyUser;
    private Long auditDate;
    private String auditUser;

    /**
     * 创建时间范围查询变量
     */
    private List<Long> createDates;

    /**
     * 修改日期范围查询变量
     */
    private List<Long> modifyDates;

    /**
     * 审核时间范围查询变量
     */
    private List<Long> auditDates;



    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Long getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Long modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Long getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Long auditDate) {
        this.auditDate = auditDate;
    }

    public String getAuditUser() {
        return auditUser;
    }

    public void setAuditUser(String auditUser) {
        this.auditUser = auditUser;
    }

    public List<Long> getCreateDates() {
        return createDates;
    }

    public void setCreateDates(List<Long> createDates) {
        this.createDates = createDates;
    }

    public List<Long> getModifyDates() {
        return modifyDates;
    }

    public void setModifyDates(List<Long> modifyDates) {
        this.modifyDates = modifyDates;
    }

    public List<Long> getAuditDates() {
        return auditDates;
    }

    public void setAuditDates(List<Long> auditDates) {
        this.auditDates = auditDates;
    }

}

package com.dt.project.model.parent;

/**
 * @ClassName ParentConfTable
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/24 16:07
 **/

import java.util.List;

/**
 * 配置表父类
 */
public class ParentConfTable {


    private String remark;
    private Integer status;
    private Long createDate;
    private String createUser;
    private Long modifyDate;
    private String modifyUser;
    private Long auditDate;
    private String auditUser;
    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 显示的页数
     */
    private Integer pageSize;

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

    /**
     * 版本标识
     */
    private Integer version;

    public ParentConfTable() {


    }

    public ParentConfTable(Long createDate, String createUser) {
        this.createDate = createDate;
        this.createUser = createUser;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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
}

package com.dt.user.model.Parent;


import com.dt.user.model.SystemLogStatus;

/**
 * 其余一些有statusId类的父类
 */
public class ParentSysTemLog {
    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 显示的页数
     */
    private Integer pageSize;

    //状态对象
    private SystemLogStatus systemLogStatus;

    /**
     * 状态ID
     */
    private Long statusId;
    /**
     * 是否删除标志
     */
    private Integer delOrNot;
    /**
     * 版本标识
     */
    private Integer version;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getDelOrNot() {
        return delOrNot;
    }

    public void setDelOrNot(Integer delOrNot) {
        this.delOrNot = delOrNot;
    }


    public SystemLogStatus getSystemLogStatus() {
        return systemLogStatus;
    }

    public void setSystemLogStatus(SystemLogStatus systemLogStatus) {
        this.systemLogStatus = systemLogStatus;
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

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }


}

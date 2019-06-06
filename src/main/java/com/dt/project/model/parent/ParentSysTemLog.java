package com.dt.project.model.parent;


import com.alibaba.fastjson.JSONArray;
import com.dt.project.model.SystemLogStatus;

import java.util.List;

/**
 * 有statusId类的父类
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

    /**
     * 动态查询
     */
    private JSONArray jsonArray;

    /**
     * in查询存储id
     */
    private List<Long> inList;

    /**
     * 一对多 接收对象  查询
     */
    private Object entry;
    /**
     * 一对多对象存储
     */
    private List<?> entryList;

    public Object getEntry() {
        return entry;
    }

    public void setEntry(Object entry) {
        this.entry = entry;
    }

    public List<?> getEntryList() {
        return entryList;
    }

    public void setEntryList(List<?> entryList) {
        this.entryList = entryList;
    }

    public List<Long> getInList() {
        return inList;
    }

    public void setInList(List<Long> inList) {
        this.inList = inList;
    }

    public JSONArray getJsonArray() {
        return jsonArray;
    }

    public void setJsonArray(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
    }

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

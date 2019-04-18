package com.dt.user.model;

import java.io.Serializable;
import java.util.List;

/**
 * 表头信息
 */
public class TableHead implements Serializable {
    /**
     * 自增ID
     */
    private Long id;
    /**
     * 菜单名称
     */
    private String headName;
    /**
     * 菜单ID
     */
    private String menuId;
    /**
     * 类型
     */
    private String topType;
    /**
     * 排序
     */
    private String topOrder;
    /**
     * 是否锁框
     */
    private Boolean fixed;
    /**
     * 账号状态
     */
    private List<AccountStatusOptions> statusOptions;

    /**
     * 菜单名称
     */
    private String mName;
    /**
     * 输入框类型
     */
    private Integer inputType;
    /**
     * 接收ids
     */
    private String ids;
    /**
     * 是否引用
     */
    private Boolean reference;
    /**
     * 重新排序的顺序
     */
    private Integer index;

    private List<TableHead> headList;
    /**
     * 版本
     */
    private int version;

    public int getVersion() {
        return version;
    }


    public Boolean getFixed() {
        return fixed;
    }

    public void setFixed(Boolean fixed) {
        this.fixed = fixed;
    }

    public Boolean getReference() {
        return reference;
    }

    public void setReference(Boolean reference) {
        this.reference = reference;
    }

    public List<TableHead> getHeadList() {
        return headList;
    }

    public void setHeadList(List<TableHead> headList) {
        this.headList = headList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeadName() {
        return headName;
    }

    public void setHeadName(String headName) {
        this.headName = headName;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getTopType() {
        return topType;
    }

    public void setTopType(String topType) {
        this.topType = topType;
    }

    public String getTopOrder() {
        return topOrder;
    }

    public void setTopOrder(String topOrder) {
        this.topOrder = topOrder;
    }


    public List<AccountStatusOptions> getStatusOptions() {
        return statusOptions;
    }

    public void setStatusOptions(List<AccountStatusOptions> statusOptions) {
        this.statusOptions = statusOptions;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public Integer getInputType() {
        return inputType;
    }

    public void setInputType(Integer inputType) {
        this.inputType = inputType;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }


    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}

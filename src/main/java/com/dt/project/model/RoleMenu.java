package com.dt.project.model;

import java.io.Serializable;

/**
 * menu跟role关联实体类
 */
public class RoleMenu implements Serializable {
    /**
     * menuID
     */
    private Integer mid;
    /**
     * roleID
     */
    private Integer rid;
    /**
     * id
     */
    private Integer id;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

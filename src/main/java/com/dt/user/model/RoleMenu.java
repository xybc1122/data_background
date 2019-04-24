package com.dt.user.model;

import java.io.Serializable;

/**
 * menu跟role关联实体类
 */
public class RoleMenu implements Serializable {
    /**
     * menuID
     */
    private Long mid;
    /**
     * roleID
     */
    private Long rid;
    /**
     * id
     */
    private Long id;

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

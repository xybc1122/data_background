package com.dt.project.model;

import com.dt.project.model.Parent.ConfTableParent;

import java.util.List;

/**
 * 用户关联角色实体类
 */
public class UserRole extends ConfTableParent {
    /**
     * user_info  id
     */
    private Long uid;
    /**
     * project IDs
     */
    private List<Integer> userIds;
    /**
     * role id
     */
    private Long rid;

    /**
     * role ids
     */
    private List<Integer> roleIds;
    /**
     * id
     */
    private Long id;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public List<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

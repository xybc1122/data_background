package com.dt.user.model;


import java.io.Serializable;

/**
 * 角色表
 */
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 角色id
     */
    private Long rid;
    /**
     * 角色名称
     */
    private String rName;
    /**
     * 角色标识
     */
    private String roleSign;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建用户id
     */
    private String createUser;
    /**
     * 创建时间
     */
    private Long createDate;
    /**
     * 修改时间
     */
    private Long upDate;
    /**
     * 修改用户id
     */
    private String upUser;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getRoleSign() {
        return roleSign;
    }

    public void setRoleSign(String roleSign) {
        this.roleSign = roleSign;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Long getUpDate() {
        return upDate;
    }

    public void setUpDate(Long upDate) {
        this.upDate = upDate;
    }

    public String getUpUser() {
        return upUser;
    }

    public void setUpUser(String upUser) {
        this.upUser = upUser;
    }
}

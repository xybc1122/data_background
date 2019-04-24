package com.dt.user.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

/**
 * 用户实体类
 */
@JsonIgnoreProperties(value = {"handler"})
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 用户id
     */
    private Long uid;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String pwd;
    /**
     * 状态,默认为0，普通用户，1为超级管理员
     */
    private Integer status;

    /**
     * 账户状态，被锁定之类的，默认为0，表示正常
     */
    private Integer accountStatus;

    /**
     * userExpirationDate
     * 用户有效时间
     */
    private Long userExpirationDate;
    /**
     * 密码有效期 0为始终有效  非0密码到期会提示修改密码
     */
    private Long pwdValidityPeriod;
    /**
     * 用户是否始终有效
     */
    private String userStatus;
    /**
     * 版本标识
     */
    private Integer version;
    //用户名
    private String name;

    //role对象
    private List<Role> roles;

    //角色名称
    private String rName;

    //多个角色id 拼接  已,号隔开
    private String rid;
    //登陆时间
    private Long landingTime;

    //手机号码
    private String mobilePhone;

    //菜单名称
    private String menuName;

    //是否删除标示
    private Integer delOrNot;


    //首次登陆是否修改密码
    private Boolean isFirstLogin;

    //菜单type 分别 是菜单还是快捷按钮

    private Integer type;
    /**
     * 计算机名
     */
    private String computerName;

    private String remark;
    private Long createDate;
    private String createUser;
    private Long modifyDate;
    private Long auditDate;
    private String modifyUser;
    private String auditUser;


    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Long getUserExpirationDate() {
        return userExpirationDate;
    }

    public void setUserExpirationDate(Long userExpirationDate) {
        this.userExpirationDate = userExpirationDate;
    }

    public Long getPwdValidityPeriod() {
        return pwdValidityPeriod;
    }

    public void setPwdValidityPeriod(Long pwdValidityPeriod) {
        this.pwdValidityPeriod = pwdValidityPeriod;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public Long getLandingTime() {
        return landingTime;
    }

    public void setLandingTime(Long landingTime) {
        this.landingTime = landingTime;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getDelOrNot() {
        return delOrNot;
    }

    public void setDelOrNot(Integer delOrNot) {
        this.delOrNot = delOrNot;
    }

    public Boolean getFirstLogin() {
        return isFirstLogin;
    }

    public void setFirstLogin(Boolean firstLogin) {
        isFirstLogin = firstLogin;
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

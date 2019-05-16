package com.dt.project.model.Parent;

/**
 * @ClassName ConfTableParent
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/24 16:07
 **/

/**
 * 配置表父类
 */
public class ConfTableParent {


    private String remark;
    private Integer status;
    private Long createDate;
    private String createUser;
    private Long modifyDate;
    private String modifyUser;
    private Long auditDate;
    private String auditUser;

    public ConfTableParent() {


    }

    public ConfTableParent(Long createDate, String createUser) {
        this.createDate = createDate;
        this.createUser = createUser;
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

package com.dt.project.model.system;

/**
 * 用户配置表
 */
public class SystemUserConfig {

    private Long configId;
    private Integer mid;
    private Long createDate;
    private String createUser;


    public SystemUserConfig() {

    }

    public SystemUserConfig(Integer mid, Long createDate, String createUser) {
        this.mid = mid;
        this.createDate = createDate;
        this.createUser = createUser;
    }

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
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
}

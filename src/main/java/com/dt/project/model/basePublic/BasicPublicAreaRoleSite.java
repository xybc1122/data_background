package com.dt.project.model.basePublic;

public class BasicPublicAreaRoleSite {
    private Integer arsId;

    private Integer arId;

    private Integer seId;

    private Long createDate;

    private String createUser;

    public Integer getArsId() {
        return arsId;
    }

    public void setArsId(Integer arsId) {
        this.arsId = arsId;
    }

    public Integer getArId() {
        return arId;
    }

    public void setArId(Integer arId) {
        this.arId = arId;
    }

    public Integer getSeId() {
        return seId;
    }

    public void setSeId(Integer seId) {
        this.seId = seId;
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
        this.createUser = createUser == null ? null : createUser.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", arsId=").append(arsId);
        sb.append(", arId=").append(arId);
        sb.append(", seId=").append(seId);
        sb.append(", createDate=").append(createDate);
        sb.append(", createUser=").append(createUser);
        sb.append("]");
        return sb.toString();
    }
}
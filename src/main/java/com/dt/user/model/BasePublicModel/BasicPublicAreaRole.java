package com.dt.user.model.BasePublicModel;

public class BasicPublicAreaRole {
    private Integer arId;

    private Integer aId;

    private Integer rId;

    private String createUser;

    private byte[] createDate;

    public Integer getArId() {
        return arId;
    }

    public void setArId(Integer arId) {
        this.arId = arId;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public byte[] getCreateDate() {
        return createDate;
    }

    public void setCreateDate(byte[] createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", arId=").append(arId);
        sb.append(", aId=").append(aId);
        sb.append(", rId=").append(rId);
        sb.append(", createUser=").append(createUser);
        sb.append(", createDate=").append(createDate);
        sb.append("]");
        return sb.toString();
    }
}
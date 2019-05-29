package com.dt.project.model.system;
/**
 * 关账 结账 控制对象
 */
public class SystemFinalProcessing {


    private Integer finalProcessingId;

    private Integer menuId;

    private Integer closeYears;

    private Integer closePeriod;

    private Integer checkoutYears;

    private Long checkoutPeriod;

    private String remark;

    private Integer status;

    private Long createDate;

    private Long createIdUser;

    private Integer modifyDate;

    private Integer modifyIdUser;

    private Long recordingId;

    private Integer version;

    private Integer delOrNot;



    public Integer getFinalProcessingId() {
        return finalProcessingId;
    }

    public void setFinalProcessingId(Integer finalProcessingId) {
        this.finalProcessingId = finalProcessingId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getCloseYears() {
        return closeYears;
    }

    public void setCloseYears(Integer closeYears) {
        this.closeYears = closeYears;
    }

    public Integer getClosePeriod() {
        return closePeriod;
    }

    public void setClosePeriod(Integer closePeriod) {
        this.closePeriod = closePeriod;
    }

    public Integer getCheckoutYears() {
        return checkoutYears;
    }

    public void setCheckoutYears(Integer checkoutYears) {
        this.checkoutYears = checkoutYears;
    }

    public Long getCheckoutPeriod() {
        return checkoutPeriod;
    }

    public void setCheckoutPeriod(Long checkoutPeriod) {
        this.checkoutPeriod = checkoutPeriod;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public Long getCreateIdUser() {
        return createIdUser;
    }

    public void setCreateIdUser(Long createIdUser) {
        this.createIdUser = createIdUser;
    }

    public Integer getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Integer modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getModifyIdUser() {
        return modifyIdUser;
    }

    public void setModifyIdUser(Integer modifyIdUser) {
        this.modifyIdUser = modifyIdUser;
    }

    public Long getRecordingId() {
        return recordingId;
    }

    public void setRecordingId(Long recordingId) {
        this.recordingId = recordingId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getDelOrNot() {
        return delOrNot;
    }

    public void setDelOrNot(Integer delOrNot) {
        this.delOrNot = delOrNot;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", finalProcessingId=").append(finalProcessingId);
        sb.append(", menuId=").append(menuId);
        sb.append(", closeYears=").append(closeYears);
        sb.append(", closePeriod=").append(closePeriod);
        sb.append(", checkoutYears=").append(checkoutYears);
        sb.append(", checkoutPeriod=").append(checkoutPeriod);
        sb.append(", remark=").append(remark);
        sb.append(", status=").append(status);
        sb.append(", createDate=").append(createDate);
        sb.append(", createIdUser=").append(createIdUser);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", modifyIdUser=").append(modifyIdUser);
        sb.append(", recordingId=").append(recordingId);
        sb.append(", version=").append(version);
        sb.append(", delOrNot=").append(delOrNot);
        sb.append("]");
        return sb.toString();
    }
}
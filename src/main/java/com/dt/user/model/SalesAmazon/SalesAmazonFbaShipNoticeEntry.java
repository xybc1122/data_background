package com.dt.user.model.SalesAmazon;

import com.dt.user.model.ParentUploadInfo;

import java.util.List;

/**
 * 出货通知单
 */
public class SalesAmazonFbaShipNoticeEntry extends ParentUploadInfo {

    private Long eId;
    private Long entryId;
    private Long shipNoticeId;
    private Long quantity;
    private String packages;
    private Double lengthCm;
    private Double widthCm;
    private Double heightCm;
    private Double gwKg;
    private Double nwKg;
    private Double volumeM3;
    private Long seQuantity;
    private Long reQuantity;
    private Long reDate;
    private Long closeDate;
    private String closeUser;
    /**
     * 接收日期范围查询
     */
    private List<Long> reDates;

    /**
     * 关闭时间范围查询
     */
    private List<Long> closeDates;

    public List<Long> getReDates() {
        return reDates;
    }

    public void setReDates(List<Long> reDates) {
        this.reDates = reDates;
    }

    public List<Long> getCloseDates() {
        return closeDates;
    }

    public void setCloseDates(List<Long> closeDates) {
        this.closeDates = closeDates;
    }

    public Long geteId() {
        return eId;
    }

    public void seteId(Long eId) {
        this.eId = eId;
    }

    public Long getEntryId() {
        return entryId;
    }

    public void setEntryId(Long entryId) {
        this.entryId = entryId;
    }

    public Long getShipNoticeId() {
        return shipNoticeId;
    }

    public void setShipNoticeId(Long shipNoticeId) {
        this.shipNoticeId = shipNoticeId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }

    public Double getLengthCm() {
        return lengthCm;
    }

    public void setLengthCm(Double lengthCm) {
        this.lengthCm = lengthCm;
    }

    public Double getWidthCm() {
        return widthCm;
    }

    public void setWidthCm(Double widthCm) {
        this.widthCm = widthCm;
    }

    public Double getHeightCm() {
        return heightCm;
    }

    public void setHeightCm(Double heightCm) {
        this.heightCm = heightCm;
    }

    public Double getGwKg() {
        return gwKg;
    }

    public void setGwKg(Double gwKg) {
        this.gwKg = gwKg;
    }

    public Double getNwKg() {
        return nwKg;
    }

    public void setNwKg(Double nwKg) {
        this.nwKg = nwKg;
    }

    public Double getVolumeM3() {
        return volumeM3;
    }

    public void setVolumeM3(Double volumeM3) {
        this.volumeM3 = volumeM3;
    }

    public Long getSeQuantity() {
        return seQuantity;
    }

    public void setSeQuantity(Long seQuantity) {
        this.seQuantity = seQuantity;
    }

    public Long getReQuantity() {
        return reQuantity;
    }

    public void setReQuantity(Long reQuantity) {
        this.reQuantity = reQuantity;
    }

    public Long getReDate() {
        return reDate;
    }

    public void setReDate(Long reDate) {
        this.reDate = reDate;
    }

    public Long getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Long closeDate) {
        this.closeDate = closeDate;
    }

    public String getCloseUser() {
        return closeUser;
    }

    public void setCloseUser(String closeUser) {
        this.closeUser = closeUser;
    }
}

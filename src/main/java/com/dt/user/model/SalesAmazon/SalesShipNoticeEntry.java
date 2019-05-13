package com.dt.user.model.SalesAmazon;


import com.dt.user.config.ResponseBase;

import java.math.BigDecimal;

/**
 * 发货通知单表体
 */

public class SalesShipNoticeEntry {
    private Long eid;

    private Integer entryId;

    private Long shipNoticeId;

    private Long skuId;

    private Integer quantity;

    private String packages;

    private BigDecimal lengthCm;

    private Double widthCm;

    private Double heightCm;

    private Double gwKg;

    private Double nwKg;

    private Double volumeM3;

    private Boolean packingStatus;

    private Integer seQuantity;

    private Integer reQuantity;

    private Long reDate;

    private String remark;

    private Integer status;

    private Long closeDate;

    private String closeUser;

    private Integer version;
    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 显示的页数
     */
    private Integer pageSize;


    /**
     * 一对多存储的数据
     */
    private ResponseBase pEData;

    /**
     * 要查询的数据
     */
    private SalesShipNoticePackingListEntry packingListEntry;

    public SalesShipNoticePackingListEntry getPackingListEntry() {
        return packingListEntry;
    }

    public void setPackingListEntry(SalesShipNoticePackingListEntry packingListEntry) {
        this.packingListEntry = packingListEntry;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public SalesShipNoticeEntry() {

    }

    public ResponseBase getpEData() {
        return pEData;
    }

    public void setpEData(ResponseBase pEData) {
        this.pEData = pEData;
    }

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public Integer getEntryId() {
        return entryId;
    }

    public void setEntryId(Integer entryId) {
        this.entryId = entryId;
    }

    public Long getShipNoticeId() {
        return shipNoticeId;
    }

    public void setShipNoticeId(Long shipNoticeId) {
        this.shipNoticeId = shipNoticeId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages == null ? null : packages.trim();
    }

    public BigDecimal getLengthCm() {
        return lengthCm;
    }

    public void setLengthCm(BigDecimal lengthCm) {
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

    public Boolean getPackingStatus() {
        return packingStatus;
    }

    public void setPackingStatus(Boolean packingStatus) {
        this.packingStatus = packingStatus;
    }

    public Integer getSeQuantity() {
        return seQuantity;
    }

    public void setSeQuantity(Integer seQuantity) {
        this.seQuantity = seQuantity;
    }

    public Integer getReQuantity() {
        return reQuantity;
    }

    public void setReQuantity(Integer reQuantity) {
        this.reQuantity = reQuantity;
    }

    public Long getReDate() {
        return reDate;
    }

    public void setReDate(Long reDate) {
        this.reDate = reDate;
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
        this.closeUser = closeUser == null ? null : closeUser.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}
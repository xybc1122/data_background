package com.dt.user.model.SalesAmazon;

import com.dt.user.model.Parent.ParentUploadInfo;

import java.math.BigDecimal;

/**
 * 发货通知
 */
public class SalesShipNotice extends ParentUploadInfo {
    private Long shipNoticeId;

    private String no;

    private Long date;

    private Integer platformTypeId;

    private Long deliveryDate;

    private Long arriveDate;

    private Integer transportTypeId;


    private String fbaShipmentId;

    private Integer awId;

    private Long warehouseId;

    private Integer ttlQty;

    private Integer ttlPackages;

    private BigDecimal ttlVolume;

    private BigDecimal ttlGwKg;

    private Long sourceTypeId;

    private Long sourceId;

    private Long closeDate;

    private Long closeUser;

    private SalesShipNoticeEntry salesShipNoticeEntry;

    public SalesShipNoticeEntry getSalesShipNoticeEntry() {
        return salesShipNoticeEntry;
    }

    public void setSalesShipNoticeEntry(SalesShipNoticeEntry salesShipNoticeEntry) {
        this.salesShipNoticeEntry = salesShipNoticeEntry;
    }

    public Long getShipNoticeId() {
        return shipNoticeId;
    }

    public void setShipNoticeId(Long shipNoticeId) {
        this.shipNoticeId = shipNoticeId;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    @Override
    public Long getDate() {
        return date;
    }

    @Override
    public void setDate(Long date) {
        this.date = date;
    }

    public Integer getPlatformTypeId() {
        return platformTypeId;
    }

    public void setPlatformTypeId(Integer platformTypeId) {
        this.platformTypeId = platformTypeId;
    }

    public Long getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Long deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Long getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(Long arriveDate) {
        this.arriveDate = arriveDate;
    }

    public Integer getTransportTypeId() {
        return transportTypeId;
    }

    public void setTransportTypeId(Integer transportTypeId) {
        this.transportTypeId = transportTypeId;
    }

    public String getFbaShipmentId() {
        return fbaShipmentId;
    }

    public void setFbaShipmentId(String fbaShipmentId) {
        this.fbaShipmentId = fbaShipmentId;
    }

    public Integer getAwId() {
        return awId;
    }

    public void setAwId(Integer awId) {
        this.awId = awId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getTtlQty() {
        return ttlQty;
    }

    public void setTtlQty(Integer ttlQty) {
        this.ttlQty = ttlQty;
    }

    public Integer getTtlPackages() {
        return ttlPackages;
    }

    public void setTtlPackages(Integer ttlPackages) {
        this.ttlPackages = ttlPackages;
    }

    public BigDecimal getTtlVolume() {
        return ttlVolume;
    }

    public void setTtlVolume(BigDecimal ttlVolume) {
        this.ttlVolume = ttlVolume;
    }

    public BigDecimal getTtlGwKg() {
        return ttlGwKg;
    }

    public void setTtlGwKg(BigDecimal ttlGwKg) {
        this.ttlGwKg = ttlGwKg;
    }

    public Long getSourceTypeId() {
        return sourceTypeId;
    }

    public void setSourceTypeId(Long sourceTypeId) {
        this.sourceTypeId = sourceTypeId;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Long getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Long closeDate) {
        this.closeDate = closeDate;
    }

    public Long getCloseUser() {
        return closeUser;
    }

    public void setCloseUser(Long closeUser) {
        this.closeUser = closeUser;
    }
}
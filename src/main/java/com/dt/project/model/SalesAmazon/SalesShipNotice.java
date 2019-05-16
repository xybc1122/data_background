package com.dt.project.model.SalesAmazon;

import com.dt.project.model.Parent.ParentUploadInfo;


import java.math.BigDecimal;
import java.util.List;

/**
 * 发货通知单
 */
//作用是在 json 序列化时忽略 bean 中的一些不需要转化的属性
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

    private Long sourceNo;

    private Long closeDate;

    private Long closeUser;
    /**
     * 付款类型名称
     */
    private String paymentTypeName;

    /**
     * 接收对象查询
     */
    private SalesShipNoticeEntry shipNoticeEntry;
    /**
     * 一对多查询存储
     */
    private List<SalesShipNoticeEntry> noticeEntryList;
    /**
     * 计划出货日期范围查询
     */
    private List<Long> deliveryDates;
    /**
     * 最迟到达日期返回查询
     */
    private List<Long> arriveDates;
    /**
     * 关闭时间范围查询
     */
    private List<Long> closeDates;

    public SalesShipNotice() {

    }

    public SalesShipNoticeEntry getShipNoticeEntry() {
        return shipNoticeEntry;
    }

    public void setShipNoticeEntry(SalesShipNoticeEntry shipNoticeEntry) {
        this.shipNoticeEntry = shipNoticeEntry;
    }

    public List<Long> getCloseDates() {
        return closeDates;
    }

    public void setCloseDates(List<Long> closeDates) {
        this.closeDates = closeDates;
    }

    public List<Long> getDeliveryDates() {
        return deliveryDates;
    }

    public void setDeliveryDates(List<Long> deliveryDates) {
        this.deliveryDates = deliveryDates;
    }

    public List<Long> getArriveDates() {
        return arriveDates;
    }

    public void setArriveDates(List<Long> arriveDates) {
        this.arriveDates = arriveDates;
    }

    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }

    public List<SalesShipNoticeEntry> getNoticeEntryList() {
        return noticeEntryList;
    }

    public void setNoticeEntryList(List<SalesShipNoticeEntry> noticeEntryList) {
        this.noticeEntryList = noticeEntryList;
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

    public Long getSourceNo() {
        return sourceNo;
    }

    public void setSourceNo(Long sourceNo) {
        this.sourceNo = sourceNo;
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
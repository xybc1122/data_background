package com.dt.project.model.salesAmazon;

import com.dt.project.model.parent.ParentConfTable;
import com.dt.project.model.parent.ParentUploadInfo;


import java.math.BigDecimal;
import java.util.List;

/**
 * 发货通知单
 */
public class SalesShipNotice extends ParentConfTable {


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

    private BigDecimal ttlNwKg;

    private BigDecimal ttlGwKg;
//
//    private Long sourceTypeId;
//
//    private Long sourceId;

    /**
     * 站点名称
     */
    private String siteName;
    /**
     * 店铺名称
     */
    private String shopName;

    private Integer shopId;
    private Integer siteId;

    /**
     * 单据日期范围查询
     */
    private List<Long> dates;

    /**
     * 付款类型名称
     */
    private String paymentTypeName;

    /**
     * 接收对象查询
     */
    private SalesShipNoticeEntry entry;
    /**
     * 一对多查询存储
     */
    private List<SalesShipNoticeEntry> entryList;
    /**
     * 计划出货日期范围查询
     */
    private List<Long> deliveryDates;
    /**
     * 最迟到达日期返回查询
     */
    private List<Long> arriveDates;
    /**
     * 平台类型名
     */
    private String platformTypeName;
    /**
     * 运输类型名
     */
    private String transportTypeName;
    /**
     * 亚马逊仓库code
     */
    private String warehouseCode;
    /**
     * 仓库名称
     */
    private String warehouseName;


    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getTransportTypeName() {
        return transportTypeName;
    }

    public void setTransportTypeName(String transportTypeName) {
        this.transportTypeName = transportTypeName;
    }

    public String getPlatformTypeName() {
        return platformTypeName;
    }

    public void setPlatformTypeName(String platformTypeName) {
        this.platformTypeName = platformTypeName;
    }

    public BigDecimal getTtlNwKg() {
        return ttlNwKg;
    }

    public void setTtlNwKg(BigDecimal ttlNwKg) {
        this.ttlNwKg = ttlNwKg;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public List<Long> getDates() {
        return dates;
    }

    public void setDates(List<Long> dates) {
        this.dates = dates;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public SalesShipNotice() {

    }

    public SalesShipNoticeEntry getEntry() {
        return entry;
    }

    public void setEntry(SalesShipNoticeEntry entry) {
        this.entry = entry;
    }

    public List<SalesShipNoticeEntry> getEntryList() {
        return entryList;
    }

    public void setEntryList(List<SalesShipNoticeEntry> entryList) {
        this.entryList = entryList;
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


}
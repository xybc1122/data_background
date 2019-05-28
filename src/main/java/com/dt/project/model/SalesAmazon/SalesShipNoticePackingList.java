package com.dt.project.model.salesAmazon;

import com.dt.project.model.parent.ParentUploadInfo;

import java.math.BigDecimal;

public class SalesShipNoticePackingList extends ParentUploadInfo {
    private Long packinglistId;

    private Long shipNoticeId;

    private String no;

    private Long date;

    private Integer ttlQty;

    private Integer ttlPackages;

    private BigDecimal ttlVolume;

    private BigDecimal ttlGwKg;

    private Long sourceTypeId;

    private Long sourceId;


    public Long getPackinglistId() {
        return packinglistId;
    }

    public void setPackinglistId(Long packinglistId) {
        this.packinglistId = packinglistId;
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
        this.no = no == null ? null : no.trim();
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
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
}
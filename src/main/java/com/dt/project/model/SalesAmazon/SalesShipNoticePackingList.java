package com.dt.project.model.salesAmazon;

import com.dt.project.model.parent.ParentConfTable;

import java.math.BigDecimal;
import java.util.List;

/**
 * 出货装箱外表
 */
public class SalesShipNoticePackingList extends ParentConfTable {


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

    /**
     * 接收存储对象
     */
    private SalesShipNoticePackingListEntry shipNoticePackingListEntry;
    /**
     * 设置SalesShipNoticePackingListEntry 一对多
     */
    private List<SalesShipNoticePackingListEntry> listEntries;

    public SalesShipNoticePackingListEntry getShipNoticePackingListEntry() {
        return shipNoticePackingListEntry;
    }

    public void setShipNoticePackingListEntry(SalesShipNoticePackingListEntry shipNoticePackingListEntry) {
        this.shipNoticePackingListEntry = shipNoticePackingListEntry;
    }

    public List<SalesShipNoticePackingListEntry> getListEntries() {
        return listEntries;
    }

    public void setListEntries(List<SalesShipNoticePackingListEntry> listEntries) {
        this.listEntries = listEntries;
    }

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
package com.dt.user.model.SalesAmazon;

import com.dt.user.model.Parent.ParentUploadInfo;

import java.math.BigDecimal;

/**
 * HL数据导入
 */
public class SalesAmazonAdHl extends ParentUploadInfo {

    private Long hlId;
    private String campaignName;
    private Double impressions;
    private Double clicks;
    private Double ctr;
    private Double cpc;
    private BigDecimal spend;
    private Double acos;
    private BigDecimal roas;
    private BigDecimal totalSales;
    private Double totalOrders;
    private Double totalUnits;
    private Double conversionRate;


    public SalesAmazonAdHl() {

    }

    public SalesAmazonAdHl(Integer shopId, Integer siteId, Long createDate, Long createIdUser, Long recordingId) {
        super(shopId, siteId, createDate, createIdUser, recordingId);

    }

    public Long getHlId() {
        return hlId;
    }

    public void setHlId(Long hlId) {
        this.hlId = hlId;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public Double getImpressions() {
        return impressions;
    }

    public void setImpressions(Double impressions) {
        this.impressions = impressions;
    }

    public Double getClicks() {
        return clicks;
    }

    public void setClicks(Double clicks) {
        this.clicks = clicks;
    }

    public Double getCtr() {
        return ctr;
    }

    public void setCtr(Double ctr) {
        this.ctr = ctr;
    }

    public Double getCpc() {
        return cpc;
    }

    public void setCpc(Double cpc) {
        this.cpc = cpc;
    }

    public BigDecimal getSpend() {
        return spend;
    }

    public void setSpend(BigDecimal spend) {
        this.spend = spend;
    }

    public Double getAcos() {
        return acos;
    }

    public void setAcos(Double acos) {
        this.acos = acos;
    }

    public BigDecimal getRoas() {
        return roas;
    }

    public void setRoas(BigDecimal roas) {
        this.roas = roas;
    }

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales;
    }

    public Double getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(Double totalOrders) {
        this.totalOrders = totalOrders;
    }

    public Double getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(Double totalUnits) {
        this.totalUnits = totalUnits;
    }

    public Double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(Double conversionRate) {
        this.conversionRate = conversionRate;
    }
}

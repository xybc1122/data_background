package com.dt.user.model.SalesAmazon;


import com.dt.user.model.Parent.ParentUploadInfo;

import java.math.BigDecimal;

public class SalesAmazonAdStr extends ParentUploadInfo {

    private Long strId;
    private String matchType;
    private String customerSearchTerm;
    private Double impressions;
    private Double clicks;
    private BigDecimal totalSpend;
    private BigDecimal sales;
    private BigDecimal roas;
    private Double ordersPlaced;
    private Double totalUnits;
    private Double advertisedSkuUnitsOrdered;
    private Double otherSkuUnitsOrdered;
    private BigDecimal advertisedSkuUnitsSales;
    private BigDecimal otherSkuUnitsSales;
    private String adGroupName;
    private String campaignName;
    private String targeting;

    public SalesAmazonAdStr() {

    }

    public SalesAmazonAdStr(Integer shopId, Integer siteId, Long createDate, String createUser, Long recordingId) {
        super(shopId, siteId, createDate, createUser, recordingId);

    }

    public Long getStrId() {
        return strId;
    }

    public void setStrId(Long strId) {
        this.strId = strId;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getCustomerSearchTerm() {
        return customerSearchTerm;
    }

    public void setCustomerSearchTerm(String customerSearchTerm) {
        this.customerSearchTerm = customerSearchTerm;
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

    public BigDecimal getTotalSpend() {
        return totalSpend;
    }

    public void setTotalSpend(BigDecimal totalSpend) {
        this.totalSpend = totalSpend;
    }

    public BigDecimal getSales() {
        return sales;
    }

    public void setSales(BigDecimal sales) {
        this.sales = sales;
    }

    public BigDecimal getRoas() {
        return roas;
    }

    public void setRoas(BigDecimal roas) {
        this.roas = roas;
    }

    public Double getOrdersPlaced() {
        return ordersPlaced;
    }

    public void setOrdersPlaced(Double ordersPlaced) {
        this.ordersPlaced = ordersPlaced;
    }

    public Double getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(Double totalUnits) {
        this.totalUnits = totalUnits;
    }

    public Double getAdvertisedSkuUnitsOrdered() {
        return advertisedSkuUnitsOrdered;
    }

    public void setAdvertisedSkuUnitsOrdered(Double advertisedSkuUnitsOrdered) {
        this.advertisedSkuUnitsOrdered = advertisedSkuUnitsOrdered;
    }

    public Double getOtherSkuUnitsOrdered() {
        return otherSkuUnitsOrdered;
    }

    public void setOtherSkuUnitsOrdered(Double otherSkuUnitsOrdered) {
        this.otherSkuUnitsOrdered = otherSkuUnitsOrdered;
    }

    public BigDecimal getAdvertisedSkuUnitsSales() {
        return advertisedSkuUnitsSales;
    }

    public void setAdvertisedSkuUnitsSales(BigDecimal advertisedSkuUnitsSales) {
        this.advertisedSkuUnitsSales = advertisedSkuUnitsSales;
    }

    public BigDecimal getOtherSkuUnitsSales() {
        return otherSkuUnitsSales;
    }

    public void setOtherSkuUnitsSales(BigDecimal otherSkuUnitsSales) {
        this.otherSkuUnitsSales = otherSkuUnitsSales;
    }

    public String getAdGroupName() {
        return adGroupName;
    }

    public void setAdGroupName(String adGroupName) {
        this.adGroupName = adGroupName;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getTargeting() {
        return targeting;
    }

    public void setTargeting(String targeting) {
        this.targeting = targeting;
    }
}

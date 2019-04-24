package com.dt.user.model.SalesAmazon;

import com.dt.user.model.Parent.ParentUploadInfo;

import java.math.BigDecimal;

/**
 * 广告数据导入
 */
public class SalesAmazonAdCpr extends ParentUploadInfo {

    private Long adCprId;
    private String advertisedSku;
    private String advertisedAsin;
    private String matchType;
    private Double impressions;
    private Double clicks;
    private BigDecimal totalSpend;
    private Double ordersPlaced;
    private BigDecimal sales;
    private BigDecimal roas;
    private Double totalUnits;
    private Double sameSkuUnitsOrdered;
    private Double otherSkuUnitsOrdered;
    private BigDecimal sameSkuUnitsSales;
    private BigDecimal otherSkuUnitsSales;
    private String adGroupName;
    private String campaignName;
    private String targeting;



    public SalesAmazonAdCpr() {

    }

    public SalesAmazonAdCpr(Integer shopId, Integer siteId, Long createDate, String createUser, Long recordingId) {
        super(shopId, siteId, createDate, createUser, recordingId);
    }

    public Long getAdCprId() {
        return adCprId;
    }

    public void setAdCprId(Long adCprId) {
        this.adCprId = adCprId;
    }

    public String getAdvertisedSku() {
        return advertisedSku;
    }

    public void setAdvertisedSku(String advertisedSku) {
        this.advertisedSku = advertisedSku;
    }

    public String getAdvertisedAsin() {
        return advertisedAsin;
    }

    public void setAdvertisedAsin(String advertisedAsin) {
        this.advertisedAsin = advertisedAsin;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
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

    public Double getOrdersPlaced() {
        return ordersPlaced;
    }

    public void setOrdersPlaced(Double ordersPlaced) {
        this.ordersPlaced = ordersPlaced;
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

    public Double getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(Double totalUnits) {
        this.totalUnits = totalUnits;
    }

    public Double getSameSkuUnitsOrdered() {
        return sameSkuUnitsOrdered;
    }

    public void setSameSkuUnitsOrdered(Double sameSkuUnitsOrdered) {
        this.sameSkuUnitsOrdered = sameSkuUnitsOrdered;
    }

    public Double getOtherSkuUnitsOrdered() {
        return otherSkuUnitsOrdered;
    }

    public void setOtherSkuUnitsOrdered(Double otherSkuUnitsOrdered) {
        this.otherSkuUnitsOrdered = otherSkuUnitsOrdered;
    }

    public BigDecimal getSameSkuUnitsSales() {
        return sameSkuUnitsSales;
    }

    public void setSameSkuUnitsSales(BigDecimal sameSkuUnitsSales) {
        this.sameSkuUnitsSales = sameSkuUnitsSales;
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

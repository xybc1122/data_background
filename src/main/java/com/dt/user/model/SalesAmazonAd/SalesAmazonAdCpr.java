package com.dt.user.model.SalesAmazonAd;

import com.dt.user.model.ParentUploadInfo;

/**
 * 广告数据导入
 */
public class SalesAmazonAdCpr extends ParentUploadInfo {

    private Long adCprId;
    private Long date;
    private Integer shopId;
    private Integer siteId;
    private Long skuId;
    private String advertisedSku;
    private String advertisedAsin;
    private String campaignName;
    private String adGroupName;
    private String keyword;
    private String matchType;
    private Double impressions;
    private Double clicks;
    private Double totalSpend;
    private Double ordersPlaced;
    private Double sales;
    private Double roas;
    private Double totalUnits;
    private Double sameskuUnitsOrdered;
    private Double otherskuUnitsOrdered;
    private Double sameskuUnitsSales;
    private Double otherskuUnitsSales;

    //记录表ID
    private Long recordingId;

    public SalesAmazonAdCpr() {

    }

    public SalesAmazonAdCpr(Integer shopId, Integer siteId, Long createDate, String creatUser, Long recordingId) {
        super(createDate, creatUser);
        this.shopId = shopId;
        this.siteId = siteId;
        this.recordingId = recordingId;

    }

    public Long getRecordingId() {
        return recordingId;
    }

    public void setRecordingId(Long recordingId) {
        this.recordingId = recordingId;
    }

    public Long getAdCprId() {
        return adCprId;
    }

    public void setAdCprId(Long adCprId) {
        this.adCprId = adCprId;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
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

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
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

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getAdGroupName() {
        return adGroupName;
    }

    public void setAdGroupName(String adGroupName) {
        this.adGroupName = adGroupName;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
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

    public Double getTotalSpend() {
        return totalSpend;
    }

    public void setTotalSpend(Double totalSpend) {
        this.totalSpend = totalSpend;
    }

    public Double getOrdersPlaced() {
        return ordersPlaced;
    }

    public void setOrdersPlaced(Double ordersPlaced) {
        this.ordersPlaced = ordersPlaced;
    }

    public Double getSales() {
        return sales;
    }

    public void setSales(Double sales) {
        this.sales = sales;
    }

    public Double getRoas() {
        return roas;
    }

    public void setRoas(Double roas) {
        this.roas = roas;
    }

    public Double getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(Double totalUnits) {
        this.totalUnits = totalUnits;
    }

    public Double getSameskuUnitsOrdered() {
        return sameskuUnitsOrdered;
    }

    public void setSameskuUnitsOrdered(Double sameskuUnitsOrdered) {
        this.sameskuUnitsOrdered = sameskuUnitsOrdered;
    }

    public Double getOtherskuUnitsOrdered() {
        return otherskuUnitsOrdered;
    }

    public void setOtherskuUnitsOrdered(Double otherskuUnitsOrdered) {
        this.otherskuUnitsOrdered = otherskuUnitsOrdered;
    }

    public Double getSameskuUnitsSales() {
        return sameskuUnitsSales;
    }

    public void setSameskuUnitsSales(Double sameskuUnitsSales) {
        this.sameskuUnitsSales = sameskuUnitsSales;
    }

    public Double getOtherskuUnitsSales() {
        return otherskuUnitsSales;
    }

    public void setOtherskuUnitsSales(Double otherskuUnitsSales) {
        this.otherskuUnitsSales = otherskuUnitsSales;
    }
}

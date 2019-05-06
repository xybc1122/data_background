package com.dt.user.model.SalesAmazon;


import com.dt.user.model.Parent.ParentUploadInfo;

import java.math.BigDecimal;

public class SalesAmazonAdOar extends ParentUploadInfo {

    private Long oar_id;
    private String advertisedSku;
    private String advertisedAsin;
    private String matchType;
    private String otherAsin;
    private Double otherAsinUnits;
    private Double otherAsinUnitsOrdered;
    private BigDecimal otherAsinUnitsOrderedSales;
    private String adGroupName;
    private String campaignName;
    private String targeting;


    public SalesAmazonAdOar() {

    }

    public SalesAmazonAdOar(Integer shopId, Integer siteId, Long createDate, String createUser, Long recordingId) {
        super(shopId, siteId, createDate, createUser, recordingId);
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

    public Long getOar_id() {
        return oar_id;
    }

    public void setOar_id(Long oar_id) {
        this.oar_id = oar_id;
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

    public String getOtherAsin() {
        return otherAsin;
    }

    public void setOtherAsin(String otherAsin) {
        this.otherAsin = otherAsin;
    }

    public Double getOtherAsinUnits() {
        return otherAsinUnits;
    }

    public void setOtherAsinUnits(Double otherAsinUnits) {
        this.otherAsinUnits = otherAsinUnits;
    }

    public Double getOtherAsinUnitsOrdered() {
        return otherAsinUnitsOrdered;
    }

    public void setOtherAsinUnitsOrdered(Double otherAsinUnitsOrdered) {
        this.otherAsinUnitsOrdered = otherAsinUnitsOrdered;
    }

    public BigDecimal getOtherAsinUnitsOrderedSales() {
        return otherAsinUnitsOrderedSales;
    }

    public void setOtherAsinUnitsOrderedSales(BigDecimal otherAsinUnitsOrderedSales) {
        this.otherAsinUnitsOrderedSales = otherAsinUnitsOrderedSales;
    }
}

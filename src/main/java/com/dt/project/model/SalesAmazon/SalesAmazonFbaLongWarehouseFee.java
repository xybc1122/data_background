package com.dt.project.model.salesAmazon;


import com.dt.project.model.parent.ParentUploadInfo;

import java.math.BigDecimal;

public class SalesAmazonFbaLongWarehouseFee extends ParentUploadInfo {

    private Long lwId;
    private String lwSku;
    private String fnSku;
    private String asin;
    private String condition;
    private Integer qtyChargedTwelveMoLongTermStorageFee;
    private BigDecimal perUnitVolume;
    private String currency;
    private BigDecimal twelveMoLongTermsStorageFee;
    private Integer qtyChargedSixMoLongTermStorageFee;
    private BigDecimal sixMoLongTermsStorageFee;
    private String volumeUnit;
    private String country;
    private String enrolledInSmallAndLight;
    private String productName;

    public SalesAmazonFbaLongWarehouseFee(){

    }

    public SalesAmazonFbaLongWarehouseFee(Integer shopId, Long createDate, String createUser, Long recordingId) {
        super(shopId, null, createDate, createUser, recordingId);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getLwId() {
        return lwId;
    }

    public void setLwId(Long lwId) {
        this.lwId = lwId;
    }

    public String getLwSku() {
        return lwSku;
    }

    public void setLwSku(String lwSku) {
        this.lwSku = lwSku;
    }

    public String getFnSku() {
        return fnSku;
    }

    public void setFnSku(String fnSku) {
        this.fnSku = fnSku;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Integer getQtyChargedTwelveMoLongTermStorageFee() {
        return qtyChargedTwelveMoLongTermStorageFee;
    }

    public void setQtyChargedTwelveMoLongTermStorageFee(Integer qtyChargedTwelveMoLongTermStorageFee) {
        this.qtyChargedTwelveMoLongTermStorageFee = qtyChargedTwelveMoLongTermStorageFee;
    }

    public BigDecimal getPerUnitVolume() {
        return perUnitVolume;
    }

    public void setPerUnitVolume(BigDecimal perUnitVolume) {
        this.perUnitVolume = perUnitVolume;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getTwelveMoLongTermsStorageFee() {
        return twelveMoLongTermsStorageFee;
    }

    public void setTwelveMoLongTermsStorageFee(BigDecimal twelveMoLongTermsStorageFee) {
        this.twelveMoLongTermsStorageFee = twelveMoLongTermsStorageFee;
    }

    public Integer getQtyChargedSixMoLongTermStorageFee() {
        return qtyChargedSixMoLongTermStorageFee;
    }

    public void setQtyChargedSixMoLongTermStorageFee(Integer qtyChargedSixMoLongTermStorageFee) {
        this.qtyChargedSixMoLongTermStorageFee = qtyChargedSixMoLongTermStorageFee;
    }

    public BigDecimal getSixMoLongTermsStorageFee() {
        return sixMoLongTermsStorageFee;
    }

    public void setSixMoLongTermsStorageFee(BigDecimal sixMoLongTermsStorageFee) {
        this.sixMoLongTermsStorageFee = sixMoLongTermsStorageFee;
    }

    public String getVolumeUnit() {
        return volumeUnit;
    }

    public void setVolumeUnit(String volumeUnit) {
        this.volumeUnit = volumeUnit;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEnrolledInSmallAndLight() {
        return enrolledInSmallAndLight;
    }

    public void setEnrolledInSmallAndLight(String enrolledInSmallAndLight) {
        this.enrolledInSmallAndLight = enrolledInSmallAndLight;
    }
}

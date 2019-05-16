package com.dt.project.model.SalesAmazon;


import com.dt.project.model.Parent.ParentUploadInfo;

/**
 * 月度仓储费
 */
public class SalesAmazonFbaMonthWarehouseFee extends ParentUploadInfo {

    private Long wId;
    private String asin;
    private String fnSku;
    private String productName;
    private String fc;
    private Integer awId;
    private String countryCode;
    private Double longestSide;
    private Double medianSide;
    private Double shortestSide;
    private String measurementUnits;
    private Double weight;
    private String weightUnits;
    private Double itemVolume;
    private String volumeUnits;
    private String productSizeTier;
    private Double averageQuantityOnHand;
    private Double averageQuantityPendingRemoval;
    private Double estimatedTotalItemVolume;
    private String monthOfCharge;
    private Double storageRate;
    private String currency;
    private Double estimatedMonthlyStorageFee;
    /**
     * 亚马逊仓库code
     */
    private String warehouseCode;


    public SalesAmazonFbaMonthWarehouseFee(){

    }

    public SalesAmazonFbaMonthWarehouseFee(Integer shopId, Long createDate, String createUser, Long recordingId) {
        super(shopId, null, createDate, createUser, recordingId);
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getMonthOfCharge() {
        return monthOfCharge;
    }

    public void setMonthOfCharge(String monthOfCharge) {
        this.monthOfCharge = monthOfCharge;
    }

    public Long getwId() {
        return wId;
    }

    public void setwId(Long wId) {
        this.wId = wId;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getFnSku() {
        return fnSku;
    }

    public void setFnSku(String fnSku) {
        this.fnSku = fnSku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getFc() {
        return fc;
    }

    public void setFc(String fc) {
        this.fc = fc;
    }

    public Integer getAwId() {
        return awId;
    }

    public void setAwId(Integer awId) {
        this.awId = awId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Double getLongestSide() {
        return longestSide;
    }

    public void setLongestSide(Double longestSide) {
        this.longestSide = longestSide;
    }

    public Double getMedianSide() {
        return medianSide;
    }

    public void setMedianSide(Double medianSide) {
        this.medianSide = medianSide;
    }

    public Double getShortestSide() {
        return shortestSide;
    }

    public void setShortestSide(Double shortestSide) {
        this.shortestSide = shortestSide;
    }

    public String getMeasurementUnits() {
        return measurementUnits;
    }

    public void setMeasurementUnits(String measurementUnits) {
        this.measurementUnits = measurementUnits;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getWeightUnits() {
        return weightUnits;
    }

    public void setWeightUnits(String weightUnits) {
        this.weightUnits = weightUnits;
    }

    public Double getItemVolume() {
        return itemVolume;
    }

    public void setItemVolume(Double itemVolume) {
        this.itemVolume = itemVolume;
    }

    public String getVolumeUnits() {
        return volumeUnits;
    }

    public void setVolumeUnits(String volumeUnits) {
        this.volumeUnits = volumeUnits;
    }

    public String getProductSizeTier() {
        return productSizeTier;
    }

    public void setProductSizeTier(String productSizeTier) {
        this.productSizeTier = productSizeTier;
    }

    public Double getAverageQuantityOnHand() {
        return averageQuantityOnHand;
    }

    public void setAverageQuantityOnHand(Double averageQuantityOnHand) {
        this.averageQuantityOnHand = averageQuantityOnHand;
    }

    public Double getAverageQuantityPendingRemoval() {
        return averageQuantityPendingRemoval;
    }

    public void setAverageQuantityPendingRemoval(Double averageQuantityPendingRemoval) {
        this.averageQuantityPendingRemoval = averageQuantityPendingRemoval;
    }

    public Double getEstimatedTotalItemVolume() {
        return estimatedTotalItemVolume;
    }

    public void setEstimatedTotalItemVolume(Double estimatedTotalItemVolume) {
        this.estimatedTotalItemVolume = estimatedTotalItemVolume;
    }


    public Double getStorageRate() {
        return storageRate;
    }

    public void setStorageRate(Double storageRate) {
        this.storageRate = storageRate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getEstimatedMonthlyStorageFee() {
        return estimatedMonthlyStorageFee;
    }

    public void setEstimatedMonthlyStorageFee(Double estimatedMonthlyStorageFee) {
        this.estimatedMonthlyStorageFee = estimatedMonthlyStorageFee;
    }
}

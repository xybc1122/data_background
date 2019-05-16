package com.dt.project.model.BasePublicModel;

import com.dt.project.model.Parent.ParentSysTemLog;

/**
 * sku表
 */
public class BasicPublicSku extends ParentSysTemLog {

    private Long skuId;
    private Long shopId;
    private Long siteId;
    private String sku;
    private String fnsku;
    private String sAsin;
    private Integer productId;
    private Integer classId;
    private Double lengthCm;
    private Double widthCm;
    private Double heightCm;
    private Double gwKg;
    private Double nwKg;
    private Double volumeM3;

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getFnsku() {
        return fnsku;
    }

    public void setFnsku(String fnsku) {
        this.fnsku = fnsku;
    }

    public String getsAsin() {
        return sAsin;
    }

    public void setsAsin(String sAsin) {
        this.sAsin = sAsin;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Double getLengthCm() {
        return lengthCm;
    }

    public void setLengthCm(Double lengthCm) {
        this.lengthCm = lengthCm;
    }

    public Double getWidthCm() {
        return widthCm;
    }

    public void setWidthCm(Double widthCm) {
        this.widthCm = widthCm;
    }

    public Double getHeightCm() {
        return heightCm;
    }

    public void setHeightCm(Double heightCm) {
        this.heightCm = heightCm;
    }

    public Double getGwKg() {
        return gwKg;
    }

    public void setGwKg(Double gwKg) {
        this.gwKg = gwKg;
    }

    public Double getNwKg() {
        return nwKg;
    }

    public void setNwKg(Double nwKg) {
        this.nwKg = nwKg;
    }

    public Double getVolumeM3() {
        return volumeM3;
    }

    public void setVolumeM3(Double volumeM3) {
        this.volumeM3 = volumeM3;
    }
}

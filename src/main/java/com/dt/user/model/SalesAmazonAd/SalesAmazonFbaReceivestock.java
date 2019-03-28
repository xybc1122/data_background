package com.dt.user.model.SalesAmazonAd;

import com.dt.user.model.ParentUploadInfo;

/**
 * 接收库存
 */
public class SalesAmazonFbaReceivestock extends ParentUploadInfo {

    private Long id;
    private String fbaShipmentId;
    private String fnsku;
    private Long skuId;
    private String productName;
    private Integer quantity;
    private String fc;
    private Integer awId;

    public SalesAmazonFbaReceivestock() {

    }

    public SalesAmazonFbaReceivestock(Integer shopId, Long createDate, String createUser, Long recordingId) {
        super(shopId, null, createDate, createUser, recordingId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFbaShipmentId() {
        return fbaShipmentId;
    }

    public void setFbaShipmentId(String fbaShipmentId) {
        this.fbaShipmentId = fbaShipmentId;
    }

    public String getFnsku() {
        return fnsku;
    }

    public void setFnsku(String fnsku) {
        this.fnsku = fnsku;
    }

    @Override
    public Long getSkuId() {
        return skuId;
    }

    @Override
    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
}

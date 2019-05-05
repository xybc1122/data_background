package com.dt.user.model.SalesAmazon;

import com.dt.user.model.Parent.ParentUploadInfo;

/**
 * 期末库存
 */
public class SalesAmazonFbaInventoryEnd extends ParentUploadInfo {

    private Long invId;
    private String fnSku;
    private String productName;
    private Integer quantity;
    private String fc;
    private Integer awId;
    private String disposition;
    private String country;
    private String invSku;


    public SalesAmazonFbaInventoryEnd() {

    }

    public SalesAmazonFbaInventoryEnd(Integer shopId, Long createDate, Long createIdUser, Long recordingId) {
        super(shopId, null, createDate, createIdUser, recordingId);
    }

    public String getInvSku() {
        return invSku;
    }

    public void setInvSku(String invSku) {
        this.invSku = invSku;
    }

    public Long getInvId() {
        return invId;
    }

    public void setInvId(Long invId) {
        this.invId = invId;
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

    public String getDisposition() {
        return disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

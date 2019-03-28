package com.dt.user.model.SalesAmazonAd;

import com.dt.user.model.ParentUploadInfo;

/**
 * 期末库存
 */
public class SalesAmazonFbaInventoryEnd extends ParentUploadInfo {

    private Long id;
    private String fnsku;
    private String productName;
    private Integer quantity;
    private String fc;
    private Integer awId;
    private String disposition;
    private String country;


    public SalesAmazonFbaInventoryEnd() {

    }

    public SalesAmazonFbaInventoryEnd(Integer shopId, Long createDate, String createUser, Long recordingId) {
        super(shopId, null, createDate, createUser, recordingId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFnsku() {
        return fnsku;
    }

    public void setFnsku(String fnsku) {
        this.fnsku = fnsku;
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

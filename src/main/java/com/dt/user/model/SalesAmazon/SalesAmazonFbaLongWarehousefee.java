package com.dt.user.model.SalesAmazon;

import com.dt.user.model.ParentUploadInfo;

/**
 * 长期仓储费
 */
public class SalesAmazonFbaLongWarehousefee extends ParentUploadInfo {

    private Long lwId;
    private String fbaShipmentId;
    private String lwSku;
    private String fnSku;
    private String productName;
    private Long quantity;
    private String fc;
    private Long awId;

    public Long getLwId() {
        return lwId;
    }

    public void setLwId(Long lwId) {
        this.lwId = lwId;
    }

    public String getFbaShipmentId() {
        return fbaShipmentId;
    }

    public void setFbaShipmentId(String fbaShipmentId) {
        this.fbaShipmentId = fbaShipmentId;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getFc() {
        return fc;
    }

    public void setFc(String fc) {
        this.fc = fc;
    }

    public Long getAwId() {
        return awId;
    }

    public void setAwId(Long awId) {
        this.awId = awId;
    }
}

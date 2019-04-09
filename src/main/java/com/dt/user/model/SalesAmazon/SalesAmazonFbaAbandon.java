package com.dt.user.model.SalesAmazon;
import com.dt.user.model.ParentUploadInfo;

/**
 * FBA遗弃
 */
public class SalesAmazonFbaAbandon extends ParentUploadInfo {

    private Long aId;
    private String fbaShipmentId;
    private String abandonSku;
    private String fnSku;
    private String productName;
    private Long quantity;
    private String fc;
    private Long awId;

    public Long getaId() {
        return aId;
    }

    public void setaId(Long aId) {
        this.aId = aId;
    }

    public String getFbaShipmentId() {
        return fbaShipmentId;
    }

    public void setFbaShipmentId(String fbaShipmentId) {
        this.fbaShipmentId = fbaShipmentId;
    }

    public String getAbandonSku() {
        return abandonSku;
    }

    public void setAbandonSku(String abandonSku) {
        this.abandonSku = abandonSku;
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

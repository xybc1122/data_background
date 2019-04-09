package com.dt.user.model.SalesAmazon;


import com.dt.user.model.ParentUploadInfo;

/**
 * 月度仓储费
 */
public class SalesAmazonFbaMonthWarehousefee extends ParentUploadInfo {

    private long wId;
    private String fbaShipmentId;
    private String warSku;
    private String fnSku;
    private String productName;
    private long quantity;
    private String fc;
    private long awId;

    public long getwId() {
        return wId;
    }

    public void setwId(long wId) {
        this.wId = wId;
    }

    public String getFbaShipmentId() {
        return fbaShipmentId;
    }

    public void setFbaShipmentId(String fbaShipmentId) {
        this.fbaShipmentId = fbaShipmentId;
    }

    public String getWarSku() {
        return warSku;
    }

    public void setWarSku(String warSku) {
        this.warSku = warSku;
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

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getFc() {
        return fc;
    }

    public void setFc(String fc) {
        this.fc = fc;
    }

    public long getAwId() {
        return awId;
    }

    public void setAwId(long awId) {
        this.awId = awId;
    }
}

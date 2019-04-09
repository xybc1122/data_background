package com.dt.user.model.SalesAmazon;

import com.dt.user.model.ParentUploadInfo;

/**
 * 接收库存
 */
public class SalesAmazonFbaReceivestock extends ParentUploadInfo {

    private Long recId;
    private String fbaShipmentId;
    private String fnSku;
    private String productName;
    private Integer quantity;
    private String fc;
    private Integer awId;
    private String recSku;

    public SalesAmazonFbaReceivestock() {

    }

    public SalesAmazonFbaReceivestock(Integer shopId, Long createDate, String createUser, Long recordingId) {
        super(shopId, null, createDate, createUser, recordingId);
    }

    public Long getRecId() {
        return recId;
    }

    public void setRecId(Long recId) {
        this.recId = recId;
    }

    public String getFbaShipmentId() {
        return fbaShipmentId;
    }

    public void setFbaShipmentId(String fbaShipmentId) {
        this.fbaShipmentId = fbaShipmentId;
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

    public String getRecSku() {
        return recSku;
    }

    public void setRecSku(String recSku) {
        this.recSku = recSku;
    }
}

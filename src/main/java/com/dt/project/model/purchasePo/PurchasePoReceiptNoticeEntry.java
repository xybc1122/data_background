package com.dt.project.model.purchasePo;

import com.dt.project.model.parent.ParentDocumentChild;
/**
 * 收货通知单表体
 */
public class PurchasePoReceiptNoticeEntry extends ParentDocumentChild {
    private Long rneId;
    private Long rnId;
    private Long poeId;
    private Long deliveryDate;
    private Long transportCompanyId;
    private String trackingNumber;
    /**
     * 货运公司
     */
    private String transportCompanyName;

    public Long getRneId() {
        return rneId;
    }

    public void setRneId(Long rneId) {
        this.rneId = rneId;
    }

    public Long getRnId() {
        return rnId;
    }

    public void setRnId(Long rnId) {
        this.rnId = rnId;
    }

    public Long getPoeId() {
        return poeId;
    }

    public void setPoeId(Long poeId) {
        this.poeId = poeId;
    }

    public Long getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Long deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Long getTransportCompanyId() {
        return transportCompanyId;
    }

    public void setTransportCompanyId(Long transportCompanyId) {
        this.transportCompanyId = transportCompanyId;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getTransportCompanyName() {
        return transportCompanyName;
    }

    public void setTransportCompanyName(String transportCompanyName) {
        this.transportCompanyName = transportCompanyName;
    }
}
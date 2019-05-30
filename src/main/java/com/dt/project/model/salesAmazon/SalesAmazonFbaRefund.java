package com.dt.project.model.salesAmazon;


import com.dt.project.model.parent.ParentUploadInfo;

import java.util.List;

/**
 * 退货报告
 */
public class SalesAmazonFbaRefund extends ParentUploadInfo {

    private Long refId;
    private Long purchaseDate;
    private String orderId;
    private String sAsin;
    private String fnSku;
    private String pName;
    private Integer quantity;
    private String fc;
    private Long awId;
    private String detailedDisposition;
    private String reason;
    private String refundStatus;
    private String licensePlateNumber;
    private String customerRemarks;
    private String refSku;
    /**
     * 下单日期范围查询
     */
    private List<Long> purchaseDates;


    public SalesAmazonFbaRefund() {

    }

    public SalesAmazonFbaRefund(Integer shopId, Long createDate, String createUser, Long recordingId) {
        super(shopId, null, createDate, createUser, recordingId);
    }

    public String getRefSku() {
        return refSku;
    }

    public void setRefSku(String refSku) {
        this.refSku = refSku;
    }

    public List<Long> getPurchaseDates() {
        return purchaseDates;
    }

    public void setPurchaseDates(List<Long> purchaseDates) {
        this.purchaseDates = purchaseDates;
    }

    public Long getRefId() {
        return refId;
    }

    public void setRefId(Long refId) {
        this.refId = refId;
    }

    public Long getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Long purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getsAsin() {
        return sAsin;
    }

    public void setsAsin(String sAsin) {
        this.sAsin = sAsin;
    }

    public String getFnSku() {
        return fnSku;
    }

    public void setFnSku(String fnSku) {
        this.fnSku = fnSku;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
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

    public Long getAwId() {
        return awId;
    }

    public void setAwId(Long awId) {
        this.awId = awId;
    }

    public String getDetailedDisposition() {
        return detailedDisposition;
    }

    public void setDetailedDisposition(String detailedDisposition) {
        this.detailedDisposition = detailedDisposition;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public String getCustomerRemarks() {
        return customerRemarks;
    }

    public void setCustomerRemarks(String customerRemarks) {
        this.customerRemarks = customerRemarks;
    }
}

package com.dt.user.model.SalesAmazonAd;


import com.dt.user.model.ParentUploadInfo;

/**
 * 退货表
 */
public class SalesAmazonFbaRefund extends ParentUploadInfo {

    private Long id;
    private Long purchaseDate;
    private String orderId;
    private String sAsin;
    private String fnsku;
    private Long skuId;
    private String pName;
    private Integer quantity;
    private String fc;
    private Long awId;
    private String detailedDisposition;
    private String reason;
    private String refundStaus;
    private String licensePlateNumber;
    private String customerRemarks;


    public SalesAmazonFbaRefund() {

    }

    public SalesAmazonFbaRefund(Integer shopId, Long createDate, String createUser, Long recordingId) {
        super(shopId, null, createDate, createUser, recordingId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFnsku() {
        return fnsku;
    }

    public void setFnsku(String fnsku) {
        this.fnsku = fnsku;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
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

    public String getRefundStaus() {
        return refundStaus;
    }

    public void setRefundStaus(String refundStaus) {
        this.refundStaus = refundStaus;
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

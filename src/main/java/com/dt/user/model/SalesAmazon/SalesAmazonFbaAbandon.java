package com.dt.user.model.SalesAmazon;


import com.dt.user.model.Parent.ParentUploadInfo;

import java.math.BigDecimal;
import java.util.List;

/**
 * FBA 遗弃
 */
public class SalesAmazonFbaAbandon extends ParentUploadInfo {

    private Long fbaId;
    private Integer areaId;
    private String orderId;
    private String orderType;
    private String orderStatus;
    private Long lastUpdatedDate;
    private List<Long> lastUpdatedDates;
    private String abandonSku;
    private String fnSku;
    private String disposition;
    private Long requestedQuantity;
    private Integer cancelledQuantity;
    private Integer disposedQuantity;
    private Integer shippedQuantity;
    private Integer inProcessQuantity;
    private BigDecimal removalFee;
    private String currency;

    public SalesAmazonFbaAbandon() {


    }
    public SalesAmazonFbaAbandon(Integer sId, Long createDate, String createUser, Long recordingId, Integer aId) {
        super(sId, null, createDate, createUser, recordingId);
        this.areaId = aId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Long getFbaId() {
        return fbaId;
    }

    public void setFbaId(Long fbaId) {
        this.fbaId = fbaId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Long lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public List<Long> getLastUpdatedDates() {
        return lastUpdatedDates;
    }

    public void setLastUpdatedDates(List<Long> lastUpdatedDates) {
        this.lastUpdatedDates = lastUpdatedDates;
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

    public String getDisposition() {
        return disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

    public Long getRequestedQuantity() {
        return requestedQuantity;
    }

    public void setRequestedQuantity(Long requestedQuantity) {
        this.requestedQuantity = requestedQuantity;
    }

    public Integer getCancelledQuantity() {
        return cancelledQuantity;
    }

    public void setCancelledQuantity(Integer cancelledQuantity) {
        this.cancelledQuantity = cancelledQuantity;
    }

    public Integer getDisposedQuantity() {
        return disposedQuantity;
    }

    public void setDisposedQuantity(Integer disposedQuantity) {
        this.disposedQuantity = disposedQuantity;
    }

    public Integer getShippedQuantity() {
        return shippedQuantity;
    }

    public void setShippedQuantity(Integer shippedQuantity) {
        this.shippedQuantity = shippedQuantity;
    }

    public Integer getInProcessQuantity() {
        return inProcessQuantity;
    }

    public void setInProcessQuantity(Integer inProcessQuantity) {
        this.inProcessQuantity = inProcessQuantity;
    }

    public BigDecimal getRemovalFee() {
        return removalFee;
    }

    public void setRemovalFee(BigDecimal removalFee) {
        this.removalFee = removalFee;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}

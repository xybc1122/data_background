package com.dt.project.model.salesAmazon;


import com.dt.project.customize.SelValue;
import com.dt.project.model.parent.ParentUploadInfo;

import java.math.BigDecimal;
import java.util.List;


/**
 * FBA 遗弃
 */
public class SalesAmazonFbaAbandon extends ParentUploadInfo {

    @SelValue(column = "fba_id", property = "fbaId")
    private Long fbaId;
    @SelValue(column = "area_id", property = "areaId")
    private Integer areaId;
    @SelValue(column = "order_id", property = "orderId")
    private String orderId;
    @SelValue(column = "order_type", property = "orderType")
    private String orderType;
    @SelValue(column = "order_status", property = "orderStatus")
    private String orderStatus;

    @SelValue(column = "abandon_sku", property = "abandonSku")
    private String abandonSku;

    @SelValue(column = "fn_sku", property = "fnSku")
    private String fnSku;

    @SelValue(column = "disposition", property = "disposition")
    private String disposition;

    @SelValue(column = "requested_quantity", property = "requestedQuantity")
    private Long requestedQuantity;

    @SelValue(column = "cancelled_quantity", property = "cancelledQuantity")
    private Integer cancelledQuantity;

    @SelValue(column = "disposed_quantity", property = "disposedQuantity")
    private Integer disposedQuantity;

    @SelValue(column = "shipped_quantity", property = "shippedQuantity")
    private Integer shippedQuantity;

    @SelValue(column = "in_process_quantity", property = "inProcessQuantity")
    private Integer inProcessQuantity;

    @SelValue(column = "removal_fee", property = "removalFee")
    private BigDecimal removalFee;

    @SelValue(column = "currency", property = "currency")
    private String currency;


    private Long lastUpdatedDate;

    private List<Long> lastUpdatedDates;

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

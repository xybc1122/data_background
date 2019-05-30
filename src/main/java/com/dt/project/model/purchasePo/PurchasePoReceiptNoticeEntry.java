package com.dt.project.model.purchasePo;

import java.math.BigDecimal;

public class PurchasePoReceiptNoticeEntry {
    private Long rneId;

    private Integer entryId;

    private Long rnId;

    private Integer productId;

    private Long sourceTypeId;

    private String sourceId;

    private Long poeId;

    private Long deliveryDate;

    private Long reciveWarehouseId;

    private Long recivePositionId;

    private BigDecimal quantity;

    private Long transportCompanyId;

    private String trackingnumber;

    private String rneRemark;

    private Integer rowClosed;

    private Long statusId;

    private Integer version;

    private Boolean delOrNot;

    public Long getRneId() {
        return rneId;
    }

    public void setRneId(Long rneId) {
        this.rneId = rneId;
    }

    public Integer getEntryId() {
        return entryId;
    }

    public void setEntryId(Integer entryId) {
        this.entryId = entryId;
    }

    public Long getRnId() {
        return rnId;
    }

    public void setRnId(Long rnId) {
        this.rnId = rnId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Long getSourceTypeId() {
        return sourceTypeId;
    }

    public void setSourceTypeId(Long sourceTypeId) {
        this.sourceTypeId = sourceTypeId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId == null ? null : sourceId.trim();
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

    public Long getReciveWarehouseId() {
        return reciveWarehouseId;
    }

    public void setReciveWarehouseId(Long reciveWarehouseId) {
        this.reciveWarehouseId = reciveWarehouseId;
    }

    public Long getRecivePositionId() {
        return recivePositionId;
    }

    public void setRecivePositionId(Long recivePositionId) {
        this.recivePositionId = recivePositionId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Long getTransportCompanyId() {
        return transportCompanyId;
    }

    public void setTransportCompanyId(Long transportCompanyId) {
        this.transportCompanyId = transportCompanyId;
    }

    public String getTrackingnumber() {
        return trackingnumber;
    }

    public void setTrackingnumber(String trackingnumber) {
        this.trackingnumber = trackingnumber == null ? null : trackingnumber.trim();
    }

    public String getRneRemark() {
        return rneRemark;
    }

    public void setRneRemark(String rneRemark) {
        this.rneRemark = rneRemark == null ? null : rneRemark.trim();
    }

    public Integer getRowClosed() {
        return rowClosed;
    }

    public void setRowClosed(Integer rowClosed) {
        this.rowClosed = rowClosed;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean getDelOrNot() {
        return delOrNot;
    }

    public void setDelOrNot(Boolean delOrNot) {
        this.delOrNot = delOrNot;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rneId=").append(rneId);
        sb.append(", entryId=").append(entryId);
        sb.append(", rnId=").append(rnId);
        sb.append(", productId=").append(productId);
        sb.append(", sourceTypeId=").append(sourceTypeId);
        sb.append(", sourceId=").append(sourceId);
        sb.append(", poeId=").append(poeId);
        sb.append(", deliveryDate=").append(deliveryDate);
        sb.append(", reciveWarehouseId=").append(reciveWarehouseId);
        sb.append(", recivePositionId=").append(recivePositionId);
        sb.append(", quantity=").append(quantity);
        sb.append(", transportCompanyId=").append(transportCompanyId);
        sb.append(", trackingnumber=").append(trackingnumber);
        sb.append(", rneRemark=").append(rneRemark);
        sb.append(", rowClosed=").append(rowClosed);
        sb.append(", statusId=").append(statusId);
        sb.append(", version=").append(version);
        sb.append(", delOrNot=").append(delOrNot);
        sb.append("]");
        return sb.toString();
    }
}
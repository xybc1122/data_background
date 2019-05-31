package com.dt.project.model.purchasePo;

import com.dt.project.model.JavaSqlName;
import com.dt.project.model.parent.ParentSysTemLog;

import java.math.BigDecimal;
import java.util.List;

/**
 * 收货通知单表体
 */
public class PurchasePoReceiptNoticeEntry {
    private Long rneId;

    private Integer entryId;

    private Long rnId;

    private Integer productId;

    private Long sourceTypeId;

    private Long sourceId;

    private Long poeId;

    private Long deliveryDate;

    private Long reciveWarehouseId;

    private Long recivePositionId;

    private BigDecimal quantity;

    private Long transportCompanyId;

    private String trackingNumber;

    private String rneRemark;

    private Integer rowClosed;

    /**
     * 是否删除标志
     */
    private Integer delOrNot;
    /**
     * 版本标识
     */
    private Integer version;

    /**
     * 前端查询参数封装对象
     */
    private List<JavaSqlName> javaSqlName;

    /**
     * in查询存储id
     */
    private List<Long> inList;

    public Integer getDelOrNot() {
        return delOrNot;
    }

    public void setDelOrNot(Integer delOrNot) {
        this.delOrNot = delOrNot;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<JavaSqlName> getJavaSqlName() {
        return javaSqlName;
    }

    public void setJavaSqlName(List<JavaSqlName> javaSqlName) {
        this.javaSqlName = javaSqlName;
    }

    public List<Long> getInList() {
        return inList;
    }

    public void setInList(List<Long> inList) {
        this.inList = inList;
    }

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

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
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

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
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

}
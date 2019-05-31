package com.dt.project.model.purchasePo;

import com.dt.project.model.JavaSqlName;

import java.math.BigDecimal;
import java.util.List;

/**
 * 外购入库单表体
 */
public class PurchaseIcBillStockEntry {
    private Long sbeId;

    private Integer entryId;

    private Long sbId;

    private Integer productId;

    private Long sourceTypeId;

    private Long icBSourceId;

    private Long rneId;

    private Long reciveWarehouseId;

    private Long recivePositionId;

    private BigDecimal quantity;

    private String icBRemark;

    private Integer rowClosed;

    private Integer version;

    private Boolean delOrNot;

    /**
     * 前端查询参数封装对象
     */
    private List<JavaSqlName> javaSqlName;

    /**
     * in查询存储id
     */
    private List<Long> inList;

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

    public Long getSbeId() {
        return sbeId;
    }

    public void setSbeId(Long sbeId) {
        this.sbeId = sbeId;
    }

    public Integer getEntryId() {
        return entryId;
    }

    public void setEntryId(Integer entryId) {
        this.entryId = entryId;
    }

    public Long getSbId() {
        return sbId;
    }

    public void setSbId(Long sbId) {
        this.sbId = sbId;
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

    public Long getIcBSourceId() {
        return icBSourceId;
    }

    public void setIcBSourceId(Long icBSourceId) {
        this.icBSourceId = icBSourceId;
    }

    public Long getRneId() {
        return rneId;
    }

    public void setRneId(Long rneId) {
        this.rneId = rneId;
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

    public String getIcBRemark() {
        return icBRemark;
    }

    public void setIcBRemark(String icBRemark) {
        this.icBRemark = icBRemark;
    }

    public Integer getRowClosed() {
        return rowClosed;
    }

    public void setRowClosed(Integer rowClosed) {
        this.rowClosed = rowClosed;
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
}
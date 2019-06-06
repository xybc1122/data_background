package com.dt.project.model.parent;

import com.alibaba.fastjson.JSONArray;

import java.math.BigDecimal;
import java.util.List;

/**
 * 单据表子表的父类
 */
public class ParentDocumentChild {

    private Integer entryId;
    private Long sourceTypeId;

    private Integer productId;

    private BigDecimal quantity;

    private Long sourceId;

    private Integer version;

    private Boolean delOrNot;

    private String eRemark;


    private Integer rowClosed;


    private Integer reciveWarehouseId;

    private Long recivePositionId;
    /**
     * 产品代码
     */
    private String productCode;
    /**
     * 规格型号
     */
    private String model;

    /**
     * 产品名称
     */
    private String productName;
    /**
     * 仓库名
     */
    private String warehouseName;

    /**
     * 仓位
     */
    private String positionName;

    /**
     * 检验方式ID
     */
    private Integer inspectionMethodId;
    /**
     * 检验方式名称
     */
    private String inspectionQuarantineName;
    /**
     * 计量单位ID
     */
    private Integer unitId;
    /**
     * 计量单位
     */
    private String unitName;

    /**
     * 动态查询对象
     */
    private JSONArray jsonArray;

    /**
     * in查询存储id
     */
    private List<Long> inList;


    public JSONArray getJsonArray() {
        return jsonArray;
    }

    public void setJsonArray(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
    }

    public Integer getInspectionMethodId() {
        return inspectionMethodId;
    }

    public void setInspectionMethodId(Integer inspectionMethodId) {
        this.inspectionMethodId = inspectionMethodId;
    }

    public String getInspectionQuarantineName() {
        return inspectionQuarantineName;
    }

    public void setInspectionQuarantineName(String inspectionQuarantineName) {
        this.inspectionQuarantineName = inspectionQuarantineName;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Integer getEntryId() {
        return entryId;
    }

    public void setEntryId(Integer entryId) {
        this.entryId = entryId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String geteRemark() {
        return eRemark;
    }

    public void seteRemark(String eRemark) {
        this.eRemark = eRemark;
    }

    public Integer getRowClosed() {
        return rowClosed;
    }

    public void setRowClosed(Integer rowClosed) {
        this.rowClosed = rowClosed;
    }

    public Integer getReciveWarehouseId() {
        return reciveWarehouseId;
    }

    public void setReciveWarehouseId(Integer reciveWarehouseId) {
        this.reciveWarehouseId = reciveWarehouseId;
    }

    public Long getRecivePositionId() {
        return recivePositionId;
    }

    public void setRecivePositionId(Long recivePositionId) {
        this.recivePositionId = recivePositionId;
    }

    public List<Long> getInList() {
        return inList;
    }

    public void setInList(List<Long> inList) {
        this.inList = inList;
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
}

package com.dt.project.model.purchasePo;

import com.dt.project.model.parent.ParentSysTemLog;

import java.math.BigDecimal;

/**
 * 采购订单表体
 */
public class PurchasePoOrderEntry extends ParentSysTemLog {
    private Long poeId;

    private Integer entryId;

    private Long poId;

    private Integer productId;

    private BigDecimal taxRate;

    private BigDecimal price;

    private BigDecimal priceTax;

    private BigDecimal poeTaxAmount;

    private BigDecimal poeAmount;

    private BigDecimal poeAmountTax;

    private Long poeSourceTypeId;

    private String poeSourceId;

    private Long deliveryDate;

    private Long invoiceEntryId;

    private Long reciveWarehouseId;

    private Long recivePositionId;

    private BigDecimal poeQuQty;

    private BigDecimal poeFaQty;

    private BigDecimal poeInboundQty;

    private BigDecimal poeReturnQty;

    private String poeRemark;

    public Long getPoeId() {
        return poeId;
    }

    public void setPoeId(Long poeId) {
        this.poeId = poeId;
    }

    public Integer getEntryId() {
        return entryId;
    }

    public void setEntryId(Integer entryId) {
        this.entryId = entryId;
    }

    public Long getPoId() {
        return poId;
    }

    public void setPoId(Long poId) {
        this.poId = poId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceTax() {
        return priceTax;
    }

    public void setPriceTax(BigDecimal priceTax) {
        this.priceTax = priceTax;
    }

    public BigDecimal getPoeTaxAmount() {
        return poeTaxAmount;
    }

    public void setPoeTaxAmount(BigDecimal poeTaxAmount) {
        this.poeTaxAmount = poeTaxAmount;
    }

    public BigDecimal getPoeAmount() {
        return poeAmount;
    }

    public void setPoeAmount(BigDecimal poeAmount) {
        this.poeAmount = poeAmount;
    }

    public BigDecimal getPoeAmountTax() {
        return poeAmountTax;
    }

    public void setPoeAmountTax(BigDecimal poeAmountTax) {
        this.poeAmountTax = poeAmountTax;
    }

    public Long getPoeSourceTypeId() {
        return poeSourceTypeId;
    }

    public void setPoeSourceTypeId(Long poeSourceTypeId) {
        this.poeSourceTypeId = poeSourceTypeId;
    }

    public String getPoeSourceId() {
        return poeSourceId;
    }

    public void setPoeSourceId(String poeSourceId) {
        this.poeSourceId = poeSourceId == null ? null : poeSourceId.trim();
    }

    public Long getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Long deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Long getInvoiceEntryId() {
        return invoiceEntryId;
    }

    public void setInvoiceEntryId(Long invoiceEntryId) {
        this.invoiceEntryId = invoiceEntryId;
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

    public BigDecimal getPoeQuQty() {
        return poeQuQty;
    }

    public void setPoeQuQty(BigDecimal poeQuQty) {
        this.poeQuQty = poeQuQty;
    }

    public BigDecimal getPoeFaQty() {
        return poeFaQty;
    }

    public void setPoeFaQty(BigDecimal poeFaQty) {
        this.poeFaQty = poeFaQty;
    }

    public BigDecimal getPoeInboundQty() {
        return poeInboundQty;
    }

    public void setPoeInboundQty(BigDecimal poeInboundQty) {
        this.poeInboundQty = poeInboundQty;
    }

    public BigDecimal getPoeReturnQty() {
        return poeReturnQty;
    }

    public void setPoeReturnQty(BigDecimal poeReturnQty) {
        this.poeReturnQty = poeReturnQty;
    }

    public String getPoeRemark() {
        return poeRemark;
    }

    public void setPoeRemark(String poeRemark) {
        this.poeRemark = poeRemark == null ? null : poeRemark.trim();
    }

}
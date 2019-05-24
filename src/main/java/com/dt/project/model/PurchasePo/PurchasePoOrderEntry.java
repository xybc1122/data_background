package com.dt.project.model.PurchasePo;

import java.math.BigDecimal;

/**
 * 采购订单表体
 */
public class PurchasePoOrderEntry {
    private Long id;

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

    private Long statusId;

    private Integer version;

    private Boolean delOrNot;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        sb.append(", id=").append(id);
        sb.append(", entryId=").append(entryId);
        sb.append(", poId=").append(poId);
        sb.append(", productId=").append(productId);
        sb.append(", taxRate=").append(taxRate);
        sb.append(", price=").append(price);
        sb.append(", priceTax=").append(priceTax);
        sb.append(", poeTaxAmount=").append(poeTaxAmount);
        sb.append(", poeAmount=").append(poeAmount);
        sb.append(", poeAmountTax=").append(poeAmountTax);
        sb.append(", poeSourceTypeId=").append(poeSourceTypeId);
        sb.append(", poeSourceId=").append(poeSourceId);
        sb.append(", deliveryDate=").append(deliveryDate);
        sb.append(", invoiceEntryId=").append(invoiceEntryId);
        sb.append(", reciveWarehouseId=").append(reciveWarehouseId);
        sb.append(", recivePositionId=").append(recivePositionId);
        sb.append(", poeQuQty=").append(poeQuQty);
        sb.append(", poeFaQty=").append(poeFaQty);
        sb.append(", poeInboundQty=").append(poeInboundQty);
        sb.append(", poeReturnQty=").append(poeReturnQty);
        sb.append(", poeRemark=").append(poeRemark);
        sb.append(", statusId=").append(statusId);
        sb.append(", version=").append(version);
        sb.append(", delOrNot=").append(delOrNot);
        sb.append("]");
        return sb.toString();
    }
}
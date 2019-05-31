package com.dt.project.model.salesAmazon;

import java.math.BigDecimal;

public class PurchasePoOrderEntry {
    private Long poeId;

    private Integer entryId;

    private Long poId;

    private Integer productId;

    private BigDecimal quantity;

    private BigDecimal taxRate;

    private BigDecimal price;

    private BigDecimal priceTax;

    private BigDecimal taxAmt;

    private BigDecimal amount;

    private BigDecimal amountTax;

    private Long poeSourceTypeId;

    private String poeSourceId;

    private Long deliveryDate;

    private Long invoiceEntryId;

    private Long reciveWarehouseId;

    private Long recivePositionId;

    private BigDecimal poeQuQty;

    private BigDecimal poeFaQty;

    private BigDecimal inboundQty;

    private BigDecimal poeReturnQty;

    private String eRemark;

    private Integer rowClosed;

    private Integer version;

    private Boolean delOrNot;

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

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
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

    public BigDecimal getTaxAmt() {
        return taxAmt;
    }

    public void setTaxAmt(BigDecimal taxAmt) {
        this.taxAmt = taxAmt;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmountTax() {
        return amountTax;
    }

    public void setAmountTax(BigDecimal amountTax) {
        this.amountTax = amountTax;
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

    public BigDecimal getInboundQty() {
        return inboundQty;
    }

    public void setInboundQty(BigDecimal inboundQty) {
        this.inboundQty = inboundQty;
    }

    public BigDecimal getPoeReturnQty() {
        return poeReturnQty;
    }

    public void setPoeReturnQty(BigDecimal poeReturnQty) {
        this.poeReturnQty = poeReturnQty;
    }

    public String geteRemark() {
        return eRemark;
    }

    public void seteRemark(String eRemark) {
        this.eRemark = eRemark == null ? null : eRemark.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", poeId=").append(poeId);
        sb.append(", entryId=").append(entryId);
        sb.append(", poId=").append(poId);
        sb.append(", productId=").append(productId);
        sb.append(", quantity=").append(quantity);
        sb.append(", taxRate=").append(taxRate);
        sb.append(", price=").append(price);
        sb.append(", priceTax=").append(priceTax);
        sb.append(", taxAmt=").append(taxAmt);
        sb.append(", amount=").append(amount);
        sb.append(", amountTax=").append(amountTax);
        sb.append(", poeSourceTypeId=").append(poeSourceTypeId);
        sb.append(", poeSourceId=").append(poeSourceId);
        sb.append(", deliveryDate=").append(deliveryDate);
        sb.append(", invoiceEntryId=").append(invoiceEntryId);
        sb.append(", reciveWarehouseId=").append(reciveWarehouseId);
        sb.append(", recivePositionId=").append(recivePositionId);
        sb.append(", poeQuQty=").append(poeQuQty);
        sb.append(", poeFaQty=").append(poeFaQty);
        sb.append(", inboundQty=").append(inboundQty);
        sb.append(", poeReturnQty=").append(poeReturnQty);
        sb.append(", eRemark=").append(eRemark);
        sb.append(", rowClosed=").append(rowClosed);
        sb.append(", version=").append(version);
        sb.append(", delOrNot=").append(delOrNot);
        sb.append("]");
        return sb.toString();
    }
}
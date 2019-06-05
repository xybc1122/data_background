package com.dt.project.model.purchasePo;

import com.dt.project.model.parent.ParentDocumentChild;


import java.math.BigDecimal;

/**
 * 采购订单表体
 */
public class PurchasePoOrderEntry extends ParentDocumentChild {
    private Long poeId;

    private Long poId;

    private BigDecimal taxRate;

    private BigDecimal price;

    private BigDecimal priceTax;

    private BigDecimal taxAmt;

    private BigDecimal amount;

    private BigDecimal amountTax;

    private Long deliveryDate;

    private Long invoiceEntryId;

    private BigDecimal poeQuQty;

    private BigDecimal poeFaQty;

    private BigDecimal inboundQty;

    private BigDecimal poeReturnQty;

    public Long getPoeId() {
        return poeId;
    }

    public void setPoeId(Long poeId) {
        this.poeId = poeId;
    }

    public Long getPoId() {
        return poId;
    }

    public void setPoId(Long poId) {
        this.poId = poId;
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
}
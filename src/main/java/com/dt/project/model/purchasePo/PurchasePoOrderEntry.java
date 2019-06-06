package com.dt.project.model.purchasePo;

import com.dt.project.customize.SelValue;
import com.dt.project.model.parent.ParentDocumentChild;


import java.math.BigDecimal;

/**
 * 采购订单表体
 */
public class PurchasePoOrderEntry extends ParentDocumentChild{


    @SelValue(column = "poe_id",property = "poeId")
    private Long poeId;
    @SelValue(column = "po_id",property = "poId")
    private Long poId;
    @SelValue(column = "tax_rate",property = "taxRate")
    private BigDecimal taxRate;
    @SelValue(column = "price",property = "price")
    private BigDecimal price;
    @SelValue(column = "price_tax",property = "priceTax")
    private BigDecimal priceTax;
    @SelValue(column = "tax_amt",property = "taxAmt")
    private BigDecimal taxAmt;
    @SelValue(column = "amount",property = "amount")
    private BigDecimal amount;
    @SelValue(column = "amount_tax",property = "amountTax")
    private BigDecimal amountTax;
    @SelValue(column = "delivery_date",property = "deliveryDate")
    private Long deliveryDate;
    @SelValue(column = "invoice_entry_id",property = "invoiceEntryId")
    private Long invoiceEntryId;
    @SelValue(column = "poe_qu_qty",property = "poeQuQty")
    private BigDecimal poeQuQty;
    @SelValue(column = "poe_fa_qty",property = "poeFaQty")
    private BigDecimal poeFaQty;
    @SelValue(column = "inbound_qty",property = "inboundQty")
    private BigDecimal inboundQty;
    @SelValue(column = "poe_return_qty",property = "poeReturnQty")
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
package com.dt.user.model;

import java.math.BigDecimal;

/**
 * 德国存入数据表
 */
public class FinancialSalesBalance extends ParentUploadInfo {

    private Long balanceId;
    private String settlemenId;
    private Long paymentTypeId;
    private String financialSku;
    private String type;
    private String orderId;
    private String description;
    private Long oQuantity;
    private Long quantity;
    private Long refundQuantity;
    private Long orderQty;
    private Long adjustmentQty;
    private String marketplace;
    private String fulfillment;
    private String city;
    private String state;
    private String postal;
    private BigDecimal sales;
    private BigDecimal salePrice;
    private BigDecimal preSalePrice;
    private BigDecimal stdSalePrice;
    private BigDecimal newShippingCredits;
    private BigDecimal shippingCredits;
    private BigDecimal giftwrapCredits;
    private BigDecimal promotionalRebates;
    private BigDecimal salesTax;
    private BigDecimal marketplaceFacilitatorTax;
    private BigDecimal sellingFees;
    private BigDecimal fbaFee;
    private BigDecimal otherTransactionFees;
    private BigDecimal other;
    private BigDecimal total;
    private BigDecimal serviceFee;
    private BigDecimal transfer;
    private BigDecimal adjustment;
    private BigDecimal newPromotionalRebates;
    private BigDecimal newShippingFba;
    private BigDecimal stdProductSales;
    private BigDecimal stdSalesOriginal;
    private BigDecimal stdSalesAdd;
    private BigDecimal stdSalesMinus;
    private BigDecimal stdFba;
    private BigDecimal stdFbas;
    private BigDecimal stdFbaOriginal;
    private BigDecimal lightningDealFee;
    private BigDecimal fbaInventoryFee;
    /**
     * 积分费用(日本ポイントの費用)
     */
    private Double pointFee;
    /**
     * 低价值商品(澳洲)
     */
    private Double lowValueGoods;

    public FinancialSalesBalance() {

    }

    public FinancialSalesBalance(Integer shopId, Integer siteId, Long paymentTypeId, Long createDate, String createUser, Long recordingId) {
        super(shopId, siteId, createDate, createUser, recordingId);
        this.paymentTypeId = paymentTypeId;
    }

    public String getFinancialSku() {
        return financialSku;
    }

    public void setFinancialSku(String financialSku) {
        this.financialSku = financialSku;
    }

    public Long getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(Long balanceId) {
        this.balanceId = balanceId;
    }

    public String getSettlemenId() {
        return settlemenId;
    }

    public void setSettlemenId(String settlemenId) {
        this.settlemenId = settlemenId;
    }

    public Long getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(Long paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getoQuantity() {
        return oQuantity;
    }

    public void setoQuantity(Long oQuantity) {
        this.oQuantity = oQuantity;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getRefundQuantity() {
        return refundQuantity;
    }

    public void setRefundQuantity(Long refundQuantity) {
        this.refundQuantity = refundQuantity;
    }

    public Long getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(Long orderQty) {
        this.orderQty = orderQty;
    }

    public Long getAdjustmentQty() {
        return adjustmentQty;
    }

    public void setAdjustmentQty(Long adjustmentQty) {
        this.adjustmentQty = adjustmentQty;
    }

    public String getMarketplace() {
        return marketplace;
    }

    public void setMarketplace(String marketplace) {
        this.marketplace = marketplace;
    }

    public String getFulfillment() {
        return fulfillment;
    }

    public void setFulfillment(String fulfillment) {
        this.fulfillment = fulfillment;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public BigDecimal getSales() {
        return sales;
    }

    public void setSales(BigDecimal sales) {
        this.sales = sales;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getPreSalePrice() {
        return preSalePrice;
    }

    public void setPreSalePrice(BigDecimal preSalePrice) {
        this.preSalePrice = preSalePrice;
    }

    public BigDecimal getStdSalePrice() {
        return stdSalePrice;
    }

    public void setStdSalePrice(BigDecimal stdSalePrice) {
        this.stdSalePrice = stdSalePrice;
    }

    public BigDecimal getNewShippingCredits() {
        return newShippingCredits;
    }

    public void setNewShippingCredits(BigDecimal newShippingCredits) {
        this.newShippingCredits = newShippingCredits;
    }

    public BigDecimal getShippingCredits() {
        return shippingCredits;
    }

    public void setShippingCredits(BigDecimal shippingCredits) {
        this.shippingCredits = shippingCredits;
    }

    public BigDecimal getGiftwrapCredits() {
        return giftwrapCredits;
    }

    public void setGiftwrapCredits(BigDecimal giftwrapCredits) {
        this.giftwrapCredits = giftwrapCredits;
    }

    public BigDecimal getPromotionalRebates() {
        return promotionalRebates;
    }

    public void setPromotionalRebates(BigDecimal promotionalRebates) {
        this.promotionalRebates = promotionalRebates;
    }

    public BigDecimal getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(BigDecimal salesTax) {
        this.salesTax = salesTax;
    }

    public BigDecimal getMarketplaceFacilitatorTax() {
        return marketplaceFacilitatorTax;
    }

    public void setMarketplaceFacilitatorTax(BigDecimal marketplaceFacilitatorTax) {
        this.marketplaceFacilitatorTax = marketplaceFacilitatorTax;
    }

    public BigDecimal getSellingFees() {
        return sellingFees;
    }

    public void setSellingFees(BigDecimal sellingFees) {
        this.sellingFees = sellingFees;
    }

    public BigDecimal getFbaFee() {
        return fbaFee;
    }

    public void setFbaFee(BigDecimal fbaFee) {
        this.fbaFee = fbaFee;
    }

    public BigDecimal getOtherTransactionFees() {
        return otherTransactionFees;
    }

    public void setOtherTransactionFees(BigDecimal otherTransactionFees) {
        this.otherTransactionFees = otherTransactionFees;
    }

    public BigDecimal getOther() {
        return other;
    }

    public void setOther(BigDecimal other) {
        this.other = other;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public BigDecimal getTransfer() {
        return transfer;
    }

    public void setTransfer(BigDecimal transfer) {
        this.transfer = transfer;
    }

    public BigDecimal getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(BigDecimal adjustment) {
        this.adjustment = adjustment;
    }

    public BigDecimal getNewPromotionalRebates() {
        return newPromotionalRebates;
    }

    public void setNewPromotionalRebates(BigDecimal newPromotionalRebates) {
        this.newPromotionalRebates = newPromotionalRebates;
    }

    public BigDecimal getNewShippingFba() {
        return newShippingFba;
    }

    public void setNewShippingFba(BigDecimal newShippingFba) {
        this.newShippingFba = newShippingFba;
    }

    public BigDecimal getStdProductSales() {
        return stdProductSales;
    }

    public void setStdProductSales(BigDecimal stdProductSales) {
        this.stdProductSales = stdProductSales;
    }

    public BigDecimal getStdSalesOriginal() {
        return stdSalesOriginal;
    }

    public void setStdSalesOriginal(BigDecimal stdSalesOriginal) {
        this.stdSalesOriginal = stdSalesOriginal;
    }

    public BigDecimal getStdSalesAdd() {
        return stdSalesAdd;
    }

    public void setStdSalesAdd(BigDecimal stdSalesAdd) {
        this.stdSalesAdd = stdSalesAdd;
    }

    public BigDecimal getStdSalesMinus() {
        return stdSalesMinus;
    }

    public void setStdSalesMinus(BigDecimal stdSalesMinus) {
        this.stdSalesMinus = stdSalesMinus;
    }

    public BigDecimal getStdFba() {
        return stdFba;
    }

    public void setStdFba(BigDecimal stdFba) {
        this.stdFba = stdFba;
    }

    public BigDecimal getStdFbas() {
        return stdFbas;
    }

    public void setStdFbas(BigDecimal stdFbas) {
        this.stdFbas = stdFbas;
    }

    public BigDecimal getStdFbaOriginal() {
        return stdFbaOriginal;
    }

    public void setStdFbaOriginal(BigDecimal stdFbaOriginal) {
        this.stdFbaOriginal = stdFbaOriginal;
    }

    public BigDecimal getLightningDealFee() {
        return lightningDealFee;
    }

    public void setLightningDealFee(BigDecimal lightningDealFee) {
        this.lightningDealFee = lightningDealFee;
    }

    public BigDecimal getFbaInventoryFee() {
        return fbaInventoryFee;
    }

    public void setFbaInventoryFee(BigDecimal fbaInventoryFee) {
        this.fbaInventoryFee = fbaInventoryFee;
    }

    public Double getPointFee() {
        return pointFee;
    }

    public void setPointFee(Double pointFee) {
        this.pointFee = pointFee;
    }

    public Double getLowValueGoods() {
        return lowValueGoods;
    }

    public void setLowValueGoods(Double lowValueGoods) {
        this.lowValueGoods = lowValueGoods;
    }
}

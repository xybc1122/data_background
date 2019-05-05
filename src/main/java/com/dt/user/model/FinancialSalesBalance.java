package com.dt.user.model;

import com.dt.user.model.Parent.ParentUploadInfo;

import java.math.BigDecimal;

/**
 * 德国存入数据表
 */
public class FinancialSalesBalance extends ParentUploadInfo {

    private Long balanceId;
    private String settlementId;
    //付款类型
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
    private BigDecimal newOther;
    private BigDecimal vat;
    private BigDecimal salesForTax;
    private BigDecimal serviceFeeTax;
    //付款类型
    private String paymentTypeName;


    /**
     * 积分费用(日本ポイントの費用)
     */
    private BigDecimal pointFee;
    /**
     * 低价值商品(澳洲)
     */
    private BigDecimal lowValueGoods;

    public FinancialSalesBalance() {

    }

    public FinancialSalesBalance(Integer shopId, Integer siteId, Long paymentTypeId, Long createDate, Long createIdUser, Long recordingId) {
        super(shopId, siteId, createDate, createIdUser, recordingId);
        this.paymentTypeId = paymentTypeId;
    }

    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }

    public BigDecimal getNewOther() {
        return newOther;
    }

    public void setNewOther(BigDecimal newOther) {
        this.newOther = newOther;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public BigDecimal getSalesForTax() {
        return salesForTax;
    }

    public void setSalesForTax(BigDecimal salesForTax) {
        this.salesForTax = salesForTax;
    }

    public BigDecimal getServiceFeeTax() {
        return serviceFeeTax;
    }

    public void setServiceFeeTax(BigDecimal serviceFeeTax) {
        this.serviceFeeTax = serviceFeeTax;
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

    public String getSettlementId() {
        return settlementId;
    }

    public void setSettlementId(String settlementId) {
        this.settlementId = settlementId;
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

    public BigDecimal getPointFee() {
        return pointFee;
    }

    public void setPointFee(BigDecimal pointFee) {
        this.pointFee = pointFee;
    }

    public BigDecimal getLowValueGoods() {
        return lowValueGoods;
    }

    public void setLowValueGoods(BigDecimal lowValueGoods) {
        this.lowValueGoods = lowValueGoods;
    }

    @Override
    public String toString() {
        return "FinancialSalesBalance{" +
                "balanceId=" + balanceId +
                ", settlementId='" + settlementId + '\'' +
                ", paymentTypeId=" + paymentTypeId +
                ", financialSku='" + financialSku + '\'' +
                ", type='" + type + '\'' +
                ", orderId='" + orderId + '\'' +
                ", description='" + description + '\'' +
                ", oQuantity=" + oQuantity +
                ", quantity=" + quantity +
                ", refundQuantity=" + refundQuantity +
                ", orderQty=" + orderQty +
                ", adjustmentQty=" + adjustmentQty +
                ", marketplace='" + marketplace + '\'' +
                ", fulfillment='" + fulfillment + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postal='" + postal + '\'' +
                ", sales=" + sales +
                ", salePrice=" + salePrice +
                ", preSalePrice=" + preSalePrice +
                ", stdSalePrice=" + stdSalePrice +
                ", newShippingCredits=" + newShippingCredits +
                ", shippingCredits=" + shippingCredits +
                ", giftwrapCredits=" + giftwrapCredits +
                ", promotionalRebates=" + promotionalRebates +
                ", salesTax=" + salesTax +
                ", marketplaceFacilitatorTax=" + marketplaceFacilitatorTax +
                ", sellingFees=" + sellingFees +
                ", fbaFee=" + fbaFee +
                ", otherTransactionFees=" + otherTransactionFees +
                ", other=" + other +
                ", total=" + total +
                ", serviceFee=" + serviceFee +
                ", transfer=" + transfer +
                ", adjustment=" + adjustment +
                ", newPromotionalRebates=" + newPromotionalRebates +
                ", newShippingFba=" + newShippingFba +
                ", stdProductSales=" + stdProductSales +
                ", stdSalesOriginal=" + stdSalesOriginal +
                ", stdSalesAdd=" + stdSalesAdd +
                ", stdSalesMinus=" + stdSalesMinus +
                ", stdFba=" + stdFba +
                ", stdFbas=" + stdFbas +
                ", stdFbaOriginal=" + stdFbaOriginal +
                ", lightningDealFee=" + lightningDealFee +
                ", fbaInventoryFee=" + fbaInventoryFee +
                ", newOther=" + newOther +
                ", vat=" + vat +
                ", salesForTax=" + salesForTax +
                ", serviceFeeTax=" + serviceFeeTax +
                ", paymentTypeName='" + paymentTypeName + '\'' +
                ", pointFee=" + pointFee +
                ", lowValueGoods=" + lowValueGoods +
                '}';
    }
}

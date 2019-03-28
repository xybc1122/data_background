package com.dt.user.model;

/**
 * 德国存入数据表
 */
public class FinancialSalesBalance extends ParentUploadInfo {

    private Long balanceId;
    private String settlemenId;
    private Long paymentTypeId;
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
    private Double sales;
    private Double salePrice;
    private Double preSalePrice;
    private Double stdSalePrice;
    private Double newShippingCredits;
    private Double shippingCredits;
    private Double giftwrapCredits;
    private Double promotionalRebates;
    private Double salesTax;
    private Double marketplaceFacilitatorTax;
    private Double sellingFees;
    private Double fbaFee;
    private Double otherTransactionFees;
    private Double other;
    private Double total;
    private Double serviceFee;
    private Double transfer;
    private Double adjustment;
    private Double newPromotionalRebates;
    private Double newShippingFba;
    private Double stdProductSales;
    private Double stdSalesOriginal;
    private Double stdSalesAdd;
    private Double stdSalesMinus;
    private Double stdFba;
    private Double stdFbas;
    private Double stdFbaOriginal;
    private Double lightningDealFee;
    private Double fbaInventoryFee;
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

    public Double getLowValueGoods() {
        return lowValueGoods;
    }

    public void setLowValueGoods(Double lowValueGoods) {
        this.lowValueGoods = lowValueGoods;
    }

    public Double getPointFee() {
        return pointFee;
    }

    public void setPointFee(Double pointFee) {
        this.pointFee = pointFee;
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

    public Double getSales() {
        return sales;
    }

    public void setSales(Double sales) {
        this.sales = sales;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Double getPreSalePrice() {
        return preSalePrice;
    }

    public void setPreSalePrice(Double preSalePrice) {
        this.preSalePrice = preSalePrice;
    }

    public Double getStdSalePrice() {
        return stdSalePrice;
    }

    public void setStdSalePrice(Double stdSalePrice) {
        this.stdSalePrice = stdSalePrice;
    }

    public Double getNewShippingCredits() {
        return newShippingCredits;
    }

    public void setNewShippingCredits(Double newShippingCredits) {
        this.newShippingCredits = newShippingCredits;
    }

    public Double getShippingCredits() {
        return shippingCredits;
    }

    public void setShippingCredits(Double shippingCredits) {
        this.shippingCredits = shippingCredits;
    }

    public Double getGiftwrapCredits() {
        return giftwrapCredits;
    }

    public void setGiftwrapCredits(Double giftwrapCredits) {
        this.giftwrapCredits = giftwrapCredits;
    }

    public Double getPromotionalRebates() {
        return promotionalRebates;
    }

    public void setPromotionalRebates(Double promotionalRebates) {
        this.promotionalRebates = promotionalRebates;
    }

    public Double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(Double salesTax) {
        this.salesTax = salesTax;
    }

    public Double getMarketplaceFacilitatorTax() {
        return marketplaceFacilitatorTax;
    }

    public void setMarketplaceFacilitatorTax(Double marketplaceFacilitatorTax) {
        this.marketplaceFacilitatorTax = marketplaceFacilitatorTax;
    }

    public Double getSellingFees() {
        return sellingFees;
    }

    public void setSellingFees(Double sellingFees) {
        this.sellingFees = sellingFees;
    }

    public Double getFbaFee() {
        return fbaFee;
    }

    public void setFbaFee(Double fbaFee) {
        this.fbaFee = fbaFee;
    }

    public Double getOtherTransactionFees() {
        return otherTransactionFees;
    }

    public void setOtherTransactionFees(Double otherTransactionFees) {
        this.otherTransactionFees = otherTransactionFees;
    }

    public Double getOther() {
        return other;
    }

    public void setOther(Double other) {
        this.other = other;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(Double serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Double getTransfer() {
        return transfer;
    }

    public void setTransfer(Double transfer) {
        this.transfer = transfer;
    }

    public Double getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(Double adjustment) {
        this.adjustment = adjustment;
    }

    public Double getNewPromotionalRebates() {
        return newPromotionalRebates;
    }

    public void setNewPromotionalRebates(Double newPromotionalRebates) {
        this.newPromotionalRebates = newPromotionalRebates;
    }

    public Double getNewShippingFba() {
        return newShippingFba;
    }

    public void setNewShippingFba(Double newShippingFba) {
        this.newShippingFba = newShippingFba;
    }

    public Double getStdProductSales() {
        return stdProductSales;
    }

    public void setStdProductSales(Double stdProductSales) {
        this.stdProductSales = stdProductSales;
    }

    public Double getStdSalesOriginal() {
        return stdSalesOriginal;
    }

    public void setStdSalesOriginal(Double stdSalesOriginal) {
        this.stdSalesOriginal = stdSalesOriginal;
    }

    public Double getStdSalesAdd() {
        return stdSalesAdd;
    }

    public void setStdSalesAdd(Double stdSalesAdd) {
        this.stdSalesAdd = stdSalesAdd;
    }

    public Double getStdSalesMinus() {
        return stdSalesMinus;
    }

    public void setStdSalesMinus(Double stdSalesMinus) {
        this.stdSalesMinus = stdSalesMinus;
    }

    public Double getStdFba() {
        return stdFba;
    }

    public void setStdFba(Double stdFba) {
        this.stdFba = stdFba;
    }

    public Double getStdFbas() {
        return stdFbas;
    }

    public void setStdFbas(Double stdFbas) {
        this.stdFbas = stdFbas;
    }

    public Double getStdFbaOriginal() {
        return stdFbaOriginal;
    }

    public void setStdFbaOriginal(Double stdFbaOriginal) {
        this.stdFbaOriginal = stdFbaOriginal;
    }

    public Double getLightningDealFee() {
        return lightningDealFee;
    }

    public void setLightningDealFee(Double lightningDealFee) {
        this.lightningDealFee = lightningDealFee;
    }

    public Double getFbaInventoryFee() {
        return fbaInventoryFee;
    }

    public void setFbaInventoryFee(Double fbaInventoryFee) {
        this.fbaInventoryFee = fbaInventoryFee;
    }
}

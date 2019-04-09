package com.dt.user.model.SalesAmazon;

import com.dt.user.model.ParentUploadInfo;

import java.util.List;

/**
 * 订单报告表
 */
public class SalesAmazonFbaTradeReport extends ParentUploadInfo {

    private Long tradeId;
    private String amazonOrderId;
    private String merchantOrderId;
    private Long lastUpdatedDate;
    private String orderStatus;
    private String fulfillmentChannel;
    private String salesChannel;
    private String orderChannel;
    private String url;
    private String shipServiceLevel;
    private String productName;
    private String asin;
    private String itemStatus;
    private Integer quantity;
    private String currency;
    private Double itemPrice;
    private Double itemTax;
    private Double shippingPrice;
    private Double shippingTax;
    private Double giftWrapPrice;
    private Double giftWrapTax;
    private Double itemPromotionDiscount;
    private Double shipPromotionDiscount;
    private String shipCity;
    private String shipState;
    private String shipPostalCode;
    private String shipCountry;
    private String promotionIds;
    private String isBusinessOrder;
    private String purchaseOrderNumber;
    private String priceDesignation;
    private String isReplacementOrder;
    private String originalOrderId;
    private String tradeSku;
    /**
     * 最近更新日期
     */
    List<Long> lastUpdatedDates;


    public SalesAmazonFbaTradeReport() {

    }

    public SalesAmazonFbaTradeReport(Integer shopId, Long createDate, String createUser, Long recordingId) {
        super(shopId, null, createDate, createUser, recordingId);
    }

    public List<Long> getLastUpdatedDates() {
        return lastUpdatedDates;
    }

    public void setLastUpdatedDates(List<Long> lastUpdatedDates) {
        this.lastUpdatedDates = lastUpdatedDates;
    }

    public Long getTradeId() {
        return tradeId;
    }

    public void setTradeId(Long tradeId) {
        this.tradeId = tradeId;
    }

    public String getTradeSku() {
        return tradeSku;
    }

    public void setTradeSku(String tradeSku) {
        this.tradeSku = tradeSku;
    }

    public String getAmazonOrderId() {
        return amazonOrderId;
    }

    public void setAmazonOrderId(String amazonOrderId) {
        this.amazonOrderId = amazonOrderId;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public Long getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Long lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getFulfillmentChannel() {
        return fulfillmentChannel;
    }

    public void setFulfillmentChannel(String fulfillmentChannel) {
        this.fulfillmentChannel = fulfillmentChannel;
    }

    public String getSalesChannel() {
        return salesChannel;
    }

    public void setSalesChannel(String salesChannel) {
        this.salesChannel = salesChannel;
    }

    public String getOrderChannel() {
        return orderChannel;
    }

    public void setOrderChannel(String orderChannel) {
        this.orderChannel = orderChannel;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShipServiceLevel() {
        return shipServiceLevel;
    }

    public void setShipServiceLevel(String shipServiceLevel) {
        this.shipServiceLevel = shipServiceLevel;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Double getItemTax() {
        return itemTax;
    }

    public void setItemTax(Double itemTax) {
        this.itemTax = itemTax;
    }

    public Double getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(Double shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public Double getShippingTax() {
        return shippingTax;
    }

    public void setShippingTax(Double shippingTax) {
        this.shippingTax = shippingTax;
    }

    public Double getGiftWrapPrice() {
        return giftWrapPrice;
    }

    public void setGiftWrapPrice(Double giftWrapPrice) {
        this.giftWrapPrice = giftWrapPrice;
    }

    public Double getGiftWrapTax() {
        return giftWrapTax;
    }

    public void setGiftWrapTax(Double giftWrapTax) {
        this.giftWrapTax = giftWrapTax;
    }

    public Double getItemPromotionDiscount() {
        return itemPromotionDiscount;
    }

    public void setItemPromotionDiscount(Double itemPromotionDiscount) {
        this.itemPromotionDiscount = itemPromotionDiscount;
    }

    public Double getShipPromotionDiscount() {
        return shipPromotionDiscount;
    }

    public void setShipPromotionDiscount(Double shipPromotionDiscount) {
        this.shipPromotionDiscount = shipPromotionDiscount;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipState() {
        return shipState;
    }

    public void setShipState(String shipState) {
        this.shipState = shipState;
    }

    public String getShipPostalCode() {
        return shipPostalCode;
    }

    public void setShipPostalCode(String shipPostalCode) {
        this.shipPostalCode = shipPostalCode;
    }

    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }

    public String getPromotionIds() {
        return promotionIds;
    }

    public void setPromotionIds(String promotionIds) {
        this.promotionIds = promotionIds;
    }

    public String getIsBusinessOrder() {
        return isBusinessOrder;
    }

    public void setIsBusinessOrder(String isBusinessOrder) {
        this.isBusinessOrder = isBusinessOrder;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public String getPriceDesignation() {
        return priceDesignation;
    }

    public void setPriceDesignation(String priceDesignation) {
        this.priceDesignation = priceDesignation;
    }

    public String getIsReplacementOrder() {
        return isReplacementOrder;
    }

    public void setIsReplacementOrder(String isReplacementOrder) {
        this.isReplacementOrder = isReplacementOrder;
    }

    public String getOriginalOrderId() {
        return originalOrderId;
    }

    public void setOriginalOrderId(String originalOrderId) {
        this.originalOrderId = originalOrderId;
    }
}

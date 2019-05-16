package com.dt.project.model.BasePublicModel;

import com.dt.project.model.Parent.ParentSysTemLog;

/**
 * 采购价格
 */
public class BasicPurchasePrice extends ParentSysTemLog {

    private Integer purchasePriceId;
    private String productId;
    private Double notTaxPrice;
    private Double taxPrice;
    /**
     * 产品名称
     */
    private String productName;

    public Integer getPurchasePriceId() {
        return purchasePriceId;
    }

    public void setPurchasePriceId(Integer purchasePriceId) {
        this.purchasePriceId = purchasePriceId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Double getNotTaxPrice() {
        return notTaxPrice;
    }

    public void setNotTaxPrice(Double notTaxPrice) {
        this.notTaxPrice = notTaxPrice;
    }

    public Double getTaxPrice() {
        return taxPrice;
    }

    public void setTaxPrice(Double taxPrice) {
        this.taxPrice = taxPrice;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}

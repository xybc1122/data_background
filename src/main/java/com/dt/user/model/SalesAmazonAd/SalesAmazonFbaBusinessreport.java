package com.dt.user.model.SalesAmazonAd;

import com.dt.user.model.ParentUploadInfo;

/**
 * 业务报告导入数据
 */
public class SalesAmazonFbaBusinessreport extends ParentUploadInfo {

    private Long id;
    private String fAsin;
    private String sAsin;
    private String pName;
    private Integer sessionsVisit;
    private Double sessionsPer;
    private Integer pageViews;
    private Double buyBoxPer;
    private Integer order;
    private Integer orderB2B;
    private Double sales;
    private Double salesB2B;
    private Integer orderItems;
    private Integer orderItemsB2B;

    public SalesAmazonFbaBusinessreport() {

    }

    public SalesAmazonFbaBusinessreport(Integer shopId, Integer siteId, Long createDate, String createUser, Long recordingId) {
        super(shopId, siteId, createDate, createUser, recordingId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfAsin() {
        return fAsin;
    }

    public void setfAsin(String fAsin) {
        this.fAsin = fAsin;
    }

    public String getsAsin() {
        return sAsin;
    }

    public void setsAsin(String sAsin) {
        this.sAsin = sAsin;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Integer getSessionsVisit() {
        return sessionsVisit;
    }

    public void setSessionsVisit(Integer sessionsVisit) {
        this.sessionsVisit = sessionsVisit;
    }

    public Double getSessionsPer() {
        return sessionsPer;
    }

    public void setSessionsPer(Double sessionsPer) {
        this.sessionsPer = sessionsPer;
    }

    public Integer getPageViews() {
        return pageViews;
    }

    public void setPageViews(Integer pageViews) {
        this.pageViews = pageViews;
    }

    public Double getBuyBoxPer() {
        return buyBoxPer;
    }

    public void setBuyBoxPer(Double buyBoxPer) {
        this.buyBoxPer = buyBoxPer;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getOrderB2B() {
        return orderB2B;
    }

    public void setOrderB2B(Integer orderB2B) {
        this.orderB2B = orderB2B;
    }

    public Double getSales() {
        return sales;
    }

    public void setSales(Double sales) {
        this.sales = sales;
    }

    public Double getSalesB2B() {
        return salesB2B;
    }

    public void setSalesB2B(Double salesB2B) {
        this.salesB2B = salesB2B;
    }

    public Integer getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Integer orderItems) {
        this.orderItems = orderItems;
    }

    public Integer getOrderItemsB2B() {
        return orderItemsB2B;
    }

    public void setOrderItemsB2B(Integer orderItemsB2B) {
        this.orderItemsB2B = orderItemsB2B;
    }
}

package com.dt.project.model.salesAmazon;

import com.dt.project.model.parent.ParentUploadInfo;

import java.math.BigDecimal;

/**
 * 业务报告导入数据
 */
public class SalesAmazonFbaBusinessreport extends ParentUploadInfo {

    private Long busId;
    private String fAsin;
    private String sAsin;
    private String pName;
    private Integer sessionsVisit;
    private BigDecimal sessionsPer;
    private Integer pageViews;
    private BigDecimal buyBoxPer;
    private Integer order;
    private Integer orderB2B;
    private BigDecimal sales;
    private BigDecimal salesB2B;
    private Integer orderItems;
    private Integer orderItemsB2B;
    private String busSku;

    public SalesAmazonFbaBusinessreport() {

    }

    public SalesAmazonFbaBusinessreport(Integer shopId, Integer siteId, Long createDate,  String createUser, Long recordingId) {
        super(shopId, siteId, createDate, createUser, recordingId);
    }

    public BigDecimal getSessionsPer() {
        return sessionsPer;
    }

    public void setSessionsPer(BigDecimal sessionsPer) {
        this.sessionsPer = sessionsPer;
    }

    public BigDecimal getBuyBoxPer() {
        return buyBoxPer;
    }

    public void setBuyBoxPer(BigDecimal buyBoxPer) {
        this.buyBoxPer = buyBoxPer;
    }

    public String getBusSku() {
        return busSku;
    }

    public void setBusSku(String busSku) {
        this.busSku = busSku;
    }

    public Long getBusId() {
        return busId;
    }

    public void setBusId(Long busId) {
        this.busId = busId;
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

    public Integer getPageViews() {
        return pageViews;
    }

    public void setPageViews(Integer pageViews) {
        this.pageViews = pageViews;
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

    public BigDecimal getSales() {
        return sales;
    }

    public void setSales(BigDecimal sales) {
        this.sales = sales;
    }

    public BigDecimal getSalesB2B() {
        return salesB2B;
    }

    public void setSalesB2B(BigDecimal salesB2B) {
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

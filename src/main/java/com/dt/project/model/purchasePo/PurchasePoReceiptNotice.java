package com.dt.project.model.purchasePo;

import com.dt.project.model.parent.ParentDocument;
import com.dt.project.model.parent.ParentSysTemLog;

import java.util.List;

/**
 * 收货通知单表
 */
public class PurchasePoReceiptNotice extends ParentDocument {


    private Long rnId;

    private String explanation;

    private String fetchAdd;

    private Integer closed;

    private Integer orderConfirm;

    public Long getRnId() {
        return rnId;
    }

    public void setRnId(Long rnId) {
        this.rnId = rnId;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getFetchAdd() {
        return fetchAdd;
    }

    public void setFetchAdd(String fetchAdd) {
        this.fetchAdd = fetchAdd;
    }

    public Integer getClosed() {
        return closed;
    }

    public void setClosed(Integer closed) {
        this.closed = closed;
    }

    public Integer getOrderConfirm() {
        return orderConfirm;
    }

    public void setOrderConfirm(Integer orderConfirm) {
        this.orderConfirm = orderConfirm;
    }
}
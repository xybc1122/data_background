package com.dt.project.model.warehouse;

import com.dt.project.model.parent.ParentDocument;
/**
 * 到货确认
 */
public class WarehouseIncArriveConfirm extends ParentDocument {
    private Long acId;


    private String explanation;


    private Integer closed;

    private String closeUser;

    private Long closeDate;

    private Integer orderConfirm;

    public Long getAcId() {
        return acId;
    }

    public void setAcId(Long acId) {
        this.acId = acId;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public Integer getClosed() {
        return closed;
    }

    public void setClosed(Integer closed) {
        this.closed = closed;
    }

    public String getCloseUser() {
        return closeUser;
    }

    public void setCloseUser(String closeUser) {
        this.closeUser = closeUser;
    }

    public Long getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Long closeDate) {
        this.closeDate = closeDate;
    }

    public Integer getOrderConfirm() {
        return orderConfirm;
    }

    public void setOrderConfirm(Integer orderConfirm) {
        this.orderConfirm = orderConfirm;
    }
}
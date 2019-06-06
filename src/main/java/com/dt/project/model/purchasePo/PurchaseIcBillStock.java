package com.dt.project.model.purchasePo;

import com.dt.project.customize.SelValue;
import com.dt.project.model.parent.ParentDocument;
import com.dt.project.model.parent.ParentSysTemLog;

import java.util.List;

/**
 * 入库接口
 */
public class PurchaseIcBillStock extends ParentDocument {


    @SelValue(column = "sb_id",property = "sbId")
    private Long sbId;
    /**
     * 入库No
     */
    @SelValue(column = "no",property = "icNo")
    private String icNo;
    @SelValue(column = "years",property = "years")
    private Integer years;
    @SelValue(column = "period",property = "period")
    private Integer period;
    @SelValue(column = "explanation",property = "explanation")
    private String explanation;
    @SelValue(column = "closed",property = "closed")
    private Integer closed;
    @SelValue(column = "order_confirm",property = "orderConfirm")
    private Integer orderConfirm;



    public String getIcNo() {
        return icNo;
    }

    public void setIcNo(String icNo) {
        this.icNo = icNo;
    }

    public Long getSbId() {
        return sbId;
    }

    public void setSbId(Long sbId) {
        this.sbId = sbId;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
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

    public Integer getOrderConfirm() {
        return orderConfirm;
    }

    public void setOrderConfirm(Integer orderConfirm) {
        this.orderConfirm = orderConfirm;
    }
}
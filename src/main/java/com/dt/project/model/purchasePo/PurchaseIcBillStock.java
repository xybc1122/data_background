package com.dt.project.model.purchasePo;

import com.dt.project.model.parent.ParentDocument;
import com.dt.project.model.parent.ParentSysTemLog;

import java.util.List;

/**
 * 入库接口
 */
public class PurchaseIcBillStock extends ParentDocument {
    private Long sbId;

    private Integer years;

    private Integer period;

    private String explanation;

    private Integer closed;

    private Integer orderConfirm;

    private Integer printCount;

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

    public Integer getPrintCount() {
        return printCount;
    }

    public void setPrintCount(Integer printCount) {
        this.printCount = printCount;
    }
}
package com.dt.user.model.BasePublicModel;

import com.dt.user.model.ParentSysTemLog;

import java.math.BigDecimal;

/**
 * 汇率表
 */
public class BasicPublicExchangeRate extends ParentSysTemLog {

    private Integer exchangeRateId;
    private Integer currencyId;
    private BigDecimal toRmb;
    private BigDecimal toUsd;


    //汇率名称
    private String currencyName;

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public Integer getExchangeRateId() {
        return exchangeRateId;
    }

    public void setExchangeRateId(Integer exchangeRateId) {
        this.exchangeRateId = exchangeRateId;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public BigDecimal getToRmb() {
        return toRmb;
    }

    public void setToRmb(BigDecimal toRmb) {
        this.toRmb = toRmb;
    }

    public BigDecimal getToUsd() {
        return toUsd;
    }

    public void setToUsd(BigDecimal toUsd) {
        this.toUsd = toUsd;
    }
}

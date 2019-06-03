package com.dt.project.model.basePublic;

import com.dt.project.model.parent.ParentSysTemLog;

import java.math.BigDecimal;

/**
 * 汇率表
 */
public class BasicPublicExchangeRate extends ParentSysTemLog {

    private Integer exchangeRateId;
    private Integer currencyId;
    private BigDecimal toRmb;
    private BigDecimal toUsd;
    /**
     * 有效日期
     */
    private Long eDate;

    public Long geteDate() {
        return eDate;
    }

    public void seteDate(Long eDate) {
        this.eDate = eDate;
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

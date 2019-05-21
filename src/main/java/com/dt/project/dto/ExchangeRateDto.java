package com.dt.project.dto;

import com.dt.project.model.BasePublicModel.BasicPublicExchangeRate;

import java.util.List;

public class ExchangeRateDto extends BasicPublicExchangeRate {


    /**
     * 币别名称
     */
    private String currencyName;
    /**
     * 币别符号
     */
    private String currencySymbol;

    private List<Long> eDates;

    public List<Long> geteDates() {
        return eDates;
    }

    public void seteDates(List<Long> eDates) {
        this.eDates = eDates;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

}


package com.dt.project.dto;

import com.dt.project.model.BasePublicModel.BasicPublicExchangeRate;

public class ExchangeRateDto extends BasicPublicExchangeRate {


    /**
     * 币别名称
     */
    private String currencyName;


    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

}


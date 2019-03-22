package com.dt.user.model.BasePublicModel;


import com.dt.user.model.ParentSysTemLog;

/**
 * 附加税税率
 */
public class BasicPublicVatSurTaxrate extends ParentSysTemLog {

    private Integer taxrateId;
    private Integer countryId;
    private Double taxRate;
    private String countryName;
    private Integer taxType;

    public Integer getTaxType() {
        return taxType;
    }

    public void setTaxType(Integer taxType) {
        this.taxType = taxType;
    }

    public Integer getTaxrateId() {
        return taxrateId;
    }

    public void setTaxrateId(Integer taxrateId) {
        this.taxrateId = taxrateId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}

package com.dt.project.model.BasePublicModel;


import com.dt.project.model.Parent.ParentSysTemLog;

/**
 * 附加税税率
 */
public class BasicPublicVatTaxrate extends ParentSysTemLog {

    private Integer taxrateId;
    private Integer countryId;
    private Integer companyId;
    private Double taxRate;
    /**
     * 公司名
     */
    private String companyName;
    /**
     * 国家名
     */
    private String countryName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
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
}

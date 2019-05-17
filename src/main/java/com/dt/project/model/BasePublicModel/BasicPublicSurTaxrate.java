package com.dt.project.model.BasePublicModel;

import com.dt.project.model.Parent.ParentSysTemLog;

import java.math.BigDecimal;

/**
 * 附加税
 */
public class BasicPublicSurTaxrate extends ParentSysTemLog {


    private Integer taxrateId;

    private Integer countryId;

    private Integer productsId;

    private Integer allCateIs;

    private BigDecimal taxRate;

    /**
     * 国家名
     */
    private String countryName;
    /**
     * 产品类目名
     */
    private String productsName;

    public String getProductsName() {
        return productsName;
    }

    public void setProductsName(String productsName) {
        this.productsName = productsName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
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

    public Integer getProductsId() {
        return productsId;
    }

    public void setProductsId(Integer productsId) {
        this.productsId = productsId;
    }

    public Integer getAllCateIs() {
        return allCateIs;
    }

    public void setAllCateIs(Integer allCateIs) {
        this.allCateIs = allCateIs;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }
}
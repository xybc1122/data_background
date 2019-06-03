package com.dt.project.model.basePublic;

import com.dt.project.model.parent.ParentSysTemLog;

/**
 * 关税税率
 */
public class BasicPublicDutiesTaxrate extends ParentSysTemLog {

  private Integer dutiesTaxrateId;
  private Integer countryId;
  private Integer productsId;
  private Double taxRate;

  public Integer getDutiesTaxrateId() {
    return dutiesTaxrateId;
  }

  public void setDutiesTaxrateId(Integer dutiesTaxrateId) {
    this.dutiesTaxrateId = dutiesTaxrateId;
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

  public Double getTaxRate() {
    return taxRate;
  }

  public void setTaxRate(Double taxRate) {
    this.taxRate = taxRate;
  }
}

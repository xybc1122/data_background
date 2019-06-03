package com.dt.project.model.basePublic;

import com.dt.project.model.parent.ParentSysTemLog;

/**
 * 省 洲
 */
public class BasicPublicProvince extends ParentSysTemLog {

  private Integer provinceId;
  private Integer number;
  private String provinceName;
  private String provinceNameEng;
  private String countryName;

  public Integer getProvinceId() {
    return provinceId;
  }

  public void setProvinceId(Integer provinceId) {
    this.provinceId = provinceId;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public String getProvinceName() {
    return provinceName;
  }

  public void setProvinceName(String provinceName) {
    this.provinceName = provinceName;
  }

  public String getProvinceNameEng() {
    return provinceNameEng;
  }

  public void setProvinceNameEng(String provinceNameEng) {
    this.provinceNameEng = provinceNameEng;
  }

  public String getCountryName() {
    return countryName;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }
}

package com.dt.project.model.basePublicModel;

import com.dt.project.model.parent.ParentSysTemLog;

/**
 * 平台类型
 */
public class BasicPublicPlatformType extends ParentSysTemLog {

  private Integer platformTypeId;
  private Integer number;
  private String platformTypeName;
  private String platformTypeNameEng;
  private String countryName;

  public Integer getPlatformTypeId() {
    return platformTypeId;
  }

  public void setPlatformTypeId(Integer platformTypeId) {
    this.platformTypeId = platformTypeId;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public String getPlatformTypeName() {
    return platformTypeName;
  }

  public void setPlatformTypeName(String platformTypeName) {
    this.platformTypeName = platformTypeName;
  }

  public String getPlatformTypeNameEng() {
    return platformTypeNameEng;
  }

  public void setPlatformTypeNameEng(String platformTypeNameEng) {
    this.platformTypeNameEng = platformTypeNameEng;
  }

  public String getCountryName() {
    return countryName;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }
}

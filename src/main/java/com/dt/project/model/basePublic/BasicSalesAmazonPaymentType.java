package com.dt.project.model.basePublic;

import com.dt.project.model.parent.ParentSysTemLog;

/**
 * 付款类型
 */
public class BasicSalesAmazonPaymentType extends ParentSysTemLog {

  private Integer paymentTypeId;
  private Integer number;
  private String paymentTypeName;
  private String paymentTypeNameEng;

  public Integer getPaymentTypeId() {
    return paymentTypeId;
  }

  public void setPaymentTypeId(Integer paymentTypeId) {
    this.paymentTypeId = paymentTypeId;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public String getPaymentTypeName() {
    return paymentTypeName;
  }

  public void setPaymentTypeName(String paymentTypeName) {
    this.paymentTypeName = paymentTypeName;
  }

  public String getPaymentTypeNameEng() {
    return paymentTypeNameEng;
  }

  public void setPaymentTypeNameEng(String paymentTypeNameEng) {
    this.paymentTypeNameEng = paymentTypeNameEng;
  }
}

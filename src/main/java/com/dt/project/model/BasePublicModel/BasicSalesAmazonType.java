package com.dt.project.model.BasePublicModel;

import com.dt.project.model.Parent.ParentSysTemLog;

/**
 * 订单类型
 */
public class BasicSalesAmazonType extends ParentSysTemLog {

  private Integer orderTypeId;
  private String orderTypeName;
  private Integer siteId;
  private String orderType;
  private String siteName;

  public String getSiteName() {
    return siteName;
  }

  public void setSiteName(String siteName) {
    this.siteName = siteName;
  }

  public Integer getOrderTypeId() {
    return orderTypeId;
  }

  public void setOrderTypeId(Integer orderTypeId) {
    this.orderTypeId = orderTypeId;
  }

  public String getOrderTypeName() {
    return orderTypeName;
  }

  public void setOrderTypeName(String orderTypeName) {
    this.orderTypeName = orderTypeName;
  }

  public Integer getSiteId() {
    return siteId;
  }

  public void setSiteId(Integer siteId) {
    this.siteId = siteId;
  }

  public String getOrderType() {
    return orderType;
  }

  public void setOrderType(String orderType) {
    this.orderType = orderType;
  }
}

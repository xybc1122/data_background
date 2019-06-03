package com.dt.project.model.basePublic;
import com.dt.project.model.parent.ParentSysTemLog;

/**
 * 运输性质
 */
public class BasicLogisticsmgtTransportProperty extends ParentSysTemLog {

  private Integer transportPropertyId;
  private Integer number;
  private String transportPropertyName;

  public Integer getTransportPropertyId() {
    return transportPropertyId;
  }

  public void setTransportPropertyId(Integer transportPropertyId) {
    this.transportPropertyId = transportPropertyId;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public String getTransportPropertyName() {
    return transportPropertyName;
  }

  public void setTransportPropertyName(String transportPropertyName) {
    this.transportPropertyName = transportPropertyName;
  }

}

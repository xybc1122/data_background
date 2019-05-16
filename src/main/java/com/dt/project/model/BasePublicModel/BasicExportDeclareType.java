package com.dt.project.model.BasePublicModel;


import com.dt.project.model.Parent.ParentSysTemLog;

/**
 * 报关类型
 */
public class BasicExportDeclareType extends ParentSysTemLog {

  private Integer declareTypeId;
  private Integer number;
  private String declareTypeName;


  public Integer getDeclareTypeId() {
    return declareTypeId;
  }

  public void setDeclareTypeId(Integer declareTypeId) {
    this.declareTypeId = declareTypeId;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public String getDeclareTypeName() {
    return declareTypeName;
  }

  public void setDeclareTypeName(String declareTypeName) {
    this.declareTypeName = declareTypeName;
  }
}

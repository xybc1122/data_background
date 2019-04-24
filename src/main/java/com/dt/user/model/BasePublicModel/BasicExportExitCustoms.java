package com.dt.user.model.BasePublicModel;


import com.dt.user.model.Parent.ParentSysTemLog;

/**
 * 出境口岸(出口关别)
 */
public class BasicExportExitCustoms extends ParentSysTemLog {

  private Integer exitCustomsId;
  private String cNumber;
  private String exitCustomsName;
  private String exitCustomsNamePinyin;

  public Integer getExitCustomsId() {
    return exitCustomsId;
  }

  public void setExitCustomsId(Integer exitCustomsId) {
    this.exitCustomsId = exitCustomsId;
  }

  public String getcNumber() {
    return cNumber;
  }

  public void setcNumber(String cNumber) {
    this.cNumber = cNumber;
  }

  public String getExitCustomsName() {
    return exitCustomsName;
  }

  public void setExitCustomsName(String exitCustomsName) {
    this.exitCustomsName = exitCustomsName;
  }

  public String getExitCustomsNamePinyin() {
    return exitCustomsNamePinyin;
  }

  public void setExitCustomsNamePinyin(String exitCustomsNamePinyin) {
    this.exitCustomsNamePinyin = exitCustomsNamePinyin;
  }
}

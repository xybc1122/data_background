package com.dt.project.model.basePublic;


import com.dt.project.model.parent.ParentSysTemLog;

/**
 * 雇佣类型
 */
public class BasicHrEmploymentType extends ParentSysTemLog {

  private Integer employmentTypeId;
  private Integer number;
  private String employmentTypeName;

  public Integer getEmploymentTypeId() {
    return employmentTypeId;
  }

  public void setEmploymentTypeId(Integer employmentTypeId) {
    this.employmentTypeId = employmentTypeId;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public String getEmploymentTypeName() {
    return employmentTypeName;
  }

  public void setEmploymentTypeName(String employmentTypeName) {
    this.employmentTypeName = employmentTypeName;
  }
}

package com.dt.user.model.BasePublicModel;


import com.dt.user.model.ParentSysTemLog;

/**
 * 员工类型
 */
public class BasicHrEmployeeType extends ParentSysTemLog {

  private Integer employeeTypeId;
  private Integer number;
  private String employeeTypeName;

  public Integer getEmployeeTypeId() {
    return employeeTypeId;
  }

  public void setEmployeeTypeId(Integer employeeTypeId) {
    this.employeeTypeId = employeeTypeId;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public String getEmployeeTypeName() {
    return employeeTypeName;
  }

  public void setEmployeeTypeName(String employeeTypeName) {
    this.employeeTypeName = employeeTypeName;
  }
}

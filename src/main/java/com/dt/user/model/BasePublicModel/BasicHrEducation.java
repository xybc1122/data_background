package com.dt.user.model.BasePublicModel;


import com.dt.user.model.ParentSysTemLog;

/**
 * 学历
 */
public class BasicHrEducation extends ParentSysTemLog {

  private Integer educationId;
  private Integer number;
  private String educationName;
  private String educationNameEng;

  public Integer getEducationId() {
    return educationId;
  }

  public void setEducationId(Integer educationId) {
    this.educationId = educationId;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public String getEducationName() {
    return educationName;
  }

  public void setEducationName(String educationName) {
    this.educationName = educationName;
  }

  public String getEducationNameEng() {
    return educationNameEng;
  }

  public void setEducationNameEng(String educationNameEng) {
    this.educationNameEng = educationNameEng;
  }
}

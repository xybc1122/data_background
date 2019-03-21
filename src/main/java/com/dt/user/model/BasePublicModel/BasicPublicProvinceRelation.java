package com.dt.user.model.BasePublicModel;


public class BasicPublicProvinceRelation {

  private long provinceRelationId;
  private long provinceRelationNumber;
  private String provinceRelationName;
  private long provinceId;
  private String remark;
  private String status;
  private long createDate;
  private long createIdUser;
  private long modifyDate;
  private long modifyIdUser;
  private long auditDate;
  private long auditIdUser;


  public long getProvinceRelationId() {
    return provinceRelationId;
  }

  public void setProvinceRelationId(long provinceRelationId) {
    this.provinceRelationId = provinceRelationId;
  }


  public long getProvinceRelationNumber() {
    return provinceRelationNumber;
  }

  public void setProvinceRelationNumber(long provinceRelationNumber) {
    this.provinceRelationNumber = provinceRelationNumber;
  }


  public String getProvinceRelationName() {
    return provinceRelationName;
  }

  public void setProvinceRelationName(String provinceRelationName) {
    this.provinceRelationName = provinceRelationName;
  }


  public long getProvinceId() {
    return provinceId;
  }

  public void setProvinceId(long provinceId) {
    this.provinceId = provinceId;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public long getCreateDate() {
    return createDate;
  }

  public void setCreateDate(long createDate) {
    this.createDate = createDate;
  }


  public long getCreateIdUser() {
    return createIdUser;
  }

  public void setCreateIdUser(long createIdUser) {
    this.createIdUser = createIdUser;
  }


  public long getModifyDate() {
    return modifyDate;
  }

  public void setModifyDate(long modifyDate) {
    this.modifyDate = modifyDate;
  }


  public long getModifyIdUser() {
    return modifyIdUser;
  }

  public void setModifyIdUser(long modifyIdUser) {
    this.modifyIdUser = modifyIdUser;
  }


  public long getAuditDate() {
    return auditDate;
  }

  public void setAuditDate(long auditDate) {
    this.auditDate = auditDate;
  }


  public long getAuditIdUser() {
    return auditIdUser;
  }

  public void setAuditIdUser(long auditIdUser) {
    this.auditIdUser = auditIdUser;
  }

}

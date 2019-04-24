package com.dt.user.model.HrArchives;

import com.dt.user.model.Parent.ParentSysTemLog;

import java.io.Serializable;

/**
 * 员工表
 */
public class HrArchivesEmployee extends ParentSysTemLog implements Serializable {

    /**
     * 员工ID
     */
    private Integer sId;
    /**
     * 员工编号
     */
    private Integer number;
    /**
     * 员工姓名
     */
    private String employeeName;
    /**
     * 员工姓名拼音
     */
    private String employeeNamePinyin;
    /**
     * 员工英文名
     */
    private String employeeNameEng;
    /**
     * 性别(0男；1女)
     */
    private Integer sex;
    /**
     * 身份证号
     */
    private String idCard;
    /**
     * 员工手机
     */
    private Long mobilePhone;
    /**
     * 员工状态(1在职；0离职)
     */
    private Boolean isInService;


    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeNamePinyin() {
        return employeeNamePinyin;
    }

    public void setEmployeeNamePinyin(String employeeNamePinyin) {
        this.employeeNamePinyin = employeeNamePinyin;
    }

    public String getEmployeeNameEng() {
        return employeeNameEng;
    }

    public void setEmployeeNameEng(String employeeNameEng) {
        this.employeeNameEng = employeeNameEng;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Long getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(Long mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Boolean getInService() {
        return isInService;
    }

    public void setInService(Boolean inService) {
        isInService = inService;
    }
}

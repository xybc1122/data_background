package com.dt.project.model.basePublic;

import com.dt.project.model.parent.ParentSysTemLog;

/**
 * 供应商
 */
public class BasicPurchaseSupplier extends ParentSysTemLog {
    private Integer supplierId;

    private Integer supplierNumber;

    private String supplierFullName;

    private String supplierFullNameEng;

    private String suppliersupplierShortCode;

    private String supplierShortName;

    private String supplierShortNameEng;

    private String creditCode;

    private String bankOfDeposit;

    private String bankAccount;

    private String accountType;

    private String address;

    private String addressEng;
    /**
     * 联系人
     */
    private String contactPerson;


    private String telPhone;

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getSupplierNumber() {
        return supplierNumber;
    }

    public void setSupplierNumber(Integer supplierNumber) {
        this.supplierNumber = supplierNumber;
    }

    public String getSupplierFullName() {
        return supplierFullName;
    }

    public void setSupplierFullName(String supplierFullName) {
        this.supplierFullName = supplierFullName;
    }

    public String getSupplierFullNameEng() {
        return supplierFullNameEng;
    }

    public void setSupplierFullNameEng(String supplierFullNameEng) {
        this.supplierFullNameEng = supplierFullNameEng;
    }

    public String getSuppliersupplierShortCode() {
        return suppliersupplierShortCode;
    }

    public void setSuppliersupplierShortCode(String suppliersupplierShortCode) {
        this.suppliersupplierShortCode = suppliersupplierShortCode;
    }

    public String getSupplierShortName() {
        return supplierShortName;
    }

    public void setSupplierShortName(String supplierShortName) {
        this.supplierShortName = supplierShortName;
    }

    public String getSupplierShortNameEng() {
        return supplierShortNameEng;
    }

    public void setSupplierShortNameEng(String supplierShortNameEng) {
        this.supplierShortNameEng = supplierShortNameEng;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getBankOfDeposit() {
        return bankOfDeposit;
    }

    public void setBankOfDeposit(String bankOfDeposit) {
        this.bankOfDeposit = bankOfDeposit;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressEng() {
        return addressEng;
    }

    public void setAddressEng(String addressEng) {
        this.addressEng = addressEng;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }
}
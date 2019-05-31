package com.dt.project.model.salesAmazon;

public class BasicPurchaseSupplier {
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

    private String telPhone;

    private Long statusId;

    private Long recordingId;

    private Integer version;

    private Boolean delOrNot;

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
        this.supplierFullName = supplierFullName == null ? null : supplierFullName.trim();
    }

    public String getSupplierFullNameEng() {
        return supplierFullNameEng;
    }

    public void setSupplierFullNameEng(String supplierFullNameEng) {
        this.supplierFullNameEng = supplierFullNameEng == null ? null : supplierFullNameEng.trim();
    }

    public String getSuppliersupplierShortCode() {
        return suppliersupplierShortCode;
    }

    public void setSuppliersupplierShortCode(String suppliersupplierShortCode) {
        this.suppliersupplierShortCode = suppliersupplierShortCode == null ? null : suppliersupplierShortCode.trim();
    }

    public String getSupplierShortName() {
        return supplierShortName;
    }

    public void setSupplierShortName(String supplierShortName) {
        this.supplierShortName = supplierShortName == null ? null : supplierShortName.trim();
    }

    public String getSupplierShortNameEng() {
        return supplierShortNameEng;
    }

    public void setSupplierShortNameEng(String supplierShortNameEng) {
        this.supplierShortNameEng = supplierShortNameEng == null ? null : supplierShortNameEng.trim();
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode == null ? null : creditCode.trim();
    }

    public String getBankOfDeposit() {
        return bankOfDeposit;
    }

    public void setBankOfDeposit(String bankOfDeposit) {
        this.bankOfDeposit = bankOfDeposit == null ? null : bankOfDeposit.trim();
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType == null ? null : accountType.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getAddressEng() {
        return addressEng;
    }

    public void setAddressEng(String addressEng) {
        this.addressEng = addressEng == null ? null : addressEng.trim();
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone == null ? null : telPhone.trim();
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public Long getRecordingId() {
        return recordingId;
    }

    public void setRecordingId(Long recordingId) {
        this.recordingId = recordingId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean getDelOrNot() {
        return delOrNot;
    }

    public void setDelOrNot(Boolean delOrNot) {
        this.delOrNot = delOrNot;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", supplierId=").append(supplierId);
        sb.append(", supplierNumber=").append(supplierNumber);
        sb.append(", supplierFullName=").append(supplierFullName);
        sb.append(", supplierFullNameEng=").append(supplierFullNameEng);
        sb.append(", suppliersupplierShortCode=").append(suppliersupplierShortCode);
        sb.append(", supplierShortName=").append(supplierShortName);
        sb.append(", supplierShortNameEng=").append(supplierShortNameEng);
        sb.append(", creditCode=").append(creditCode);
        sb.append(", bankOfDeposit=").append(bankOfDeposit);
        sb.append(", bankAccount=").append(bankAccount);
        sb.append(", accountType=").append(accountType);
        sb.append(", address=").append(address);
        sb.append(", addressEng=").append(addressEng);
        sb.append(", telPhone=").append(telPhone);
        sb.append(", statusId=").append(statusId);
        sb.append(", recordingId=").append(recordingId);
        sb.append(", version=").append(version);
        sb.append(", delOrNot=").append(delOrNot);
        sb.append("]");
        return sb.toString();
    }
}
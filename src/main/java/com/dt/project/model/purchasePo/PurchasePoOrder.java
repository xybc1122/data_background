package com.dt.project.model.purchasePo;

import com.dt.project.model.parent.ParentSysTemLog;

import java.math.BigDecimal;
import java.util.List;

/**
 * 采购订单表
 */
public class PurchasePoOrder extends ParentSysTemLog {
    private Long poId;

    private Long date;

    private Integer poStyleId;

    private String explanation;

    private String fetchAdd;

    private Integer currencyId;

    private Integer deptId;

    private Integer empId;

    private Integer mangerId;

    private BigDecimal exchangeRate;

    private Boolean children;

    private Integer closed;

    private Integer supplierId;

    private String contactPerson;

    private String telPhone;

    private Long prePayId;

    private BigDecimal prePayAmt;

    private Integer classTypeId;

    private Long settlementDate;

    private Integer settlementMethodId;

    private Long payId;

    private BigDecimal poAmt;

    private BigDecimal inboundAmt;

    private Integer companyId;

    private Integer invoiceTypeId;

    private String no;

    private BigDecimal payAmt;

    private BigDecimal eraseAmt;

    private Integer tranType;

    private Integer tranStatus;

    private Integer orderConfirm;

//    private Long sourceTypeId;
//
//    private Long sourceId;

    private Integer printCount;
    /**
     * 币别名称
     */
    private String currencyName;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 业务员名称
     */
    private String empName;
    /**
     * 主管名称
     */
    private String mangerName;
    /**
     * 供应商名称
     */
    private String supplierFullName;
    /**
     * 预付单号
     */
    private String perPayNo;
    /**
     * 发票抬头 （公司名称）
     */
    private String companyName;
    /**
     * 结算方式Name
     */
    private String name;

    /**
     * 发票类型
     */
    private String typeName;


    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPerPayNo() {
        return perPayNo;
    }

    public void setPerPayNo(String perPayNo) {
        this.perPayNo = perPayNo;
    }

    public String getSupplierFullName() {
        return supplierFullName;
    }

    public void setSupplierFullName(String supplierFullName) {
        this.supplierFullName = supplierFullName;
    }

    public Long getPrePayId() {
        return prePayId;
    }

    public void setPrePayId(Long prePayId) {
        this.prePayId = prePayId;
    }

    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getMangerName() {
        return mangerName;
    }

    public void setMangerName(String mangerName) {
        this.mangerName = mangerName;
    }

    public Long getPoId() {
        return poId;
    }

    public void setPoId(Long poId) {
        this.poId = poId;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }


    public Integer getPoStyleId() {
        return poStyleId;
    }

    public void setPoStyleId(Integer poStyleId) {
        this.poStyleId = poStyleId;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation == null ? null : explanation.trim();
    }

    public String getFetchAdd() {
        return fetchAdd;
    }

    public void setFetchAdd(String fetchAdd) {
        this.fetchAdd = fetchAdd == null ? null : fetchAdd.trim();
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getMangerId() {
        return mangerId;
    }

    public void setMangerId(Integer mangerId) {
        this.mangerId = mangerId;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Boolean getChildren() {
        return children;
    }

    public void setChildren(Boolean children) {
        this.children = children;
    }

    public Integer getClosed() {
        return closed;
    }

    public void setClosed(Integer closed) {
        this.closed = closed;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson == null ? null : contactPerson.trim();
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone == null ? null : telPhone.trim();
    }


    public BigDecimal getPrePayAmt() {
        return prePayAmt;
    }

    public void setPrePayAmt(BigDecimal prePayAmt) {
        this.prePayAmt = prePayAmt;
    }

    public Integer getClassTypeId() {
        return classTypeId;
    }

    public void setClassTypeId(Integer classTypeId) {
        this.classTypeId = classTypeId;
    }

    public Long getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Long settlementDate) {
        this.settlementDate = settlementDate;
    }

    public Integer getSettlementMethodId() {
        return settlementMethodId;
    }

    public void setSettlementMethodId(Integer settlementMethodId) {
        this.settlementMethodId = settlementMethodId;
    }

    public BigDecimal getPoAmt() {
        return poAmt;
    }

    public void setPoAmt(BigDecimal poAmt) {
        this.poAmt = poAmt;
    }

    public BigDecimal getInboundAmt() {
        return inboundAmt;
    }

    public void setInboundAmt(BigDecimal inboundAmt) {
        this.inboundAmt = inboundAmt;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getInvoiceTypeId() {
        return invoiceTypeId;
    }

    public void setInvoiceTypeId(Integer invoiceTypeId) {
        this.invoiceTypeId = invoiceTypeId;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public BigDecimal getPayAmt() {
        return payAmt;
    }

    public void setPayAmt(BigDecimal payAmt) {
        this.payAmt = payAmt;
    }

    public BigDecimal getEraseAmt() {
        return eraseAmt;
    }

    public void setEraseAmt(BigDecimal eraseAmt) {
        this.eraseAmt = eraseAmt;
    }

    public Integer getTranType() {
        return tranType;
    }

    public void setTranType(Integer tranType) {
        this.tranType = tranType;
    }

    public Integer getTranStatus() {
        return tranStatus;
    }

    public void setTranStatus(Integer tranStatus) {
        this.tranStatus = tranStatus;
    }

    public Integer getOrderConfirm() {
        return orderConfirm;
    }

    public void setOrderConfirm(Integer orderConfirm) {
        this.orderConfirm = orderConfirm;
    }
//
//    public Long getSourceTypeId() {
//        return sourceTypeId;
//    }
//
//    public void setSourceTypeId(Long sourceTypeId) {
//        this.sourceTypeId = sourceTypeId;
//    }
//
//    public Long getSourceId() {
//        return sourceId;
//    }
//
//    public void setSourceId(Long sourceId) {
//        this.sourceId = sourceId;
//    }

    public Integer getPrintCount() {
        return printCount;
    }

    public void setPrintCount(Integer printCount) {
        this.printCount = printCount;
    }

}
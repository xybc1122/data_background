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

    private String poNo;

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

    private String prePayNo;

    private BigDecimal prePayAmt;

    private Integer classTypeId;

    private Long settlementDate;

    private Integer settlementMethodId;

    private BigDecimal poAmt;

    private BigDecimal inboundAmt;

    private Integer invoiceCompanyId;

    private Integer invoiceTypeId;

    private String payNo;

    private BigDecimal payAmt;

    private BigDecimal eraseAmt;

    private Integer tranType;

    private Integer tranStatus;

    private Float totalCostFor;

    private Integer orderConfirm;

    private Long sourceTypeId;

    private Long sourceId;

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
     * 一对多 接收对象  查询
     */
    private PurchasePoOrderEntry poOrderEntry;
    /**
     * 一对多对象存储
     */
    private List<PurchasePoOrderEntry> poOrderEntryList;

    public PurchasePoOrderEntry getPoOrderEntry() {
        return poOrderEntry;
    }

    public void setPoOrderEntry(PurchasePoOrderEntry poOrderEntry) {
        this.poOrderEntry = poOrderEntry;
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

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo == null ? null : poNo.trim();
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

    public String getPrePayNo() {
        return prePayNo;
    }

    public void setPrePayNo(String prePayNo) {
        this.prePayNo = prePayNo == null ? null : prePayNo.trim();
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

    public Integer getInvoiceCompanyId() {
        return invoiceCompanyId;
    }

    public void setInvoiceCompanyId(Integer invoiceCompanyId) {
        this.invoiceCompanyId = invoiceCompanyId;
    }

    public Integer getInvoiceTypeId() {
        return invoiceTypeId;
    }

    public void setInvoiceTypeId(Integer invoiceTypeId) {
        this.invoiceTypeId = invoiceTypeId;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo == null ? null : payNo.trim();
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

    public Float getTotalCostFor() {
        return totalCostFor;
    }

    public void setTotalCostFor(Float totalCostFor) {
        this.totalCostFor = totalCostFor;
    }

    public Integer getOrderConfirm() {
        return orderConfirm;
    }

    public void setOrderConfirm(Integer orderConfirm) {
        this.orderConfirm = orderConfirm;
    }

    public Long getSourceTypeId() {
        return sourceTypeId;
    }

    public void setSourceTypeId(Long sourceTypeId) {
        this.sourceTypeId = sourceTypeId;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getPrintCount() {
        return printCount;
    }

    public void setPrintCount(Integer printCount) {
        this.printCount = printCount;
    }

    public List<PurchasePoOrderEntry> getPoOrderEntryList() {
        return poOrderEntryList;
    }

    public void setPoOrderEntryList(List<PurchasePoOrderEntry> poOrderEntryList) {
        this.poOrderEntryList = poOrderEntryList;
    }
}
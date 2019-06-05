package com.dt.project.model.purchasePo;

import com.dt.project.model.parent.ParentDocument;
import com.dt.project.model.parent.ParentSysTemLog;

import java.math.BigDecimal;
import java.util.List;

/**
 * 采购订单表
 */
public class PurchasePoOrder extends ParentDocument {
    private Long poId;


    private Integer poStyleId;

    private String explanation;

    private String fetchAdd;

    private Integer currencyId;

    private BigDecimal exchangeRate;

    private Integer closed;

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


    private BigDecimal payAmt;

    private BigDecimal eraseAmt;

    private Integer tranType;

    private Integer tranStatus;

    private Integer orderConfirm;


    /**
     * 币别名称
     */
    private String currencyName;

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

    public Long getPoId() {
        return poId;
    }

    public void setPoId(Long poId) {
        this.poId = poId;
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
        this.explanation = explanation;
    }

    public String getFetchAdd() {
        return fetchAdd;
    }

    public void setFetchAdd(String fetchAdd) {
        this.fetchAdd = fetchAdd;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Integer getClosed() {
        return closed;
    }

    public void setClosed(Integer closed) {
        this.closed = closed;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public Long getPrePayId() {
        return prePayId;
    }

    public void setPrePayId(Long prePayId) {
        this.prePayId = prePayId;
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

    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
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

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getPerPayNo() {
        return perPayNo;
    }

    public void setPerPayNo(String perPayNo) {
        this.perPayNo = perPayNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
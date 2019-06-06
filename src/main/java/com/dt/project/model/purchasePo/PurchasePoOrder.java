package com.dt.project.model.purchasePo;

import com.dt.project.customize.SelValue;
import com.dt.project.model.parent.ParentDocument;
import com.dt.project.model.parent.ParentSysTemLog;

import java.math.BigDecimal;
import java.util.List;

/**
 * 采购订单表
 */
public class PurchasePoOrder extends ParentDocument {

    /**
     * 订单号
     */
    @SelValue(column = "no",property = "poNo")
    private String poNo;

    @SelValue(column = "po_id",property = "poId")
    private Long poId;


    @SelValue(column = "po_style_id",property = "poStyleId")
    private Integer poStyleId;

    @SelValue(column = "explanation",property = "explanation")
    private String explanation;
    @SelValue(column = "fetch_add",property = "fetchAdd")
    private String fetchAdd;
    @SelValue(column = "currency_id",property = "currencyId")
    private Integer currencyId;
    @SelValue(column = "exchange_rate",property = "exchangeRate")
    private BigDecimal exchangeRate;
    @SelValue(column = "closed",property = "closed")
    private Integer closed;
    @SelValue(column = "contact_person",property = "contactPerson")
    private String contactPerson;
    @SelValue(column = "tel_phone",property = "telPhone")
    private String telPhone;
    @SelValue(column = "pre_pay_id",property = "prePayId")
    private Long prePayId;
    @SelValue(column = "pre_pay_amt",property = "prePayAmt")
    private BigDecimal prePayAmt;
    @SelValue(column = "class_type_id",property = "classTypeId")
    private Integer classTypeId;
    @SelValue(column = "settlement_date",property = "settlementDate")
    private Long settlementDate;
    @SelValue(column = "settlement_method_id",property = "settlementMethodId")
    private Integer settlementMethodId;
    @SelValue(column = "pay_id",property = "payId")
    private Long payId;
    @SelValue(column = "po_amt",property = "poAmt")
    private BigDecimal poAmt;
    @SelValue(column = "inbound_amt",property = "inboundAmt")
    private BigDecimal inboundAmt;
    @SelValue(column = "company_id",property = "companyId")
    private Integer companyId;
    @SelValue(column = "invoice_type_id",property = "invoiceTypeId")
    private Integer invoiceTypeId;

    @SelValue(column = "pay_amt",property = "payAmt")
    private BigDecimal payAmt;
    @SelValue(column = "erase_amt",property = "eraseAmt")
    private BigDecimal eraseAmt;
    @SelValue(column = "tran_type",property = "tranType")
    private Integer tranType;
    @SelValue(column = "tran_status",property = "tranStatus")
    private Integer tranStatus;
    @SelValue(column = "order_confirm",property = "orderConfirm")
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

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

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
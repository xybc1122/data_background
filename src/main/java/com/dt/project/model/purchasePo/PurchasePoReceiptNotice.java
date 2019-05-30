package com.dt.project.model.purchasePo;

import com.dt.project.model.parent.ParentSysTemLog;

import java.util.List;

/**
 * 收货通知单表
 */
public class PurchasePoReceiptNotice extends ParentSysTemLog {
    private Long rnId;

    private Long date;

    private String rnNo;

    private String explanation;

    private String fetchAdd;

    private Integer deptId;

    private Integer empId;

    private Integer mangerId;

    private Boolean children;

    private Integer closed;

    private Integer orderConfirm;

    private Long sourceTypeId;

    private Long sourceId;

    private Integer printCount;
    /**
     * 一对多查询存储
     */
    private List<PurchasePoReceiptNoticeEntry> poReceiptNoticeEntryList;
    /**
     * 接收对象
     */
    private PurchasePoReceiptNoticeEntry purchasePoReceiptNoticeEntry;

    public List<PurchasePoReceiptNoticeEntry> getPoReceiptNoticeEntryList() {
        return poReceiptNoticeEntryList;
    }

    public void setPoReceiptNoticeEntryList(List<PurchasePoReceiptNoticeEntry> poReceiptNoticeEntryList) {
        this.poReceiptNoticeEntryList = poReceiptNoticeEntryList;
    }

    public PurchasePoReceiptNoticeEntry getPurchasePoReceiptNoticeEntry() {
        return purchasePoReceiptNoticeEntry;
    }

    public void setPurchasePoReceiptNoticeEntry(PurchasePoReceiptNoticeEntry purchasePoReceiptNoticeEntry) {
        this.purchasePoReceiptNoticeEntry = purchasePoReceiptNoticeEntry;
    }

    public Long getRnId() {
        return rnId;
    }

    public void setRnId(Long rnId) {
        this.rnId = rnId;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getRnNo() {
        return rnNo;
    }

    public void setRnNo(String rnNo) {
        this.rnNo = rnNo == null ? null : rnNo.trim();
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
}
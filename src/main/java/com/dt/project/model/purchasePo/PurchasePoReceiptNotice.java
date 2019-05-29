package com.dt.project.model.purchasePo;

public class PurchasePoReceiptNotice {
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

    private Long statusId;

    private Integer version;

    private Boolean delOrNot;

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

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
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
        sb.append(", rnId=").append(rnId);
        sb.append(", date=").append(date);
        sb.append(", rnNo=").append(rnNo);
        sb.append(", explanation=").append(explanation);
        sb.append(", fetchAdd=").append(fetchAdd);
        sb.append(", deptId=").append(deptId);
        sb.append(", empId=").append(empId);
        sb.append(", mangerId=").append(mangerId);
        sb.append(", children=").append(children);
        sb.append(", closed=").append(closed);
        sb.append(", orderConfirm=").append(orderConfirm);
        sb.append(", sourceTypeId=").append(sourceTypeId);
        sb.append(", sourceId=").append(sourceId);
        sb.append(", printCount=").append(printCount);
        sb.append(", statusId=").append(statusId);
        sb.append(", version=").append(version);
        sb.append(", delOrNot=").append(delOrNot);
        sb.append("]");
        return sb.toString();
    }
}
package com.dt.project.model.parent;

/**
 * 单据表父类
 */
public class ParentDocument extends ParentSysTemLog {
    /**
     * 单据时间
     */
    private Long date;

    /**
     * 供应商ID
     */
    private Integer supplierId;

    /**
     * 部门ID
     */
    private Integer deptId;
    /**
     * 业务员ID
     */
    private Integer empId;
    /**
     * 主管ID
     */
    private Integer mangerId;

    private Long sourceTypeId;

    private Long sourceId;

    private Boolean children;

    private Integer printCount;
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

    public Boolean getChildren() {
        return children;
    }

    public void setChildren(Boolean children) {
        this.children = children;
    }

    public Integer getPrintCount() {
        return printCount;
    }

    public void setPrintCount(Integer printCount) {
        this.printCount = printCount;
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


    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierFullName() {
        return supplierFullName;
    }

    public void setSupplierFullName(String supplierFullName) {
        this.supplierFullName = supplierFullName;
    }
}

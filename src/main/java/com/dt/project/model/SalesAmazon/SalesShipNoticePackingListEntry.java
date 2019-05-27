package com.dt.project.model.salesAmazon;

import com.dt.project.model.JavaSqlName;

import java.math.BigDecimal;
import java.util.List;

/**
 * 装箱单-表体
 */
public class SalesShipNoticePackingListEntry {
    private Long peId;

    private Long packingListId;

    private Long eid;

    private Integer entryId;

    private Integer quantity;

    private Integer packagesBeg;

    private Integer packagesEnd;

    private BigDecimal lengthCm;

    private BigDecimal widthCm;

    private BigDecimal heightCm;

    private BigDecimal gwKg;

    private BigDecimal nwKg;

    private BigDecimal volumeM3;

    private String remark;

    private Integer version;

    private Boolean delOrNot;

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 显示的页数
     */
    private Integer pageSize;

    /**
     * 前端查询参数封装对象
     */
    private List<JavaSqlName> nameList;

    public List<JavaSqlName> getNameList() {
        return nameList;
    }

    public void setNameList(List<JavaSqlName> nameList) {
        this.nameList = nameList;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getPeId() {
        return peId;
    }

    public void setPeId(Long peId) {
        this.peId = peId;
    }

    public Long getPackingListId() {
        return packingListId;
    }

    public void setPackingListId(Long packingListId) {
        this.packingListId = packingListId;
    }

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public Integer getEntryId() {
        return entryId;
    }

    public void setEntryId(Integer entryId) {
        this.entryId = entryId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPackagesBeg() {
        return packagesBeg;
    }

    public void setPackagesBeg(Integer packagesBeg) {
        this.packagesBeg = packagesBeg;
    }

    public Integer getPackagesEnd() {
        return packagesEnd;
    }

    public void setPackagesEnd(Integer packagesEnd) {
        this.packagesEnd = packagesEnd;
    }

    public BigDecimal getLengthCm() {
        return lengthCm;
    }

    public void setLengthCm(BigDecimal lengthCm) {
        this.lengthCm = lengthCm;
    }

    public BigDecimal getWidthCm() {
        return widthCm;
    }

    public void setWidthCm(BigDecimal widthCm) {
        this.widthCm = widthCm;
    }

    public BigDecimal getHeightCm() {
        return heightCm;
    }

    public void setHeightCm(BigDecimal heightCm) {
        this.heightCm = heightCm;
    }

    public BigDecimal getGwKg() {
        return gwKg;
    }

    public void setGwKg(BigDecimal gwKg) {
        this.gwKg = gwKg;
    }

    public BigDecimal getNwKg() {
        return nwKg;
    }

    public void setNwKg(BigDecimal nwKg) {
        this.nwKg = nwKg;
    }

    public BigDecimal getVolumeM3() {
        return volumeM3;
    }

    public void setVolumeM3(BigDecimal volumeM3) {
        this.volumeM3 = volumeM3;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
}
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

    private BigDecimal plLengthCm;

    private BigDecimal plWidthCm;

    private BigDecimal plHeightCm;

    private BigDecimal plGwKg;

    private BigDecimal plNwKg;

    private BigDecimal plVolumeM3;

    private String plRemark;

    private Integer version;

    private Boolean delOrNot;
    /**
     * in查询存储id
     */
    private List<Long> inShipNoticeList;
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


    public List<Long> getInShipNoticeList() {
        return inShipNoticeList;
    }

    public void setInShipNoticeList(List<Long> inShipNoticeList) {
        this.inShipNoticeList = inShipNoticeList;
    }

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


    public Boolean getDelOrNot() {
        return delOrNot;
    }

    public void setDelOrNot(Boolean delOrNot) {
        this.delOrNot = delOrNot;
    }

    public BigDecimal getPlLengthCm() {
        return plLengthCm;
    }

    public void setPlLengthCm(BigDecimal plLengthCm) {
        this.plLengthCm = plLengthCm;
    }

    public BigDecimal getPlWidthCm() {
        return plWidthCm;
    }

    public void setPlWidthCm(BigDecimal plWidthCm) {
        this.plWidthCm = plWidthCm;
    }

    public BigDecimal getPlHeightCm() {
        return plHeightCm;
    }

    public void setPlHeightCm(BigDecimal plHeightCm) {
        this.plHeightCm = plHeightCm;
    }

    public BigDecimal getPlGwKg() {
        return plGwKg;
    }

    public void setPlGwKg(BigDecimal plGwKg) {
        this.plGwKg = plGwKg;
    }

    public BigDecimal getPlNwKg() {
        return plNwKg;
    }

    public void setPlNwKg(BigDecimal plNwKg) {
        this.plNwKg = plNwKg;
    }

    public BigDecimal getPlVolumeM3() {
        return plVolumeM3;
    }

    public void setPlVolumeM3(BigDecimal plVolumeM3) {
        this.plVolumeM3 = plVolumeM3;
    }

    public String getPlRemark() {
        return plRemark;
    }

    public void setPlRemark(String plRemark) {
        this.plRemark = plRemark;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
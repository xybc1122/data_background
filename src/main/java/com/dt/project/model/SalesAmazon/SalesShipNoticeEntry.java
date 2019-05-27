package com.dt.project.model.salesAmazon;

import com.dt.project.model.JavaSqlName;

import java.math.BigDecimal;
import java.util.List;

/**
 * 发货通知单表体
 */

public class SalesShipNoticeEntry {
    private Long eid;

    private Integer entryId;

    private Long shipNoticeId;
    /**
     * in查询存储id
     */
    private List<Long> inShipNoticeList;


    private Long skuId;

    private Integer quantity;

    private String packages;

    private BigDecimal neLengthCm;

    private Double neWidthCm;

    private Double neHeightCm;

    private Double neGwKg;

    private Double neNwKg;

    private Double neVolumeM3;

    private Boolean packingStatus;

    private Integer seQuantity;

    private Integer reQuantity;

    private Long reDate;

    private String neRemark;

    private Integer status;

    private Long closeDate;

    private String closeUser;

    private Integer version;
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

    public List<Long> getInShipNoticeList() {
        return inShipNoticeList;
    }

    public void setInShipNoticeList(List<Long> inShipNoticeList) {
        this.inShipNoticeList = inShipNoticeList;
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

    public Long getShipNoticeId() {
        return shipNoticeId;
    }

    public void setShipNoticeId(Long shipNoticeId) {
        this.shipNoticeId = shipNoticeId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages == null ? null : packages.trim();
    }

    public BigDecimal getNeLengthCm() {
        return neLengthCm;
    }

    public void setNeLengthCm(BigDecimal neLengthCm) {
        this.neLengthCm = neLengthCm;
    }

    public Double getNeWidthCm() {
        return neWidthCm;
    }

    public void setNeWidthCm(Double neWidthCm) {
        this.neWidthCm = neWidthCm;
    }

    public Double getNeHeightCm() {
        return neHeightCm;
    }

    public void setNeHeightCm(Double neHeightCm) {
        this.neHeightCm = neHeightCm;
    }

    public Double getNeGwKg() {
        return neGwKg;
    }

    public void setNeGwKg(Double neGwKg) {
        this.neGwKg = neGwKg;
    }

    public Double getNeNwKg() {
        return neNwKg;
    }

    public void setNeNwKg(Double neNwKg) {
        this.neNwKg = neNwKg;
    }

    public Double getNeVolumeM3() {
        return neVolumeM3;
    }

    public void setNeVolumeM3(Double neVolumeM3) {
        this.neVolumeM3 = neVolumeM3;
    }

    public Boolean getPackingStatus() {
        return packingStatus;
    }

    public void setPackingStatus(Boolean packingStatus) {
        this.packingStatus = packingStatus;
    }

    public Integer getSeQuantity() {
        return seQuantity;
    }

    public void setSeQuantity(Integer seQuantity) {
        this.seQuantity = seQuantity;
    }

    public Integer getReQuantity() {
        return reQuantity;
    }

    public void setReQuantity(Integer reQuantity) {
        this.reQuantity = reQuantity;
    }

    public Long getReDate() {
        return reDate;
    }

    public void setReDate(Long reDate) {
        this.reDate = reDate;
    }

    public String getNeRemark() {
        return neRemark;
    }

    public void setNeRemark(String neRemark) {
        this.neRemark = neRemark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Long closeDate) {
        this.closeDate = closeDate;
    }

    public String getCloseUser() {
        return closeUser;
    }

    public void setCloseUser(String closeUser) {
        this.closeUser = closeUser == null ? null : closeUser.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public SalesShipNoticeEntry() {

    }


}
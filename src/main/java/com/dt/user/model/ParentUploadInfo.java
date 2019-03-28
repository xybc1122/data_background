package com.dt.user.model;

import java.util.List;

/**
 * @ClassName ParentUploadInfo
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/26 16:33
 **/
public class ParentUploadInfo {

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 显示的页数
     */
    private Integer pageSize;

    /**
     * 站点名称
     */
    private String siteName;
    /**
     * 店铺名称
     */
    private String shopName;
    private Long skuId;
    /**
     * sku
     */
    private String sku;
    private Integer shopId;
    private Integer siteId;
    private Long date;
    //记录表ID
    private Long recordingId;
    private String remark;
    private Integer status;
    private Long createDate;
    private String createUser;
    private Long modifyDate;
    private String modifyUser;
    private Long auditDate;
    private String auditUser;


    /**
     * 创建时间范围查询变量
     */
    private List<Long> createDates;

    /**
     * 修改日期范围查询变量
     */
    private List<Long> modifyDates;

    /**
     * 审核时间范围查询变量
     */
    private List<Long> auditDates;

    /**
     * 有效如期范围查询
     */
    private List<Long> effectiveDates;
    /**
     * 文件表已有时间
     */
    private List<Long> dates;

    public ParentUploadInfo() {

    }

    public ParentUploadInfo(Integer shopId, Integer siteId, Long createDate, String createUser, Long recordingId) {
        this.createDate = createDate;
        this.createUser = createUser;
        this.recordingId = recordingId;
        this.shopId = shopId;
        this.siteId = siteId;

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

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getRecordingId() {
        return recordingId;
    }

    public void setRecordingId(Long recordingId) {
        this.recordingId = recordingId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Long getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Long modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Long getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Long auditDate) {
        this.auditDate = auditDate;
    }

    public String getAuditUser() {
        return auditUser;
    }

    public void setAuditUser(String auditUser) {
        this.auditUser = auditUser;
    }

    public List<Long> getCreateDates() {
        return createDates;
    }

    public void setCreateDates(List<Long> createDates) {
        this.createDates = createDates;
    }

    public List<Long> getModifyDates() {
        return modifyDates;
    }

    public void setModifyDates(List<Long> modifyDates) {
        this.modifyDates = modifyDates;
    }

    public List<Long> getAuditDates() {
        return auditDates;
    }

    public void setAuditDates(List<Long> auditDates) {
        this.auditDates = auditDates;
    }

    public List<Long> getEffectiveDates() {
        return effectiveDates;
    }

    public void setEffectiveDates(List<Long> effectiveDates) {
        this.effectiveDates = effectiveDates;
    }

    public List<Long> getDates() {
        return dates;
    }

    public void setDates(List<Long> dates) {
        this.dates = dates;
    }
}

package com.dt.user.model.Parent;

import com.dt.user.model.JavaSqlName;

import java.util.List;

/**
 * 上传文件父类
 *
 * @ClassName ParentUploadInfo
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/26 16:33
 **/
public class ParentUploadInfo {
    /**
     * 通过这个判断查询周数据表 还是普通数据表  1是代表查询周表
     */
    private Integer sqlMode;

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
     * 角色ids
     */
    private String rid;
    /**
     * 前端查询封装对象
     */
    private List<JavaSqlName> nameList;


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
     * 文件表已有时间
     */
    private List<Long> dates;

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public ParentUploadInfo() {

    }

    public ParentUploadInfo(Integer shopId, Integer siteId, Long createDate, String createUser, Long recordingId) {
        this.createDate = createDate;
        this.createUser = createUser;
        this.recordingId = recordingId;
        this.shopId = shopId;
        this.siteId = siteId;

    }

    public List<JavaSqlName> getNameList() {
        return nameList;
    }

    public void setNameList(List<JavaSqlName> nameList) {
        this.nameList = nameList;
    }

    public Integer getSqlMode() {
        return sqlMode;
    }

    public void setSqlMode(Integer sqlMode) {
        this.sqlMode = sqlMode;
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

    public List<Long> getDates() {
        return dates;
    }

    public void setDates(List<Long> dates) {
        this.dates = dates;
    }
}

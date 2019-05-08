package com.dt.user.model;

import java.util.List;

public class UserUpload {


    public UserUpload() {

    }

    public UserUpload(Long id, Long uid) {
        this.id = id;
        this.uid = uid;
    }

    /**
     * 存入记录信息集合数据
     */
    private List<UserUpload> uploadSuccessList;
    /**
     * 关账时间
     */
    private String closingDate;
    private Long id;
    private Long uid;
    /**
     * 上传文件名称
     */
    private String name;
    private Long createDate;
    private Long delDate;
    private Long delDateId;
    /**
     * 上传服务器路径
     */
    private String filePath;

    /**
     * 写入服务器路径
     */
    private String writeFilePath;
    /**
     * 上传备注
     */
    private String remark;
    private String uuidName;
    /**
     * 上传状态0代表成功,1代表失败,2代表上传成功后 有些没有skuId的没上传
     */
    private Integer status;
    /**
     * 店铺ID
     */
    private Integer shopId;
    /**
     * 站点ID
     */
    private Integer siteId;

    /**
     * payId 结算类型
     */
    private Integer payId;

    /**
     * tbId 通过这ID获取是哪一个菜单的上传
     */
    private Integer mid;

    /**
     * 洲ID
     */
    private Integer areaId;
    /**
     * 业务报告时间
     */
    private String businessTime;
    /**
     * 财务结算类型
     */
    private String paymentTypeName;
    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 显示的页数
     */
    private Integer pageSize;
    private List<Long> createDates;
    private List<Long> delDates;

    public String getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(String closingDate) {
        this.closingDate = closingDate;
    }

    public List<Long> getCreateDates() {
        return createDates;
    }

    public void setCreateDates(List<Long> createDates) {
        this.createDates = createDates;
    }

    public List<Long> getDelDates() {
        return delDates;
    }

    public void setDelDates(List<Long> delDates) {
        this.delDates = delDates;
    }

    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
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

    public String getUuidName() {
        return uuidName;
    }

    public void setUuidName(String uuidName) {
        this.uuidName = uuidName;
    }

    public String getBusinessTime() {
        return businessTime;
    }

    public void setBusinessTime(String businessTime) {
        this.businessTime = businessTime;
    }

    public List<UserUpload> getUploadSuccessList() {
        return uploadSuccessList;
    }

    public void setUploadSuccessList(List<UserUpload> uploadSuccessList) {
        this.uploadSuccessList = uploadSuccessList;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Long getDelDate() {
        return delDate;
    }

    public void setDelDate(Long delDate) {
        this.delDate = delDate;
    }

    public Long getDelDateId() {
        return delDateId;
    }

    public void setDelDateId(Long delDateId) {
        this.delDateId = delDateId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getWriteFilePath() {
        return writeFilePath;
    }

    public void setWriteFilePath(String writeFilePath) {
        this.writeFilePath = writeFilePath;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
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
}

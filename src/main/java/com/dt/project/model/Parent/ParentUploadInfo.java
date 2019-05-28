package com.dt.project.model.parent;

import com.dt.project.model.JavaSqlName;

import java.util.List;

/**
 * 上传文件父类
 *
 * @ClassName ParentUploadInfo
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/26 16:33
 **/
public class ParentUploadInfo extends ParentConfTable {
    /**
     * 通过这个判断查询周数据表 还是普通数据表  1是代表查询周表
     */
    private Integer sqlMode;


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
    /**
     * 角色ids
     */
    private String rid;

    /**
     * 前端查询参数封装对象
     */
    private List<JavaSqlName> nameList;


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
        super(createDate, createUser);
        this.recordingId = recordingId;
        this.shopId = shopId;
        this.siteId = siteId;

    }

    public Integer getSqlMode() {
        return sqlMode;
    }

    public void setSqlMode(Integer sqlMode) {
        this.sqlMode = sqlMode;
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

    public List<JavaSqlName> getNameList() {
        return nameList;
    }

    public void setNameList(List<JavaSqlName> nameList) {
        this.nameList = nameList;
    }

    public List<Long> getDates() {
        return dates;
    }

    public void setDates(List<Long> dates) {
        this.dates = dates;
    }
}

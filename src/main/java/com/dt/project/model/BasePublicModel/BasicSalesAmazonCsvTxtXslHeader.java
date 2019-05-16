package com.dt.project.model.BasePublicModel;


import com.dt.project.model.Parent.ParentSysTemLog;

public class BasicSalesAmazonCsvTxtXslHeader extends ParentSysTemLog {
    /**
     * 站点ID
     */
    private Long siteId;
    /**
     * 对应表头字段
     */
    private String importTemplet;
    /**
     * 位置标识
     */
    private Integer position;
    /**
     * 标识ID
     */
    private Long id;

    private Integer isImport;
    /**
     * 菜单ID
     */
    private Integer menuId;
    /**
     * 开或者关
     */
    private Boolean openClose;
    /**
     * 菜单名称
     */
    private String mName;
    /**
     * 店铺名称
     */
    private String shopName;
    /**
     * 站点名称
     */
    private String siteName;
    /**
     * 排序
     */
    private Integer sort;


    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public Boolean getOpenClose() {
        return openClose;
    }

    public void setOpenClose(Boolean openClose) {
        this.openClose = openClose;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public String getImportTemplet() {
        return importTemplet;
    }

    public void setImportTemplet(String importTemplet) {
        this.importTemplet = importTemplet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getIsImport() {
        return isImport;
    }

    public void setIsImport(Integer isImport) {
        this.isImport = isImport;
    }
}

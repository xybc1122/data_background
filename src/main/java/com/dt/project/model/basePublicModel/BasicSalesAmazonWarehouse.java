package com.dt.project.model.basePublicModel;


import com.dt.project.model.parent.ParentSysTemLog;

/**
 * 亚马逊仓库
 */
public class BasicSalesAmazonWarehouse extends ParentSysTemLog {

    private Integer amazonWarehouseId;
    private Integer number;
    private Integer siteId;
    private String warehouseCode;
    private String country;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String siteName;

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public Integer getAmazonWarehouseId() {
        return amazonWarehouseId;
    }

    public void setAmazonWarehouseId(Integer amazonWarehouseId) {
        this.amazonWarehouseId = amazonWarehouseId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}

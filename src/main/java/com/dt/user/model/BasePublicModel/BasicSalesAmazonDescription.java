package com.dt.user.model.BasePublicModel;

import com.dt.user.model.Parent.ParentSysTemLog;

/**
 * 亚马逊描述
 */
public class BasicSalesAmazonDescription extends ParentSysTemLog {

    private Integer orderDescriptionId;
    private String orderDescriptionName;
    private Integer siteId;
    private String oldOrderDescription;
    private String newOrderDescription;
    private String siteName;

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public Integer getOrderDescriptionId() {
        return orderDescriptionId;
    }

    public void setOrderDescriptionId(Integer orderDescriptionId) {
        this.orderDescriptionId = orderDescriptionId;
    }

    public String getOrderDescriptionName() {
        return orderDescriptionName;
    }

    public void setOrderDescriptionName(String orderDescriptionName) {
        this.orderDescriptionName = orderDescriptionName;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getOldOrderDescription() {
        return oldOrderDescription;
    }

    public void setOldOrderDescription(String oldOrderDescription) {
        this.oldOrderDescription = oldOrderDescription;
    }

    public String getNewOrderDescription() {
        return newOrderDescription;
    }

    public void setNewOrderDescription(String newOrderDescription) {
        this.newOrderDescription = newOrderDescription;
    }
}

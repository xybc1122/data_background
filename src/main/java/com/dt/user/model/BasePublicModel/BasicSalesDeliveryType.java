package com.dt.user.model.BasePublicModel;

import com.dt.user.model.ParentSysTemLog;

/**
 * 发货方式
 */
public class BasicSalesDeliveryType extends ParentSysTemLog {

    private Integer deliveryTypeId;
    private Integer number;
    private String deliveryTypeName;
    private String deliveryTypeEng;

    public Integer getDeliveryTypeId() {
        return deliveryTypeId;
    }

    public void setDeliveryTypeId(Integer deliveryTypeId) {
        this.deliveryTypeId = deliveryTypeId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDeliveryTypeName() {
        return deliveryTypeName;
    }

    public void setDeliveryTypeName(String deliveryTypeName) {
        this.deliveryTypeName = deliveryTypeName;
    }

    public String getDeliveryTypeEng() {
        return deliveryTypeEng;
    }

    public void setDeliveryTypeEng(String deliveryTypeEng) {
        this.deliveryTypeEng = deliveryTypeEng;
    }

}

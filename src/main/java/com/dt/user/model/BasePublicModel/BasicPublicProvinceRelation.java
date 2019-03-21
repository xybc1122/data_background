package com.dt.user.model.BasePublicModel;

import com.dt.user.model.ParentSysTemLog;

/**
 * 省洲关联表
 */
public class BasicPublicProvinceRelation extends ParentSysTemLog {

    private Integer provinceRelationId;
    private Integer number;
    private String provinceRelationName;
    private Integer provinceId;
    /**
     * 省洲名称
     */
    private String provinceName;

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Integer getProvinceRelationId() {
        return provinceRelationId;
    }

    public void setProvinceRelationId(Integer provinceRelationId) {
        this.provinceRelationId = provinceRelationId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getProvinceRelationName() {
        return provinceRelationName;
    }

    public void setProvinceRelationName(String provinceRelationName) {
        this.provinceRelationName = provinceRelationName;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }
}

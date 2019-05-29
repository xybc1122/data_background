package com.dt.project.model.basePublicModel;

import com.dt.project.model.parent.ParentSysTemLog;

/**
 * 区域表
 */
public class BasicPublicArea extends ParentSysTemLog {
    /**
     * 区域ID
     */
    private Integer areaId;
    /**
     * 区域编号
     */
    private Long number;
    /**
     * 区域名称
     */
    private String areaName;
    /**
     * 区域英文
     */
    private String areaNameEng;
    /**
     * 区域英文检称
     */
    private String areaShortNameEng;
    /**
     * 区域角色id
     */
    private Integer arId;

    /**
     * 站点id
     */
    private Integer siteId;
    /**
     * 站点 名称
     */
    private String siteName;
    /**
     * 如果有多个角色 配置多个不同的站点 需要拿这个去查询站点
     */
    private String arIds;

    public String getArIds() {
        return arIds;
    }

    public void setArIds(String arIds) {
        this.arIds = arIds;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public Integer getArId() {
        return arId;
    }

    public void setArId(Integer arId) {
        this.arId = arId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaNameEng() {
        return areaNameEng;
    }

    public void setAreaNameEng(String areaNameEng) {
        this.areaNameEng = areaNameEng;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getAreaShortNameEng() {
        return areaShortNameEng;
    }

    public void setAreaShortNameEng(String areaShortNameEng) {
        this.areaShortNameEng = areaShortNameEng;
    }
}

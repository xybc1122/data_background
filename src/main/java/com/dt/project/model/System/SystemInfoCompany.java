package com.dt.project.model.system;

import com.dt.project.model.parent.ParentSysTemLog;

/**
 * 保存公司信息
 */
public class SystemInfoCompany extends ParentSysTemLog {
    private Integer cid;

    private String companyName;

    private String systemName;

    private String logoUrl;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName == null ? null : systemName.trim();
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl == null ? null : logoUrl.trim();
    }


}
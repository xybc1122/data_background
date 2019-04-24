package com.dt.user.model.BasePublicModel;

import com.dt.user.model.Parent.ParentSysTemLog;

/**
 * 成交方式
 */
public class BasicExportWayOfClosing extends ParentSysTemLog {

    private Integer wayOfClosingId;
    private String cNumber;
    private String wayOfClosingName;
    private String wayOfClosingShortnameEng;
    private String wayOfClosingNameEng;

    public Integer getWayOfClosingId() {
        return wayOfClosingId;
    }

    public void setWayOfClosingId(Integer wayOfClosingId) {
        this.wayOfClosingId = wayOfClosingId;
    }

    public String getcNumber() {
        return cNumber;
    }

    public void setcNumber(String cNumber) {
        this.cNumber = cNumber;
    }

    public String getWayOfClosingName() {
        return wayOfClosingName;
    }

    public void setWayOfClosingName(String wayOfClosingName) {
        this.wayOfClosingName = wayOfClosingName;
    }

    public String getWayOfClosingShortnameEng() {
        return wayOfClosingShortnameEng;
    }

    public void setWayOfClosingShortnameEng(String wayOfClosingShortnameEng) {
        this.wayOfClosingShortnameEng = wayOfClosingShortnameEng;
    }

    public String getWayOfClosingNameEng() {
        return wayOfClosingNameEng;
    }

    public void setWayOfClosingNameEng(String wayOfClosingNameEng) {
        this.wayOfClosingNameEng = wayOfClosingNameEng;
    }
}

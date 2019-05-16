package com.dt.project.model.BasePublicModel;

import com.dt.project.model.Parent.ParentSysTemLog;

/**
 * 名族
 */
public class BasicHrNation extends ParentSysTemLog {

    private Integer nationId;
    private Integer number;
    private String nation;

    public Integer getNationId() {
        return nationId;
    }

    public void setNationId(Integer nationId) {
        this.nationId = nationId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
}

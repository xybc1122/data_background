package com.dt.user.model.BasePublicModel;

import com.dt.user.model.Parent.ParentSysTemLog;

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

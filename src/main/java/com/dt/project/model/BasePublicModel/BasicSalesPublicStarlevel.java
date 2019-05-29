package com.dt.project.model.basePublicModel;

import com.dt.project.model.parent.ParentSysTemLog;

/**
 * 星级
 */
public class BasicSalesPublicStarlevel extends ParentSysTemLog {

    private Integer starLevelId;
    private Integer number;
    private String starLevelName;


    public Integer getStarLevelId() {
        return starLevelId;
    }

    public void setStarLevelId(Integer starLevelId) {
        this.starLevelId = starLevelId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getStarLevelName() {
        return starLevelName;
    }

    public void setStarLevelName(String starLevelName) {
        this.starLevelName = starLevelName;
    }
}

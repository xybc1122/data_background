package com.dt.project.model.basePublic;

import com.dt.project.model.parent.ParentSysTemLog;

/**
 * 计价范围
 */
public class BasicLogisticsmgtTransportValuationRange extends ParentSysTemLog {

    private Integer transportValuationRangeId;
    private Integer number;
    private String transportValuationRangeName;
    /**
     * 计价方式名
     */
    private String transportValuationEethodName;

    public String getTransportValuationEethodName() {
        return transportValuationEethodName;
    }

    public void setTransportValuationEethodName(String transportValuationEethodName) {
        this.transportValuationEethodName = transportValuationEethodName;
    }

    public Integer getTransportValuationRangeId() {
        return transportValuationRangeId;
    }

    public void setTransportValuationRangeId(Integer transportValuationRangeId) {
        this.transportValuationRangeId = transportValuationRangeId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getTransportValuationRangeName() {
        return transportValuationRangeName;
    }

    public void setTransportValuationRangeName(String transportValuationRangeName) {
        this.transportValuationRangeName = transportValuationRangeName;
    }
}

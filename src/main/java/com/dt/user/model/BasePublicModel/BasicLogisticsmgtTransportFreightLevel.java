package com.dt.user.model.BasePublicModel;

import com.dt.user.model.ParentSysTemLog;

import java.util.List;

/**
 * 运价等级
 */
public class BasicLogisticsmgtTransportFreightLevel extends ParentSysTemLog {

    private Integer transportFreightLevelId;
    private Integer number;
    private String transportFreightLevelName;
    private Integer parentId;
    private String transportFreightLevelPath;
    private Boolean isParent;
    private List<BasicLogisticsmgtTransportFreightLevel> childNode;

    public List<BasicLogisticsmgtTransportFreightLevel> getChildNode() {
        return childNode;
    }

    public void setChildNode(List<BasicLogisticsmgtTransportFreightLevel> childNode) {
        this.childNode = childNode;
    }

    public Integer getTransportFreightLevelId() {
        return transportFreightLevelId;
    }

    public void setTransportFreightLevelId(Integer transportFreightLevelId) {
        this.transportFreightLevelId = transportFreightLevelId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getTransportFreightLevelName() {
        return transportFreightLevelName;
    }

    public void setTransportFreightLevelName(String transportFreightLevelName) {
        this.transportFreightLevelName = transportFreightLevelName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getTransportFreightLevelPath() {
        return transportFreightLevelPath;
    }

    public void setTransportFreightLevelPath(String transportFreightLevelPath) {
        this.transportFreightLevelPath = transportFreightLevelPath;
    }

    public Boolean getParent() {
        return isParent;
    }

    public void setParent(Boolean parent) {
        isParent = parent;
    }
}

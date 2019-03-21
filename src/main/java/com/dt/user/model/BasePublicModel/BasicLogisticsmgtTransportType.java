package com.dt.user.model.BasePublicModel;

import com.dt.user.model.ParentSysTemLog;

import java.util.List;

/**
 * 运输类型
 */
public class BasicLogisticsmgtTransportType extends ParentSysTemLog {

    private Integer transportTypeId;
    private Long number;
    private Integer parentId;
    private String transportTypeName;
    private String transportTypePath;
    private Boolean isParent;
    // 子目录
    private List<BasicLogisticsmgtTransportType> childNode;

    public List<BasicLogisticsmgtTransportType> getChildNode() {
        return childNode;
    }

    public void setChildNode(List<BasicLogisticsmgtTransportType> childNode) {
        this.childNode = childNode;
    }

    public Integer getTransportTypeId() {
        return transportTypeId;
    }

    public void setTransportTypeId(Integer transportTypeId) {
        this.transportTypeId = transportTypeId;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getTransportTypeName() {
        return transportTypeName;
    }

    public void setTransportTypeName(String transportTypeName) {
        this.transportTypeName = transportTypeName;
    }

    public String getTransportTypePath() {
        return transportTypePath;
    }

    public void setTransportTypePath(String transportTypePath) {
        this.transportTypePath = transportTypePath;
    }

    public Boolean getParent() {
        return isParent;
    }

    public void setParent(Boolean parent) {
        isParent = parent;
    }
}

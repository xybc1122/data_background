package com.dt.user.model.BasePublicModel;


import java.util.List;

/**
 * 异常类型
 */
public class BasicLogisticsmgtTransportAbnormalType {

    private Integer transportAbnormalTypeId;
    private Integer number;
    private String transportAbnormalTypeName;
    private Integer parentId;
    private String transportAbnormalTypePath;
    private Boolean isParent;
    private List<BasicLogisticsmgtTransportAbnormalType> childNode;

    public Integer getTransportAbnormalTypeId() {
        return transportAbnormalTypeId;
    }

    public void setTransportAbnormalTypeId(Integer transportAbnormalTypeId) {
        this.transportAbnormalTypeId = transportAbnormalTypeId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getTransportAbnormalTypeName() {
        return transportAbnormalTypeName;
    }

    public void setTransportAbnormalTypeName(String transportAbnormalTypeName) {
        this.transportAbnormalTypeName = transportAbnormalTypeName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getTransportAbnormalTypePath() {
        return transportAbnormalTypePath;
    }

    public void setTransportAbnormalTypePath(String transportAbnormalTypePath) {
        this.transportAbnormalTypePath = transportAbnormalTypePath;
    }

    public Boolean getParent() {
        return isParent;
    }

    public void setParent(Boolean parent) {
        isParent = parent;
    }

    public List<BasicLogisticsmgtTransportAbnormalType> getChildNode() {
        return childNode;
    }

    public void setChildNode(List<BasicLogisticsmgtTransportAbnormalType> childNode) {
        this.childNode = childNode;
    }
}

package com.dt.user.model.BasePublicModel;

import com.dt.user.model.ParentSysTemLog;

import java.util.List;

/**
 * 计价方式
 */
public class BasicLogisticsmgtTransportValuationMethod extends ParentSysTemLog {

    private Integer transportValuationMethodId;
    private Integer number;
    private String transportValuationMethodName;
    private Integer parentId;
    private String transportValuationMethodPath;
    private Boolean isParent;
    private List<BasicLogisticsmgtTransportValuationMethod> childNode;


    public List<BasicLogisticsmgtTransportValuationMethod> getChildNode() {
        return childNode;
    }

    public void setChildNode(List<BasicLogisticsmgtTransportValuationMethod> childNode) {
        this.childNode = childNode;
    }

    public Integer getTransportValuationMethodId() {
        return transportValuationMethodId;
    }

    public void setTransportValuationMethodId(Integer transportValuationMethodId) {
        this.transportValuationMethodId = transportValuationMethodId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getTransportValuationMethodName() {
        return transportValuationMethodName;
    }

    public void setTransportValuationMethodName(String transportValuationMethodName) {
        this.transportValuationMethodName = transportValuationMethodName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getTransportValuationMethodPath() {
        return transportValuationMethodPath;
    }

    public void setTransportValuationMethodPath(String transportValuationMethodPath) {
        this.transportValuationMethodPath = transportValuationMethodPath;
    }

    public Boolean getParent() {
        return isParent;
    }

    public void setParent(Boolean parent) {
        isParent = parent;
    }
}

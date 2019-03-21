package com.dt.user.model.BasePublicModel;


import com.dt.user.model.ParentSysTemLog;

/**
 * 订单处理类
 */
public class BasicSalesAmazonHandlingClass extends ParentSysTemLog {

    private Integer classId;
    private String className;
    private String size;
    private String region;
    private String codex;


    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCodex() {
        return codex;
    }

    public void setCodex(String codex) {
        this.codex = codex;
    }
}

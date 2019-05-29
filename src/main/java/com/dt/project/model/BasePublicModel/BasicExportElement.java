package com.dt.project.model.basePublicModel;


import com.dt.project.model.parent.ParentSysTemLog;

/**
 * 要素内容
 */
public class BasicExportElement extends ParentSysTemLog {

    private Integer elementId;
    private String elementName;
    private String elementNameEng;

    public Integer getElementId() {
        return elementId;
    }

    public void setElementId(Integer elementId) {
        this.elementId = elementId;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getElementNameEng() {
        return elementNameEng;
    }

    public void setElementNameEng(String elementNameEng) {
        this.elementNameEng = elementNameEng;
    }
}

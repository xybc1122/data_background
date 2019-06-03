package com.dt.project.model.basePublic;

import com.dt.project.model.parent.ParentSysTemLog;

/**
 * 出口管理-HS Code
 */
public class BasicExportHsCode extends ParentSysTemLog {

    private Integer hsCodeId;
    private String hsCode;
    private String productName;
    private String productNameEng;
    private Integer categories;
    private Integer chapter;

    public Integer getHsCodeId() {
        return hsCodeId;
    }

    public void setHsCodeId(Integer hsCodeId) {
        this.hsCodeId = hsCodeId;
    }

    public String getHsCode() {
        return hsCode;
    }

    public void setHsCode(String hsCode) {
        this.hsCode = hsCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductNameEng() {
        return productNameEng;
    }

    public void setProductNameEng(String productNameEng) {
        this.productNameEng = productNameEng;
    }

    public Integer getCategories() {
        return categories;
    }

    public void setCategories(Integer categories) {
        this.categories = categories;
    }

    public Integer getChapter() {
        return chapter;
    }

    public void setChapter(Integer chapter) {
        this.chapter = chapter;
    }
}

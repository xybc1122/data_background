package com.dt.project.model.BasePublicModel;

import com.dt.project.model.Parent.ParentSysTemLog;

/**
 * 国家表
 */
public class BasicPublicCountry  extends ParentSysTemLog {

    private Integer countryId;
    private Integer number;
    private String countryName;
    private String countryNameEng;
    private String countryShortNameEng;


    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryNameEng() {
        return countryNameEng;
    }

    public void setCountryNameEng(String countryNameEng) {
        this.countryNameEng = countryNameEng;
    }

    public String getCountryShortNameEng() {
        return countryShortNameEng;
    }

    public void setCountryShortNameEng(String countryShortNameEng) {
        this.countryShortNameEng = countryShortNameEng;
    }
}

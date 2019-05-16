package com.dt.project.model.BasePublicModel;


import com.dt.project.model.Parent.ParentSysTemLog;

public class BasicExportModeOfTransport extends ParentSysTemLog {

    private Integer modeOfTransportId;
    private String cNumber;
    private String modeOfTransportName;
    private String modeOfTransportNameEng;

    public Integer getModeOfTransportId() {
        return modeOfTransportId;
    }

    public void setModeOfTransportId(Integer modeOfTransportId) {
        this.modeOfTransportId = modeOfTransportId;
    }

    public String getcNumber() {
        return cNumber;
    }

    public void setcNumber(String cNumber) {
        this.cNumber = cNumber;
    }

    public String getModeOfTransportName() {
        return modeOfTransportName;
    }

    public void setModeOfTransportName(String modeOfTransportName) {
        this.modeOfTransportName = modeOfTransportName;
    }

    public String getModeOfTransportNameEng() {
        return modeOfTransportNameEng;
    }

    public void setModeOfTransportNameEng(String modeOfTransportNameEng) {
        this.modeOfTransportNameEng = modeOfTransportNameEng;
    }
}

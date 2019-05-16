package com.dt.project.oa.model;

import java.util.Date;

/**
 * @ClassName Auditor
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/16 9:03
 * 审核人类
 **/
public class Auditor {


    /**
     * 审核人
     */
    private String auditorName;
    /**
     * 结果
     */
    private String result;
    /**
     * 时间
     */
    private Date auditTime;

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }
}

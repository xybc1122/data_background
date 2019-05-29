package com.dt.project.oa.model;

import java.util.Date;
import java.util.Map;

/**
 * 接收task查询需要审核记录 对象类型
 *
 * @author Created by yawn on 2018-01-09 14:31
 */
public class MyTask {
    /**
     * 审批id
     */
    private String tid;
    /**
     * 审批 Name
     */
    private String tName;
    /**
     * 反馈流程对象
     */
    private Feedback feedback;
    /**
     * 审核人对象
     */
    private Auditor auditor;
    /**
     * 创建时间
     */
    private Date createTime;

    private Map<String, Object> variables;

    public Map<String, Object> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }

    public MyTask(String tid, String tName, Date createTime) {
        this.tid = tid;
        this.tName = tName;
        this.createTime = createTime;
    }

    public MyTask() {

    }

    public Auditor getAuditor() {
        return auditor;
    }

    public void setAuditor(Auditor auditor) {
        this.auditor = auditor;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

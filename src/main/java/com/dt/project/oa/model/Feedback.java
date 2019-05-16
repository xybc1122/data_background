package com.dt.project.oa.model;

import java.util.Date;

/**
 * @ClassName Feedback
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/15 15:26
 * 反馈信息流程申请表
 **/
public class Feedback {


    /**
     * 申请人
     */
    private String applyUser;
    /**
     * 申请时间
     */
    private Date applyTime;
    /**
     * 上传图片url
     */
    private String imageUrl;
    /**
     * 原因
     */
    private String reason;
    /**
     * 菜单id
     */
    private String mName;
    /**
     * 反馈uuid 编号
     */
    private String uuidNumber;
    /**
     * 审核状态
     */
    private String ApplyStatus;




    public String getApplyStatus() {
        return ApplyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        ApplyStatus = applyStatus;
    }

    public String getUuidNumber() {
        return uuidNumber;
    }

    public void setUuidNumber(String uuidNumber) {
        this.uuidNumber = uuidNumber;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }
}

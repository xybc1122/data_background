package com.dt.user.model.SalesAmazon;


import com.dt.user.model.ParentUploadInfo;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单处理费
 */
public class SalesAmazonFbaHandlingFee extends ParentUploadInfo {

    private Long hdId;
    private BigDecimal stdFbaHdFee;
    private Long effectiveDate;
    /**
     * 有效如期范围查询
     */
    private List<Long> effectiveDates;

    public SalesAmazonFbaHandlingFee() {
    }


    public SalesAmazonFbaHandlingFee(Long createDate, String createUser, Long recordingId) {
        super(null, null, createDate, createUser, recordingId);
    }

    public Long getHdId() {
        return hdId;
    }

    public void setHdId(Long hdId) {
        this.hdId = hdId;
    }

    public BigDecimal getStdFbaHdFee() {
        return stdFbaHdFee;
    }

    public void setStdFbaHdFee(BigDecimal stdFbaHdFee) {
        this.stdFbaHdFee = stdFbaHdFee;
    }

    public Long getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Long effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public List<Long> getEffectiveDates() {
        return effectiveDates;
    }

    public void setEffectiveDates(List<Long> effectiveDates) {
        this.effectiveDates = effectiveDates;
    }
}

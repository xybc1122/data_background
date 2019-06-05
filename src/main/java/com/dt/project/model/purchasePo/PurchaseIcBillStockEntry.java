package com.dt.project.model.purchasePo;


import com.dt.project.model.parent.ParentDocumentChild;


/**
 * 外购入库单表体
 */
public class PurchaseIcBillStockEntry extends ParentDocumentChild {
    private Long sbeId;

    private Long sbId;

    private Long rneId;

    public Long getSbeId() {
        return sbeId;
    }

    public void setSbeId(Long sbeId) {
        this.sbeId = sbeId;
    }

    public Long getSbId() {
        return sbId;
    }

    public void setSbId(Long sbId) {
        this.sbId = sbId;
    }

    public Long getRneId() {
        return rneId;
    }

    public void setRneId(Long rneId) {
        this.rneId = rneId;
    }


}
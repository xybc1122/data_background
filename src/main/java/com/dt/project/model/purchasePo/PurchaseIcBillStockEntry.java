package com.dt.project.model.purchasePo;


import com.dt.project.customize.SelValue;
import com.dt.project.model.parent.ParentDocumentChild;


/**
 * 外购入库单表体
 */
public class PurchaseIcBillStockEntry extends ParentDocumentChild {

    @SelValue(column = "sbe_id", property = "sbeId")
    private Long sbeId;
    @SelValue(column = "sb_id", property = "sbId")
    private Long sbId;
    @SelValue(column = "rne_id", property = "rneId")
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
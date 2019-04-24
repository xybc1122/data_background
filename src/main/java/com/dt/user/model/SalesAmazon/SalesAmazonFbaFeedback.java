package com.dt.user.model.SalesAmazon;

import com.dt.user.model.Parent.ParentUploadInfo;

/**
 * Feedback
 */
public class SalesAmazonFbaFeedback extends ParentUploadInfo {
    private Long feeId;

    private Integer add;

    private Integer move;

    public Long getFeeId() {
        return feeId;
    }

    public void setFeeId(Long feeId) {
        this.feeId = feeId;
    }



    public Integer getAdd() {
        return add;
    }

    public void setAdd(Integer add) {
        this.add = add;
    }

    public Integer getMove() {
        return move;
    }

    public void setMove(Integer move) {
        this.move = move;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", feeID=").append(feeId);
        sb.append(", add=").append(add);
        sb.append(", move=").append(move);
        sb.append("]");
        return sb.toString();
    }
}
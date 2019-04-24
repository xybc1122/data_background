package com.dt.user.model.SalesAmazon;

import com.dt.user.model.Parent.ParentUploadInfo;

/**
 * review
 */
public class SalesAmazonFbaReview extends ParentUploadInfo {
    private Long reId;

    private Integer starLevelId;

    private Integer add;

    private Integer move;

    public Long getReId() {
        return reId;
    }

    public void setReId(Long reId) {
        this.reId = reId;
    }

    public Integer getStarLevelId() {
        return starLevelId;
    }

    public void setStarLevelId(Integer starLevelId) {
        this.starLevelId = starLevelId;
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
}
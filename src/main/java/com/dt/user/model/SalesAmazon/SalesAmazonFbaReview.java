package com.dt.user.model.SalesAmazon;

/**
 * Review
 */
public class SalesAmazonFbaReview {
    private Long reId;

    private Long date;

    private Integer shopId;

    private Integer siteId;

    private Long skuId;

    private Integer starLevelId;

    private Integer add;

    private Integer move;

    public Long getReId() {
        return reId;
    }

    public void setReId(Long reId) {
        this.reId = reId;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
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


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", reId=").append(reId);
        sb.append(", date=").append(date);
        sb.append(", shopId=").append(shopId);
        sb.append(", siteId=").append(siteId);
        sb.append(", skuId=").append(skuId);
        sb.append(", starLevelId=").append(starLevelId);
        sb.append(", add=").append(add);
        sb.append(", move=").append(move);
        sb.append("]");
        return sb.toString();
    }
}
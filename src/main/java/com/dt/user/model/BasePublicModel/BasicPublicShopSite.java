package com.dt.user.model.BasePublicModel;

/**
 * 店铺站点配置表
 */
public class BasicPublicShopSite {
    private Long shopId;
    private Long siteId;
    private Long sSeId;
    private Integer rId;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public Long getsSeId() {
        return sSeId;
    }

    public void setsSeId(Long sSeId) {
        this.sSeId = sSeId;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", shopId=").append(shopId);
        sb.append(", siteId=").append(siteId);
        sb.append(", rId=").append(rId);
        sb.append("]");
        return sb.toString();
    }
}
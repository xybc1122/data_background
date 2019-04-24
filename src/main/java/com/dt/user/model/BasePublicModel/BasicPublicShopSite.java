package com.dt.user.model.BasePublicModel;

/**
 * 店铺站点配置表
 */
public class BasicPublicShopSite {
    private Long shopId;
    private Long siteId;
    private Long id;
    private Integer rId;
    private Long statusId;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", shopId=").append(shopId);
        sb.append(", siteId=").append(siteId);
        sb.append(", id=").append(id);
        sb.append(", rId=").append(rId);
        sb.append(", statusId=").append(statusId);
        sb.append("]");
        return sb.toString();
    }
}
package com.dt.project.dto;

import com.dt.project.model.BasePublicModel.BasicPublicSku;

/**
 * @ClassName SkuDto
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 11:10
 **/
public class SkuDto extends BasicPublicSku {

    /**
     * 店铺名称
     */
    private String shopName;
    /**
     * 站点名称
     */
    private String siteName;

    /**
     * 产品名称
     */
    private String productName;
    /**
     * 订单处理类名称
     */
    private String className;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}

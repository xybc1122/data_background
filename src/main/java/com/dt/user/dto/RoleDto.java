package com.dt.user.dto;

import com.dt.user.model.Role;

/**
 * @ClassName RoleDto
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 15:21
 **/
public class RoleDto extends Role {

    private Integer currentPage;

    private Integer pageSize;

    private String userName;
    /**
     * 店铺名称
     */
    private String shopName;
    /**
     * 店铺 id 集合
     */
    private String sIds;

    /**
     * 用户ids
     */
    private String uIds;
    /**
     * 站点ids
     */
    private String seIds;
    /**
     * 区域ids
     */
    private String aids;

    public String getAids() {
        return aids;
    }

    public void setAids(String aids) {
        this.aids = aids;
    }

    public String getuIds() {
        return uIds;
    }

    public void setuIds(String uIds) {
        this.uIds = uIds;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getsIds() {
        return sIds;
    }

    public void setsIds(String sIds) {
        this.sIds = sIds;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSeIds() {
        return seIds;
    }

    public void setSeIds(String seIds) {
        this.seIds = seIds;
    }
}

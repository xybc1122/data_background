package com.dt.user.dto;

import com.dt.user.model.Role;

/**
 * @ClassName RoleDto
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 15:21
 **/
public class RoleDto  extends Role {

    private Integer currentPage;

    private Integer pageSize;

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
}

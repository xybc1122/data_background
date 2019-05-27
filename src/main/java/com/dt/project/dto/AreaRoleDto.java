package com.dt.project.dto;

import com.dt.project.model.basePublicModel.BasicPublicAreaRole;

import java.util.List;

/**
 * @ClassName AreaRoleDto
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/28 10:55
 **/
public class AreaRoleDto extends BasicPublicAreaRole {
    /**
     * 站点ids
     */
    private String seIds;
    /**
     * 区域跟站点关联表的ids
     */
    private String delSeId;
    /**
     * 对象集合
     */
    private List<AreaRoleDto> areaRoleDtoList;
    /**
     * 是否全部删除
     */
    private Boolean areaChecked;

    public Boolean getAreaChecked() {
        return areaChecked;
    }

    public void setAreaChecked(Boolean areaChecked) {
        this.areaChecked = areaChecked;
    }

    public List<AreaRoleDto> getAreaRoleDtoList() {
        return areaRoleDtoList;
    }

    public void setAreaRoleDtoList(List<AreaRoleDto> areaRoleDtoList) {
        this.areaRoleDtoList = areaRoleDtoList;
    }

    public String getSeIds() {
        return seIds;
    }

    public void setSeIds(String seIds) {
        this.seIds = seIds;
    }

    public String getDelSeId() {
        return delSeId;
    }

    public void setDelSeId(String delSeId) {
        this.delSeId = delSeId;
    }
}

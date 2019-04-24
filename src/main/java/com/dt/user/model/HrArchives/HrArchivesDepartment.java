package com.dt.user.model.HrArchives;

import com.dt.user.model.Parent.ParentTree;

/**
 * 部门管理
 */
public class HrArchivesDepartment extends ParentTree {

    private String deptNameEng;
    private Integer delFlag;


    public String getDeptNameEng() {
        return deptNameEng;
    }

    public void setDeptNameEng(String deptNameEng) {
        this.deptNameEng = deptNameEng;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}

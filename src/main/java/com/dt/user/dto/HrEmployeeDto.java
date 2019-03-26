package com.dt.user.dto;

import com.dt.user.model.HrArchives.HrArchivesEmployee;

/**
 * @ClassName HrEmployeeDto
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/25 17:00
 **/
public class HrEmployeeDto extends HrArchivesEmployee {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 部门名
     */
    private String deptName;
    /**
     * 名族名
     */
    private String nation;

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}

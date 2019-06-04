package com.dt.project.service;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.hrArchives.HrArchivesDepartment;
import com.dt.project.model.parent.ParentTree;

import java.util.List;

/**
 * @ClassName HrArchivesDepartmentService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/26 9:55
 **/
public interface HrArchivesDepartmentService {

    /**
     * 查询部门
     *
     * @return
     */
    List<ParentTree> serviceGetDepartmentInfo();


    /**
     * 通过 uid 去查找员工部门
     *
     * @return
     */
    ResponseBase serviceEmployeeName(Long uid);
}

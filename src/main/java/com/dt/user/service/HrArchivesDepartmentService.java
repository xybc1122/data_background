package com.dt.user.service;

import com.dt.user.model.ParentTree;

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
}

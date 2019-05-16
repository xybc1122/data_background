package com.dt.project.service;

import com.dt.project.dto.HrEmployeeDto;
import com.dt.project.model.HrArchives.HrArchivesEmployee;

import java.util.List;
import java.util.Map;

public interface HrArchivesEmployeeService {

    /**
     * 获取动态查询员工表信息
     */
    List<HrArchivesEmployee> serviceGetEmployeeList(HrEmployeeDto employeeDto);
    /**
     * 获得员工信息 没有关联用户的
     */
    List<HrArchivesEmployee> serviceGetHrEmployeeList();

    /**
     * 绑定用户id跟员工id信息
     */
    int bindHrInfo(Long uid, Long sid);

    /**
     * 更新员工信息
     * @param mapStaff
     * @return
     */
    int upHrInfo(Map<String, Object> mapStaff);
}

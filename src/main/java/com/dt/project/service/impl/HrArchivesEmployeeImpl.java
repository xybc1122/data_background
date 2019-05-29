package com.dt.project.service.impl;

import com.dt.project.model.dto.HrEmployeeDto;
import com.dt.project.mapper.HrArchivesEmployeeMapper;
import com.dt.project.model.hrArchives.HrArchivesEmployee;
import com.dt.project.service.HrArchivesEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HrArchivesEmployeeImpl implements HrArchivesEmployeeService {

    @Autowired
    private HrArchivesEmployeeMapper hrMapper;

    @Override
    public List<HrArchivesEmployee> serviceGetEmployeeList(HrEmployeeDto employeeDto) {
        return hrMapper.getEmployeeList(employeeDto);
    }

    @Override
    public List<HrArchivesEmployee> serviceGetHrEmployeeList() {
        return hrMapper.getHrEmployeeList();
    }

    @Override
    public int bindHrInfo(Long uid, Long sid) {
        return hrMapper.bindHrInfo(uid, sid);
    }

    @Override
    public int upHrInfo(Map<String, Object> mapStaff) {
        return hrMapper.upHrInfo(mapStaff);
    }
}

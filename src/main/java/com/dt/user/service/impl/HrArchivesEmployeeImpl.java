package com.dt.user.service.impl;

import com.dt.user.dto.HrEmployeeDto;
import com.dt.user.mapper.HrArchivesEmployeeMapper;
import com.dt.user.model.HrArchives.HrArchivesEmployee;
import com.dt.user.service.HrArchivesEmployeeService;
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

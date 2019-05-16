package com.dt.project.service.impl;

import com.dt.project.mapper.BasePublicMapper.BasicHrEmployeeTypeMapper;
import com.dt.project.model.BasePublicModel.BasicHrEmployeeType;
import com.dt.project.service.BasePublicService.BasicHrEmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicHrEmployeeTypeServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 14:27
 **/
@Service
public class BasicHrEmployeeTypeServiceImpl implements BasicHrEmployeeTypeService {
    @Autowired
    private BasicHrEmployeeTypeMapper employeeTypeMapper;

    @Override
    public List<BasicHrEmployeeType> serviceFndByListHrEmp() {
        return employeeTypeMapper.findByListHrEmp();
    }
}
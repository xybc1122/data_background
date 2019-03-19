package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicHrEmployeeTypeMapper;
import com.dt.user.model.BasePublicModel.BasicHrEmployeeType;
import com.dt.user.service.BasePublicService.BasicHrEmployeeTypeService;
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

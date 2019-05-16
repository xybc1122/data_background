package com.dt.project.service.impl;

import com.dt.project.mapper.BasePublicMapper.BasicPublicProvinceCityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicPublicProvinceCityServiceImpl {

    @Autowired
    private BasicPublicProvinceCityMapper cityMapper;
}

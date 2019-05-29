package com.dt.project.service.impl;

import com.dt.project.mapper.basePublicMapper.BasicPublicProvinceMapper;
import com.dt.project.service.basePublicService.BasicPublicProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicPublicProvinceServiceImpl implements BasicPublicProvinceService {

    @Autowired
    private BasicPublicProvinceMapper provinceMapper;

}

package com.dt.project.service.impl;

import com.dt.project.mapper.basePublicMapper.BasicPublicUnitMapper;
import com.dt.project.service.basePublicService.BasicPublicMeasurementUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicPublicMeasurementUnitImpl implements BasicPublicMeasurementUnitService {
    @Autowired
    private BasicPublicUnitMapper unitMapper;

}

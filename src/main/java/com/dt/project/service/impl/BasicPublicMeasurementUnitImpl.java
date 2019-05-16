package com.dt.project.service.impl;

import com.dt.project.mapper.BasePublicMapper.BasicPublicUnitMapper;
import com.dt.project.service.BasePublicService.BasicPublicMeasurementUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicPublicMeasurementUnitImpl implements BasicPublicMeasurementUnitService {
    @Autowired
    private BasicPublicUnitMapper unitMapper;

}

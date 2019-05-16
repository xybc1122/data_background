package com.dt.project.service.impl;

import com.dt.project.mapper.BasePublicMapper.BasicLogisticsmgtTransportPropertyMapper;
import com.dt.project.model.BasePublicModel.BasicLogisticsmgtTransportProperty;
import com.dt.project.service.BasePublicService.BasicLogisticsmgtTransportPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicLogisticsmgtTransportPropertyServiceImpl implements BasicLogisticsmgtTransportPropertyService {

    @Autowired
    private BasicLogisticsmgtTransportPropertyMapper propertyMapper;

    @Override
    public List<BasicLogisticsmgtTransportProperty> findByListProperty() {
        return propertyMapper.findByListProperty();
    }
}

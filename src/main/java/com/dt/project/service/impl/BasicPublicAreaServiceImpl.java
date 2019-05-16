package com.dt.project.service.impl;

import com.dt.project.dto.AreaDto;
import com.dt.project.mapper.BasePublicMapper.BasicPublicAreaMapper;
import com.dt.project.model.BasePublicModel.BasicPublicArea;
import com.dt.project.service.BasePublicService.BasicPublicAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicPublicAreaServiceImpl implements BasicPublicAreaService {

    @Autowired
    private BasicPublicAreaMapper areaMapper;

    @Override
    public List<AreaDto> findByListArea() {
        return areaMapper.findByListArea();
    }

    @Override
    public List<BasicPublicArea> selectRegion(String rid) {
        return areaMapper.selectRegion(rid);
    }

}
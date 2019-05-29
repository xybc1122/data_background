package com.dt.project.service.impl;

import com.dt.project.mapper.basePublicMapper.BasicHrEmploymentTypeMapper;
import com.dt.project.model.basePublicModel.BasicHrEmploymentType;
import com.dt.project.service.basePublicService.BasicHrEmploymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicHrEmploymentTypeServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 14:27
 **/
@Service
public class BasicHrEmploymentTypeServiceImpl implements BasicHrEmploymentTypeService {
    @Autowired
    private BasicHrEmploymentTypeMapper mentTypeMapper;

    @Override
    public List<BasicHrEmploymentType> serviceFindByListHrEmployment() {
        return mentTypeMapper.findByListHrEmployment();
    }
}

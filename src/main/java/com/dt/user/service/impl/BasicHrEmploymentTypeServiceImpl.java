package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicHrEmploymentTypeMapper;
import com.dt.user.model.BasePublicModel.BasicHrEmploymentType;
import com.dt.user.service.BasePublicService.BasicHrEmploymentTypeService;
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

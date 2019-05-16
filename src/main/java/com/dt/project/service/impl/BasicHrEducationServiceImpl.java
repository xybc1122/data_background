package com.dt.project.service.impl;

import com.dt.project.mapper.BasePublicMapper.BasicHrEducationMapper;
import com.dt.project.model.BasePublicModel.BasicHrEducation;
import com.dt.project.service.BasePublicService.BasicHrEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicHrEducationServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 14:26
 **/
@Service
public class BasicHrEducationServiceImpl implements BasicHrEducationService {
    @Autowired
    private BasicHrEducationMapper educationMapper;

    @Override
    public List<BasicHrEducation> serviceFindByListHrEdu() {
        return educationMapper.findByListHrEdu();
    }
}

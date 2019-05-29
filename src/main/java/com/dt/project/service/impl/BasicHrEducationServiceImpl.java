package com.dt.project.service.impl;

import com.dt.project.mapper.basePublicMapper.BasicHrEducationMapper;
import com.dt.project.model.basePublicModel.BasicHrEducation;
import com.dt.project.service.basePublicService.BasicHrEducationService;
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

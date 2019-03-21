package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicHrEducationMapper;
import com.dt.user.model.BasePublicModel.BasicHrEducation;
import com.dt.user.service.BasePublicService.BasicHrEducationService;
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

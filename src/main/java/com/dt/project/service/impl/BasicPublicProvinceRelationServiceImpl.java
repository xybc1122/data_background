package com.dt.project.service.impl;

import com.dt.project.mapper.basePublicMapper.BasicPublicProvinceRelationMapper;
import com.dt.project.model.basePublic.BasicPublicProvinceRelation;
import com.dt.project.service.basePublicService.BasicPublicProvinceRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicPublicProvinceRelationServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/21 10:51
 **/
@Service
public class BasicPublicProvinceRelationServiceImpl implements BasicPublicProvinceRelationService {
    @Autowired
    private BasicPublicProvinceRelationMapper relationMapper;


    @Override
    public List<BasicPublicProvinceRelation> serviceFindByRelationList(BasicPublicProvinceRelation relation) {
        return relationMapper.findByRelationList(relation);
    }
}

package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicPublicProvinceRelationMapper;
import com.dt.user.model.BasePublicModel.BasicPublicProvinceRelation;
import com.dt.user.service.BasePublicService.BasicPublicProvinceRelationService;
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

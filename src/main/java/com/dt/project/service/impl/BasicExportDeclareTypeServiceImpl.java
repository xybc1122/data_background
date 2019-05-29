package com.dt.project.service.impl;

import com.dt.project.mapper.basePublicMapper.BasicExportDeclareTypeMapper;
import com.dt.project.model.basePublicModel.BasicExportDeclareType;
import com.dt.project.service.basePublicService.BasicExportDeclareTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicExportDeclareTypeServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 13:18
 **/
@Service
public class BasicExportDeclareTypeServiceImpl implements BasicExportDeclareTypeService {
    @Autowired
    private BasicExportDeclareTypeMapper declareTypeMapper;

    @Override
    public List<BasicExportDeclareType> serviceFindByListDeclare() {
        return declareTypeMapper.findByListDeclare();
    }
}

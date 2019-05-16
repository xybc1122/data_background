package com.dt.project.service.impl;

import com.dt.project.mapper.BasePublicMapper.BasicExportPackingTypeMapper;
import com.dt.project.model.BasePublicModel.BasicExportPackingType;
import com.dt.project.service.BasePublicService.BasicExportPackingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicExportPackingTypeServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/25 8:48
 **/
@Service
public class BasicExportPackingTypeServiceImpl implements BasicExportPackingTypeService {
    @Autowired
    private BasicExportPackingTypeMapper packingTypeMapper;

    @Override
    public List<BasicExportPackingType> serviceFindByPackingTypeInfo() {
        return packingTypeMapper.findByPackingTypeInfo();
    }
}

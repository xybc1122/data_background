package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicExportPackingTypeMapper;
import com.dt.user.model.BasePublicModel.BasicExportPackingType;
import com.dt.user.service.BasePublicService.BasicExportPackingTypeService;
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

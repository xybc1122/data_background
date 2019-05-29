package com.dt.project.service.impl;

import com.dt.project.mapper.basePublicMapper.BasicSalesPublicBrushTypeMapper;
import com.dt.project.model.basePublicModel.BasicSalesPublicBrushType;
import com.dt.project.service.basePublicService.BasicSalesPublicBrushTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicSalesPublicBrushTypeServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/21 15:59
 **/
@Service
public class BasicSalesPublicBrushTypeServiceImpl implements BasicSalesPublicBrushTypeService {
    @Autowired
    private BasicSalesPublicBrushTypeMapper brushTypeMapper;

    @Override
    public List<BasicSalesPublicBrushType> serviceFindByBrushTypeInfo() {
        return brushTypeMapper.findByBrushTypeInfo();
    }
}

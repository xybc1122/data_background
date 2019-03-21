package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicSalesPublicBrushTypeMapper;
import com.dt.user.model.BasePublicModel.BasicSalesPublicBrushType;
import com.dt.user.service.BasePublicService.BasicSalesPublicBrushTypeService;
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

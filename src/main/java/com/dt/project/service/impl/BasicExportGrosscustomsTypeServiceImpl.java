package com.dt.project.service.impl;

import com.dt.project.mapper.BasePublicMapper.BasicExportGrosscustomsTypeMapper;
import com.dt.project.model.BasePublicModel.BasicExportGrosscustomsType;
import com.dt.project.service.BasePublicService.BasicExportGrosscustomsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicExportGrosscustomsTypeServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 13:25
 **/
@Service
public class BasicExportGrosscustomsTypeServiceImpl implements BasicExportGrosscustomsTypeService {
    @Autowired
    private BasicExportGrosscustomsTypeMapper grosscustomsTypeMapper;

    @Override
    public List<BasicExportGrosscustomsType> serviceFindByListGrosscustoms() {
        return grosscustomsTypeMapper.findByListGrosscustoms();
    }
}

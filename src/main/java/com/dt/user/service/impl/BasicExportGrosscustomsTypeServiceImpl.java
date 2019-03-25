package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicExportGrosscustomsTypeMapper;
import com.dt.user.model.BasePublicModel.BasicExportGrosscustomsType;
import com.dt.user.service.BasePublicService.BasicExportGrosscustomsTypeService;
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

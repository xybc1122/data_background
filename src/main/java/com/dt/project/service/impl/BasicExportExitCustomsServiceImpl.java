package com.dt.project.service.impl;

import com.dt.project.mapper.basePublicMapper.BasicExportExitCustomsMapper;
import com.dt.project.model.basePublicModel.BasicExportExitCustoms;
import com.dt.project.service.basePublicService.BasicExportExitCustomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicExportExitCustomsServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/25 10:54
 **/
@Service
public class BasicExportExitCustomsServiceImpl implements BasicExportExitCustomsService {

    @Autowired
    private BasicExportExitCustomsMapper customsMapper;

    @Override
    public List<BasicExportExitCustoms> serviceFindByExitCustomsList(BasicExportExitCustoms customs) {
        return customsMapper.findByExitCustomsList(customs);
    }

}

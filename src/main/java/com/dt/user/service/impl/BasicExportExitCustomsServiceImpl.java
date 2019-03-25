package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicExportExitCustomsMapper;
import com.dt.user.model.BasePublicModel.BasicExportExitCustoms;
import com.dt.user.service.BasePublicService.BasicExportExitCustomsService;
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

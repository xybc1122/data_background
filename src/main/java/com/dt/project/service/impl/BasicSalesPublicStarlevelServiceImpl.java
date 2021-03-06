package com.dt.project.service.impl;

import com.dt.project.mapper.basePublicMapper.BasicSalesPublicStarlevelMapper;
import com.dt.project.model.basePublic.BasicSalesPublicStarlevel;
import com.dt.project.service.basePublicService.BasicSalesPublicStarlevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicSalesPublicStarlevelServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/20 13:38
 **/
@Service
public class BasicSalesPublicStarlevelServiceImpl implements BasicSalesPublicStarlevelService {
    @Autowired
    private BasicSalesPublicStarlevelMapper starlevelMapper;

    @Override
    public List<BasicSalesPublicStarlevel> serviceFindByListStarlevel() {
        return starlevelMapper.findByListStarlevel();
    }
}

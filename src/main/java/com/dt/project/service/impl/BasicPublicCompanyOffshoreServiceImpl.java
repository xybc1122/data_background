package com.dt.project.service.impl;

import com.dt.project.mapper.BasePublicMapper.BasicPublicCompanyOffshoreMapper;
import com.dt.project.model.BasePublicModel.BasicPublicCompanyOffshore;
import com.dt.project.service.BasePublicService.BasicPublicCompanyOffshoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicPublicCompanyOffshoreServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/26 14:15
 **/
@Service
public class BasicPublicCompanyOffshoreServiceImpl implements BasicPublicCompanyOffshoreService {
    @Autowired
    private BasicPublicCompanyOffshoreMapper offshoreMapper;

    @Override
    public List<BasicPublicCompanyOffshore> serviceFindByListOffshore() {
        return offshoreMapper.findByListOffshore();
    }
}

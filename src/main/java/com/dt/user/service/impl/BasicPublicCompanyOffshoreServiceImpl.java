package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicPublicCompanyOffshoreMapper;
import com.dt.user.model.BasePublicModel.BasicPublicCompanyOffshore;
import com.dt.user.service.BasePublicService.BasicPublicCompanyOffshoreService;
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

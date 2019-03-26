package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicHrNationMapper;
import com.dt.user.model.BasePublicModel.BasicHrNation;
import com.dt.user.service.BasePublicService.BasicHrNationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicHrNationServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/26 13:56
 **/
@Service
public class BasicHrNationServiceImpl implements BasicHrNationService {
    @Autowired
    private BasicHrNationMapper nationMapper;

    @Override
    public List<BasicHrNation> serviceFindByListHrNation() {
        return nationMapper.findByListHrNation();
    }
}

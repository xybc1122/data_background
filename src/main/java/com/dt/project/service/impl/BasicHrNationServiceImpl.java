package com.dt.project.service.impl;

import com.dt.project.mapper.basePublicMapper.BasicHrNationMapper;
import com.dt.project.model.basePublic.BasicHrNation;
import com.dt.project.service.basePublicService.BasicHrNationService;
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

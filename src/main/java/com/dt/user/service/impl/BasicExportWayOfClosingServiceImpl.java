package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicExportWayOfClosingMapper;
import com.dt.user.model.BasePublicModel.BasicExportWayOfClosing;
import com.dt.user.service.BasePublicService.BasicExportWayOfClosingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicExportWayOfClosingServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/25 10:32
 **/
@Service
public class BasicExportWayOfClosingServiceImpl implements BasicExportWayOfClosingService {
    @Autowired
    private BasicExportWayOfClosingMapper closingMapper;
    @Override
    public List<BasicExportWayOfClosing> serviceFindByWayOfInfo() {
        return closingMapper.findByWayOfInfo();
    }
}

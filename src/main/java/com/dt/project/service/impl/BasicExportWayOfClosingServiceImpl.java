package com.dt.project.service.impl;

import com.dt.project.mapper.basePublicMapper.BasicExportWayOfClosingMapper;
import com.dt.project.model.basePublic.BasicExportWayOfClosing;
import com.dt.project.service.basePublicService.BasicExportWayOfClosingService;
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

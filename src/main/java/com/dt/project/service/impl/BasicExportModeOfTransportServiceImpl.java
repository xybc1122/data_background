package com.dt.project.service.impl;

import com.dt.project.mapper.BasePublicMapper.BasicExportModeOfTransportMapper;
import com.dt.project.model.BasePublicModel.BasicExportModeOfTransport;
import com.dt.project.service.BasePublicService.BasicExportModeOfTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicExportModeOfTransportServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/25 9:39
 **/
@Service
public class BasicExportModeOfTransportServiceImpl implements BasicExportModeOfTransportService {
    @Autowired
    private BasicExportModeOfTransportMapper transportMapper;

    @Override
    public List<BasicExportModeOfTransport> serviceFindByModeOfInfo() {
        return transportMapper.findByModeOfInfo();
    }
}

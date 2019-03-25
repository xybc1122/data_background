package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicExportModeOfTransportMapper;
import com.dt.user.model.BasePublicModel.BasicExportModeOfTransport;
import com.dt.user.service.BasePublicService.BasicExportModeOfTransportService;
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
